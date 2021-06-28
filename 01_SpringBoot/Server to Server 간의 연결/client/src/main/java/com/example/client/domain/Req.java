package com.example.client.domain;

import lombok.Data;

@Data
public class Req<T> {

    private Header header;

    private T body;

    public static class Header {
        private String responseCode;
    }
}
