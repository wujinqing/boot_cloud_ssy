package com.wujinqing.boot.websocket;

public class DefaultEchoService implements EchoService {
    @Override
    public String getMessage(String message) {
        return message;
    }
}
