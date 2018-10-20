package com.mvillafuertem.product.management.configuration

import javax.validation.constraints.NotNull
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

import scala.beans.BeanProperty

@Configuration
@ConfigurationProperties("product")
class ProductProperties {

  @BeanProperty
  var first: String = _

}
