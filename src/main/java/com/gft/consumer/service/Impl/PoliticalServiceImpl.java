package com.gft.consumer.service.Impl;

import com.gft.consumer.web.rest.vm.LoginVM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PoliticalServiceImpl {

    private static final String BEARER = "Bearer ";

    @Autowired
    private WebClient webClient;

//The routes made are read-only and there was no reason to map them in this circumstance. It makes no difference
// to return a String as I did. However, as an example I made a route that takes
// one and map it. Below is commented on its implementation.

//    public PoliticalVM requestAPI(Long id) {
//
//        Mono<PoliticalVM> monoPolitical = webClient
//                .method(HttpMethod.GET)
//                .uri("/politicians/{id}", id)
//                .retrieve()
//                .bodyToMono(PoliticalVM.class);
//
//        return monoPolitical.block();
//    }


    public String getAllPoliticiansAscendingAlphabeticalByname(String electivePositionType, String authorization, Long page, Long size) {
        Mono<String> monoPolitical = webClient
                .method(HttpMethod.GET)
                .uri("/politicians/users?electivePositionType={electivePositionType}&sort=name,asc&page={page}&size={size}", electivePositionType, page, size)
                .headers(headers -> headers.setBearerAuth(authorization.startsWith(BEARER) ? authorization.substring(7) : authorization))
                .retrieve()
                .bodyToMono(String.class);
        return monoPolitical.block();
    }


    public String getAllPoliticiansDescendingAlphabeticalByname(String electivePositionType, String authorization, Long page, Long size) {
        Mono<String> monoPolitical = webClient
                .method(HttpMethod.GET)
                .uri("/politicians/users?electivePositionType={electivePositionType}&sort=name,desc&page={page}&size={size}", electivePositionType, page, size)
                .headers(headers -> headers.setBearerAuth(authorization.startsWith(BEARER) ? authorization.substring(7) : authorization))
                .retrieve()
                .bodyToMono(String.class);
        return monoPolitical.block();
    }


    public String getAllPoliticiansByTheNumberOfLaws(String electivePositionType, String numberOfLaws, String authorization, Long page, Long size) {
        Mono<String> monoPolitical = webClient
                .method(HttpMethod.GET)
                .uri("/politicians/users/{numberOfLaws}?electivePositionType={electivePositionType}&page={page}&size={size}", numberOfLaws, electivePositionType, page, size)
                .headers(headers -> headers.setBearerAuth(authorization.startsWith(BEARER) ? authorization.substring(7) : authorization))
                .retrieve()
                .bodyToMono(String.class);
        return monoPolitical.block();
    }

    public String getAllPoliticiansById(String electivePositionType, String id,  String authorization, Long page, Long size) {
        Mono<String> monoPolitical = webClient
                .method(HttpMethod.GET)
                .uri("/politicians/users?electivePositionType={electivePositionType}&id={id}&page={page}&size={size}", electivePositionType, id, page, size)
                .headers(headers -> headers.setBearerAuth(authorization.startsWith(BEARER) ? authorization.substring(7) : authorization))
                .retrieve()
                .bodyToMono(String.class);
        return monoPolitical.block();
    }


    public String getJWT(LoginVM loginVM) {
        Mono<String> monoPolitical = webClient
                .method(HttpMethod.POST)
                .uri("/authenticate")
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(loginVM))
                .retrieve()
                .bodyToMono(String.class);
        return monoPolitical.block().substring(13, 217);
    }

}
