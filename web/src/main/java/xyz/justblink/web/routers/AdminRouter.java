package xyz.justblink.web.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import xyz.justblink.web.handlers.AdminHandler;

@Configuration
public class AdminRouter {

    @Bean
    public RouterFunction<ServerResponse> routeAdmin(AdminHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/admin").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                handler::onRequest);
    }
}
