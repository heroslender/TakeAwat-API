package com.heroslender.takeawat.rest;

public record RestResponseStatusError(
        short status,
        long timestamp,
        long elapsed,
        int errorCode,
        String errorMessage
) implements RestResponseStatus {
}
