package com.mvillafuertem.services.email.infrastructure.marshaller

import com.mvillafuertem.services.email.domain.model.Email
import spray.json.{DefaultJsonProtocol, RootJsonFormat}


object EmailJsonFormatMarshaller extends DefaultJsonProtocol {

  implicit val emailFormat: RootJsonFormat[Email] = jsonFormat3(Email.apply(_: String, _: String, _: String))

}
