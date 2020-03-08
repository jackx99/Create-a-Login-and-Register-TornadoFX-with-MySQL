package controller

import model.User
import tornadofx.Controller
import utilities.Database

class RegisterController: Controller() {

    fun createUser(user: User) {
        val database = Database()
        database.insertNewUser(user)
    }
}