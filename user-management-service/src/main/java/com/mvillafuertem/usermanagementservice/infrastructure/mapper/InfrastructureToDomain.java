package com.mvillafuertem.usermanagementservice.infrastructure.mapper;

public interface InfrastructureToDomain<I, D> {

    D mapInfrastructure(I infrastructureSource);
    I mapDomain(D domainSource);
}
