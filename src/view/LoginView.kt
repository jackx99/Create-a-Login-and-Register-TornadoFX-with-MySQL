package view

import controller.myusername
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import tornadofx.*

class LoginView: View("LoginAndRegister") {

    val username = SimpleStringProperty()

    override val root = borderpane {
        top = label("Login") {
            font = Font.font("Fira Code", FontWeight.BOLD, 20.0)
            paddingAll = 20.0
        }
        center = form {
            fieldset {
                field {
                    textfield(username) {
                        promptText = "Username"
                        requestFocus()
                    }
                }
                field {
                    passwordfield {
                        promptText = "Password"
                    }
                }
                field {
                    button("Submit") {
                        action {
                            myusername = username.value
                            replaceWith<HomeView>()
                        }
                    }
                }
            }
        }
        bottom = button("Register") {
            action {
                replaceWith<RegisterView>()
            }
        }
    }
}