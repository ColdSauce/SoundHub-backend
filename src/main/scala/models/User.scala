package models

/**
  * Created by coldsauce on 9/17/16.
  */
case class User(firstName: String, lastName: String, username: String, password: String, email: String)


import slick.driver.MySQLDriver.api._

object User {

  def tupled = (User.apply _).tupled
  class UserTable(tag: Tag) extends Table[User](tag, "Users") {
    def firstName = column[String]("FirstName", O.PrimaryKey)
    def lastName = column[String]("LastName")
    def username = column[String]("Username")
    def password = column[String]("Password")
    def email = column[String]("Email")
    def * = (firstName, lastName, username, password, email) <> (User.tupled, User.unapply)
  }
  object UserTable {
    val users = TableQuery[UserTable]
  }
}