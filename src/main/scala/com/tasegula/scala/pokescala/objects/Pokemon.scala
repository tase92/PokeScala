/**
 * Project PokeScala: PokeApi Scala Wrapper
 * Special class because it has over 9000 parameters
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.functional.syntax._
import play.api.libs.json._

case class Pokemon(id: Int,
                   name: String,
                   resource_uri: String,
                   created: String,
                   modified: String,
                   ev_yield: String,
                   growth_rate: String,
                   height: String,
                   male_female_ratio: String,
                   species: String,
                   weight: String,
                   attack: Int,
                   defense: Int,
                   sp_attack: Int,
                   sp_defense: Int,
                   catch_rate: Int,
                   egg_cycles: Int,
                   exp: Int,
                   happiness: Int,
                   hp: Int,
                   speed: Int,
                   total: Int,
                   abilities: List[AbilityMini],
                   descriptions: List[DescriptionMini],
                   evolutions: List[Evolution],
                   eggGroups: List[EggGroupMini],
                   moves: List[MoveMini],
                   types: List[TypeMini])

case class PokemonMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait PokemonJson {
  implicit val formatPokemonMini = Json.format[PokemonMini]

  type _Ability = AbilityMini
  type _Description = DescriptionMini
  type _Evolution = Evolution
  type _EggGroup = EggGroupMini
  type _Move = MoveMini
  type _Type = TypeMini

  private type baseTuple = (Int, String, String, String, String)
  private type stringTuple = (String, String, String, String, String, String)
  private type intTuple = (Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)
  private type listTuple = (List[_Ability], List[_Description], List[_Evolution], List[_EggGroup], List[_Move], List[_Type])

  private val baseFieldFormat: OFormat[baseTuple] = (
    (__ \ "national_id").format[Int] and
      (__ \ "name").format[String] and
      (__ \ "resource_uri").format[String] and
      (__ \ "created").format[String] and
      (__ \ "modified").format[String]
    ).tupled

  private val stringFieldsFormat: OFormat[stringTuple] = (
    (__ \ "ev_yield").format[String] and
      (__ \ "growth_rate").format[String] and
      (__ \ "height").format[String] and
      (__ \ "male_female_ratio").format[String] and
      (__ \ "species").format[String] and
      (__ \ "weight").format[String]
    ).tupled

  private val intFieldsFormat: OFormat[intTuple] = (
    (__ \ "attack").format[Int] and
      (__ \ "defense").format[Int] and
      (__ \ "sp_atk").format[Int] and
      (__ \ "sp_def").format[Int] and
      (__ \ "catch_rate").format[Int] and
      (__ \ "egg_cycles").format[Int] and
      (__ \ "exp").format[Int] and
      (__ \ "happiness").format[Int] and
      (__ \ "hp").format[Int] and
      (__ \ "speed").format[Int] and
      (__ \ "total").format[Int]
    ).tupled

  import AbilityJson._
  import DescriptionJson._
  import EggGroupJson._
  import EvolutionJson._
  import MoveJson._
  import TypeJson._

  private val listFields: OFormat[listTuple] = (
    (__ \ "abilities").format[List[_Ability]] and
      (__ \ "descriptions").format[List[_Description]] and
      (__ \ "evolutions").format[List[_Evolution]] and
      (__ \ "egg_groups").format[List[_EggGroup]] and
      (__ \ "moves").format[List[_Move]] and
      (__ \ "types").format[List[_Type]]
    ).tupled

  implicit val formatPokemon: Format[Pokemon] = (baseFieldFormat and stringFieldsFormat and intFieldsFormat and listFields).apply({
    case ((id, name, resource_uri, created, modified),
          (ev_yield, growth_rate, height, male_female_ratio, species, weight),
          (attack, defense, sp_attack, sp_defense, catch_rate, egg_cycles, exp, happiness, hp, speed, total),
          (abilities, descriptions, evolutions, eggGroups, moves, types)) =>
      Pokemon(id, name, resource_uri, created, modified,
              ev_yield, growth_rate, height, male_female_ratio, species, weight,
              attack, defense, sp_attack, sp_defense, catch_rate, egg_cycles, exp, happiness, hp, speed, total,
              abilities, descriptions, evolutions, eggGroups, moves, types)
  }, pokemon => (
    (pokemon.id, pokemon.name, pokemon.resource_uri, pokemon.created, pokemon.modified),
    (pokemon.ev_yield, pokemon.growth_rate, pokemon.height, pokemon.male_female_ratio, pokemon.species, pokemon.weight),
    (pokemon.attack, pokemon.defense, pokemon.sp_attack, pokemon.sp_defense, pokemon.catch_rate, pokemon.egg_cycles, pokemon.exp, pokemon.happiness, pokemon.hp, pokemon.speed, pokemon.total),
    (pokemon.abilities, pokemon.descriptions, pokemon.evolutions, pokemon.eggGroups, pokemon.moves, pokemon.types)))

}

object PokemonJson extends PokemonJson
