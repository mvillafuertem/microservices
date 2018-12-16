package com.mvillafuertem.services.authentication.management.configuration.infrastructure

import com.mvillafuertem.services.authentication.management.infrastructure.CassandraAuthenticationManagementRepository

final class InfrastructureConfiguration {

  val authenticationManagementRepository = new CassandraAuthenticationManagementRepository

}
