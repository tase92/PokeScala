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

  def getDescriptionFuture(id: Int)(implicit system: ActorSystem) = getFutureById[T](id)
  def getDescriptionFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getDescription(id: Int)(implicit system: ActorSystem) = getById[T](id)
  def getDescription(name: String)(implicit system: ActorSystem) = getByName[T](name)
}
