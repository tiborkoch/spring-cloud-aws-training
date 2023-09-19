package cloud.training.aws.oauth2.client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;

import cloud.training.aws.oauth2.client.dto.CreateCustomerRequest;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerClient customerClient;

    @GetMapping("/")
    public Mono<Rendering> home(Model model) {
        return Mono.just(Rendering.view("index").build())
                .log();
    }

    @GetMapping("/customers")
    public Mono<Rendering> customerList(Model model) {
        return Mono.just(
                Rendering.view("customers")
                        .modelAttribute("customers", customerClient.listCustomers())
                        .modelAttribute("command", Mono.just(new CreateCustomerRequest()))
                        .build()
        );
    }

    @PostMapping("/customers")
    public Mono<Rendering> createCustomerPost(Mono<CreateCustomerRequest> command) {
        // Nincs Flash attribute: https://github.com/spring-projects/spring-framework/issues/20575
        return customerClient
                .createEmployee(command).map(user -> Rendering.redirectTo("/customers").build());
    }

    @GetMapping("/user")
    public Mono<Rendering> user(Model model, OAuth2AuthenticationToken token, Authentication auth) {
        return Mono.just(Rendering.view("user").build())
                .log();
    }
}
