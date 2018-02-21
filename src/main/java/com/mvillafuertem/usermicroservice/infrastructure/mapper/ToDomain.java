package com.mvillafuertem.usermicroservice.infrastructure.mapper;

public interface ToDomain<I, D> {

    D mapInfrastructure(I infrastructureSource);
    I mapDomain(D domainSource);
}
