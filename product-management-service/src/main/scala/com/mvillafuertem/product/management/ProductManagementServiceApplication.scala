package com.mvillafuertem.product.management

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ProductManagementServiceApplication

object ProductManagementServiceApplication extends App {
  SpringApplication.run(classOf[ProductManagementServiceApplication], args: _*)
}


