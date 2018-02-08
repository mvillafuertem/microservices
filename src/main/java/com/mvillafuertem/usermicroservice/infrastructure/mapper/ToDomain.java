package com.mvillafuertem.usermicroservice.infrastructure.mapper;

public interface ToDomain<I, D> {

    D mapInfra(I infrastructureSource);
    I mapDomain(D domainSource);
}
