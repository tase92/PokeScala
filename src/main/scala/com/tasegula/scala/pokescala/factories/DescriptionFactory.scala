/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Description
import com.tasegula.scala.pokescala.objects.DescriptionJson._

object DescriptionFactory {

  type T = Description
  implicit val path: String = "description"

  def getDescriptionFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getDescriptionFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getDescriptionOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getDescriptionOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getDescriptionResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getDescriptionResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
