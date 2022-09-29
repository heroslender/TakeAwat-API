package com.heroslender.takeawat.rest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public record RestResponseStatusError(
        short status,
        long timestamp,
        long elapsed,
        int errorCode,
        String errorMessage
) implements RestResponseStatus {
}
