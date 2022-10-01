package com.heroslender.takeawat.rest;

public record RestResponseStatusSuccess(
        short status,
        long timestamp,
        long elapsed
) implements RestResponseStatus {
}
