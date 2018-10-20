package com.mvillafuertem.product.management.application

import com.mvillafuertem.product.management.infrastructure.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod, RestController}

@RestController
class ProductController @Autowired()(productRespository: ProductRepository) {

  @RequestMapping(value = Array("/product"), method = Array(RequestMethod.GET))
  def getProduct: Product = productRespository.getProduct

}
