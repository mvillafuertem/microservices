package com.mvillafuertem.usermanagementservice.api.mapper;

public interface RestToApplication<R, A> {
    R mapApplication(A applicationSource);
    A mapRest(R restSource);
}
