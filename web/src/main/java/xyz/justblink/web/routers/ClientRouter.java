package xyz.justblink.web.routers;

import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.*;
import reactor.netty.http.server.HttpServer;
import xyz.justblink.web.handlers.ClientHandler;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class ClientRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ClientHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/client").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                handler::onRequest);
    }

}
