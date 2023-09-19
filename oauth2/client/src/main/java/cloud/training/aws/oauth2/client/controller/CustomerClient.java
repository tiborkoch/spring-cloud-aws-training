package cloud.training.aws.oauth2.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import cloud.training.aws.oauth2.client.dto.CustomerData;
import cloud.training.aws.oauth2.client.dto.CreateCustomerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@HttpExchange("/api/customers")
public interface CustomerClient {

    @GetExchange
    Flux<CustomerData> listCustomers();

    @PostExchange
    Mono<ResponseEntity<CustomerData>> createEmployee(@RequestBody Mono<CreateCustomerRequest> command);
}