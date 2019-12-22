package xyz.justblink.web.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import xyz.justblink.common.repository.TestBlinkRepository;

@Component
public class ClientHandler {

    @Autowired
    private TestBlinkRepository testRepository;

    public Mono<ServerResponse> onRequest(ServerRequest request) {
//        Test test =  new Test();
//        test.setName("Kasun");
//        test.setEmail("hello@gmail.com");
//        testRepository.save(test);
        testRepository.findByEmailLikeMine("%hello%").forEach(test -> {
            System.out.println(test.getName());
        });
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromValue("Hello Kasun"));
    }
}
