package com.heroslender.takeawat.rest;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public record RestResponse<T>(@NotNull RestResponseStatus status, @Nullable T data) {
}
