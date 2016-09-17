package models

/**
  * Created by coldsauce on 9/17/16.
  */
case class Bitray(id: Int, bitray: String)

import slick.driver.MySQLDriver.api._

object Bitray {

  def tupled = (Bitray.apply _).tupled
  class BitrayTable(tag: Tag) extends Table[Bitray](tag, "Bitrays") {
    def id = column[Int]("Id", O.PrimaryKey)
    def bitray = column[String]("Bitray")
    def * = (id, bitray) <> (Bitray.tupled, Bitray.unapply)
  }
  object BitrayTable {
    val Bitrays = TableQuery[BitrayTable]
  }
}
