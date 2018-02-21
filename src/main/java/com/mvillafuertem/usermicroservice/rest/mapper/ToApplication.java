package com.mvillafuertem.usermicroservice.rest.mapper;

public interface FromApplication<S, D> {
    D fromMap(S source);
    S mapTo(D destination);
}
