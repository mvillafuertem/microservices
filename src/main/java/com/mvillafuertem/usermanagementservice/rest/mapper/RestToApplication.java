package com.mvillafuertem.usermanagementservice.rest.mapper;

public interface RestToApplication<R, A> {
    R mapApplication(A applicationSource);
    A mapRest(R restSource);
}
