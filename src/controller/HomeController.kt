package controller

import tornadofx.Controller
import utilities.Database

var myusername: String = ""

class HomeController: Controller() {

   fun updateView(): String {
       val database = Database()
       return database.selectName(myusername)
   }

}