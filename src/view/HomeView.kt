package view

import controller.HomeController
import tornadofx.View
import tornadofx.borderpane
import tornadofx.button
import tornadofx.label

class HomeView: View("LoginAndRegister") {

    private val homeController: HomeController by inject()

    override val root = borderpane {
        center = label("Hello ${homeController.updateView()}") {

        }
    }
}

