package com.mvillafuertem.services.product.management

import com.mvillafuertem.services.product.management.domain.model.Product
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

object ProductJsonProtocol extends DefaultJsonProtocol {

  implicit def productFormat: RootJsonFormat[Product] = jsonFormat1(Product.apply)

}
