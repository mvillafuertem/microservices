package com.mvillafuertem.services.product.management.api

import scala.concurrent.Future

import com.mvillafuertem.services.product.management.domain.model.Product


trait ProductManagementApi {

  def getAllProduct: Future[Seq[Product]]

  def getProduct

}
