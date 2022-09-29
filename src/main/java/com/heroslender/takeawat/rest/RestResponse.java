package com.heroslender.takeawat.rest;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@AllArgsConstructor
public record RestResponse<T>(@NotNull RestResponseStatus status, @Nullable T data) {
}
