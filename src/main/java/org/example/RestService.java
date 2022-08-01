package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class RestService {
    private final RestTemplate restTemplate;
    private final String serverUrl = "http://localhost:8080/";
    @Autowired
    public RestService(RestTemplate restTemplate
            /*, @Value("${rest.server.url}") String serverUrl*/) {
        this.restTemplate = restTemplate;
//        this.serverUrl = serverUrl;
    }

    public List<String> getListEntity() {
        ResponseEntity<List<String>> response =
                restTemplate.exchange(serverUrl, HttpMethod.GET, null, new ParameterizedTypeReference<>(){});
        return response.getBody();
    }

    public void postEntity(String entity) {
        restTemplate.put(serverUrl, entity);
    }
}
