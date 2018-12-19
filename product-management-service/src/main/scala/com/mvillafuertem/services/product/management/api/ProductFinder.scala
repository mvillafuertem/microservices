package com.mvillafuertem.services.product.management.api

import scala.concurrent.Future

trait ProductFinder {

  def findAll(): Future[Seq[Product]]

}
