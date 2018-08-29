package com.project.microservices.StatisticsMicroservice.utilities;

import com.project.microservices.StatisticsMicroservice.entities.Statistics;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class JsonResponseBody {

    @Getter
    @Setter
    private  int server;
    @Getter @Setter
    private Object response;

    public JsonResponseBody() {
    }

    public JsonResponseBody(int server, Object response) {
        this.server = server;
        this.response = response;
    }

    public Object getResponse() {
        return response;
    }
}


//http response -> java object ResponseEntity<JsonResponseBody>

//header (jwt)

//body - html page or a JsonMessage(JsonResponseBody(int server, Object response))

