package com.example.client.service;

import com.example.client.domain.UserRequest;
import com.example.client.domain.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    public UserResponse hello() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9080")
                .path("/api/server/hello")
                .queryParam("name", "steve")
                .queryParam("age", 10)
                .encode()
                .build()
                .toUri();

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        //String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<UserResponse> result = restTemplate.getForEntity(uri, UserResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());

        return result.getBody();
    }

    public UserResponse post() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9080")
                .path("/api/server/user/{userId}/name/{userName}")
                .encode()
                .build()
                .expand(10, "test")
                .toUri();

        System.out.println(uri);

        UserRequest req = new UserRequest();
        req.setName("test");
        req.setAge(10);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = restTemplate.postForEntity(uri, req, UserResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();
    }
}
