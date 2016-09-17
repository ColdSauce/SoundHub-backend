package models

/**
  * Created by coldsauce on 9/17/16.
  */
case class Track(id: Int, name: String, tempo: String)

import slick.driver.MySQLDriver.api._

object Track {

  def tupled = (Track.apply _).tupled
  class TrackTable(tag: Tag) extends Table[Track](tag, "Tracks") {
    def id = column[Int]("Id", O.PrimaryKey)
    def name = column[String]("Name")
    def tempo = column[String]("Tempo")
    def * = (id, name, tempo) <> (Track.tupled, Track.unapply)
  }
  object BitrayTable {
    val Bitrays = TableQuery[TrackTable]
  }
}
