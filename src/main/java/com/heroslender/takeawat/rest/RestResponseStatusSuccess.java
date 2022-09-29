package com.heroslender.takeawat.rest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public record RestResponseStatusSuccess(
        short status,
        long timestamp,
        long elapsed
) implements RestResponseStatus {
}
