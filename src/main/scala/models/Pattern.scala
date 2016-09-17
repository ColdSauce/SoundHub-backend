package models

/**
  * Created by coldsauce on 9/17/16.
  */
case class Pattern(id: Int, seq: Int)

import slick.driver.MySQLDriver.api._

object Pattern {

  def tupled = (Pattern.apply _).tupled
  class PatternTable(tag: Tag) extends Table[Pattern](tag, "Patterns") {
    def id = column[Int]("Id", O.PrimaryKey)
    def seq = column[Int]("Seq")
    def * = (id, seq) <> (Pattern.tupled, Pattern.unapply)
  }
  object PatternTable {
    val Patterns = TableQuery[PatternTable]
  }
}
