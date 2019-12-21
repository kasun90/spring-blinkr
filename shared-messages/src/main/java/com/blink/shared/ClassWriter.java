package com.blink.shared;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.function.BiConsumer;

public class ClassWriter implements AutoCloseable {
    private Context context;
    private FileWriter fileWriter;
    private PrintWriter printWriter;
    private int indentCount = 0;
    private String currentIndent = "";
    private StringBuilder indentBuilder = new StringBuilder();

    public ClassWriter(Context context) throws IOException {
        this.context = context;
        File file = new File(context.getFileName());
        file.getParentFile().mkdirs();
        fileWriter = new FileWriter(file);
        printWriter = new PrintWriter(fileWriter, true);
    }

    public void start() {
        startLine().print("package ").print(context.getPackageName()).println(";")
                .println();

        switch (context.getType()) {
            case CLASS:
                writeClass();
                break;
            case ENUM:
                writeEnum();
                break;
            default:
                break;
        }
    }

    private void writeEnum() {
        startLine().print("public enum ").print(context.getClassName()).println(" {");
        plusIndent();

        List<String> cases = context.getCases();
        while (!cases.isEmpty()) {
            String caseName = cases.remove(0);
            startLine().print(caseName);
            if (!cases.isEmpty())
                print(",");
            println();
        }

        minusIndent();
        startLine().print("}");
    }

    private void writeClass() {
        //imports
        context.getImports().forEach(value -> {
            startLine().print("import ").print(value).println(";");
        });

        println();

        //define class
        startLine().print("public class ").print(context.getClassName());
        if (context.getExtendClassName() != null)
            print(" extends ").print(context.getExtendClassName());
        println(" {");
        plusIndent();

        context.getFields().forEach((name, type) -> {
            startLine().print("private ").print(type).print(" ").print(name).println(";");
        });

        println();

        //write empty constructor
        if (!context.getFields().isEmpty())
            startLine().print("public ").print(context.getClassName()).println("() {}").println();

        //constructor start
        startLine().print("public ").print(context.getClassName()).print("(");

        context.getExtendFields().forEach(new BiConsumer<>() {
            boolean isFirst = true;

            @Override
            public void accept(String name, String type) {
                if (!isFirst)
                    print(", ");
                print(type).print(" ").print(name);

                if (isFirst)
                    isFirst = false;
            }
        });

        context.getFields().forEach(new BiConsumer<>() {
            boolean isFirst = context.getExtendClassName() == null;

            @Override
            public void accept(String name, String type) {
                if (!isFirst)
                    print(", ");
                print(type).print(" ").print(name);

                if (isFirst)
                    isFirst = false;
            }
        });


        println(") {");

        plusIndent();

        if (context.getExtendClassName() != null) {
            startLine().print("super(");

            context.getExtendFields().forEach(new BiConsumer<>() {
                boolean isFirst = true;

                @Override
                public void accept(String name, String type) {
                    if (!isFirst)
                        print(", ");
                    print(name);
                    isFirst = false;
                }
            });

            println(");");
        }

        context.getFields().forEach((name, type) -> startLine().print("this.").print(name).print(" = ").print(name).println(";"));
        minusIndent();

        startLine().println("}");

        //constructor end

        //extend getter setter start

        context.getExtendFields().forEach((name, type) -> {
            println();
            //getter
            String getterForType;
            if (type.equals("boolean"))
                getterForType = "is";
            else
                getterForType = "get";
            startLine().print("public ").print(type).print(" ").print(getterForType).print(StringUtils.capitalize(name)).println("() {");
            plusIndent();
            startLine().print("return super.").print(getterForType).print(StringUtils.capitalize(name)).println("();");
            minusIndent();
            startLine().println("}");
            println();

            //setter
            startLine().print("public ").print(context.getClassName()).print(" set").print(StringUtils.capitalize(name))
                    .print("(").print(type).print(" ").print(name).println(") {");
            plusIndent();
            startLine().print("super.set").print(StringUtils.capitalize(name)).print("(").print(name).println(");");
            startLine().println("return this;");
            minusIndent();
            startLine().println("}");
        });

        //extend getter setter end

        //getter setter start

        context.getFields().forEach((name, type) -> {
            println();
            //getter
            String getterForType;
            if (type.equals("boolean"))
                getterForType = " is";
            else
                getterForType = " get";
            startLine().print("public ").print(type).print(getterForType).print(StringUtils.capitalize(name)).println("() {");
            plusIndent();
            startLine().print("return ").print(name).println(";");
            minusIndent();
            startLine().println("}");
            println();

            //setter
            startLine().print("public ").print(context.getClassName()).print(" set").print(StringUtils.capitalize(name))
                    .print("(").print(type).print(" ").print(name).println(") {");
            plusIndent();
            startLine().print("this.").print(name).print(" = ").print(name).println(";");
            startLine().println("return this;");
            minusIndent();
            startLine().println("}");
        });

        //getter setter end

        //toString start
        println();
        startLine().println("@Override");
        startLine().println("public String toString() {");
        plusIndent();
        startLine().println("return BlinkJSON.toPrettyJSON(this);");
        minusIndent();
        startLine().println("}");
        //toString end

        minusIndent();
        startLine().print("}");
    }


    private void plusIndent() {
        indentCount++;
        createIndent();
    }

    private void minusIndent() {
        indentCount--;
        createIndent();
    }

    private void createIndent() {
        indentBuilder.setLength(0);
        for (int i = 0; i < indentCount; i++) {
            indentBuilder.append("\t");
        }
        currentIndent = indentBuilder.toString();
    }

    private ClassWriter print(String s) {
        printWriter.print(s);
        return this;
    }

    private ClassWriter println() {
        printWriter.println();
        return this;
    }

    private ClassWriter println(String s) {
        printWriter.println(s);
        return this;
    }

    private ClassWriter startLine() {
        print(currentIndent);
        return this;
    }


    @Override
    public void close() throws Exception {
        fileWriter.close();
        printWriter.close();
    }
}
