package com.heroslender.takeawat.rest;

public interface RestResponseStatus {
    static RestResponseStatus success() {
        return success(200);
    }

    static RestResponseStatus success(int status) {
        return success(status, System.currentTimeMillis(), 0);
    }

    static RestResponseStatus success(int status, long timestamp, long elapsed) {
        return new RestResponseStatusSuccess((short) status, timestamp, elapsed);
    }

    static RestResponseStatus failure(int status, long timestamp, long elapsed, int errorCode, String errorMessage) {
        return error(status, timestamp, elapsed, errorCode, errorMessage);
    }

    static RestResponseStatus error(int errorCode, String errorMessage) {
        return error(500, errorCode, errorMessage);
    }

    static RestResponseStatus error(int status, int errorCode, String errorMessage) {
        return error(status, System.currentTimeMillis(), 0, errorCode, errorMessage);
    }

    static RestResponseStatus error(int status, long timestamp, long elapsed, int errorCode, String errorMessage) {
        return new RestResponseStatusError((short) status, timestamp, elapsed, errorCode, errorMessage);
    }

    short status();

    long timestamp();

    long elapsed();
}
