package com.mvillafuertem.services.loyalty.program.configuration.infrastructure

final class InfrastructureConfiguration {

  val authenticationManagementRepository = new CassandraAuthenticationManagementRepository

}
