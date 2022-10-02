package com.heroslender.takeawat.response;

public record ResponseEntityError(
        int errorCode,
        String errorMessage
) {
}
