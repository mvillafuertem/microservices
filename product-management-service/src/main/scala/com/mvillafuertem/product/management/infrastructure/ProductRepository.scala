package com.mvillafuertem.product.management.infrastructure

import com.mvillafuertem.product.management.configuration.ProductProperties
import com.mvillafuertem.product.management.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductRepository @Autowired()(productProperties: ProductProperties) {

  def getProduct: Product = Product("${productProperties.first}")

}
