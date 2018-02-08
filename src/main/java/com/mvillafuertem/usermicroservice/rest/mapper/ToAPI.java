package com.mvillafuertem.usermicroservice.rest.mapper;

public interface ToAPI<S, D> {
    D map(S source);
}
