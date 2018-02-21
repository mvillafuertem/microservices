package com.mvillafuertem.usermicroservice.rest.mapper;

public interface ToApplication<R, A> {
    R mapApplication(A applicationSource);
    A mapRest(R restSource);
}
