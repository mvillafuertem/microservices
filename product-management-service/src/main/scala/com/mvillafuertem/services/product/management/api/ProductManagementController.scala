package com.mvillafuertem.services.product.management.api

import akka.http.scaladsl.server.Directives._
import com.mvillafuertem.services.product.management.domain.model.Product

import scala.concurrent.Future

final class ProductManagementController(productFinder: ProductFinder) extends ProductManagementApi {

  pathEndOrSingleSlash {
    get {
        entity(as[Seq[Product]]){
          productFinder.findAll()
        }
    }
  }

  override def getAllProduct: Future[Seq[Product]] = ???

  override def getProduct: Unit = ???
}
