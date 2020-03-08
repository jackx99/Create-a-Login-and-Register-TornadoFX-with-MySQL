package view

import controller.RegisterController
import controller.myusername
import javafx.beans.property.SimpleStringProperty
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import model.User
import tornadofx.*

class RegisterView: View("LoginAndRegister") {

    private val name = SimpleStringProperty()
    private val username = SimpleStringProperty()
    private val password = SimpleStringProperty()
    private val controller: RegisterController by inject()

    override val root = borderpane {
        with(primaryStage) {
            height = 300.0
        }
        top = label("Register") {
            font = Font.font("Fira Code", FontWeight.BOLD, 20.0)
            paddingAll = 20.0
        }
        center = form {
            fieldset {
                field {
                    textfield(name) {
                        promptText = "Name"
                        requestFocus()
                    }
                }
                field {
                    textfield(username) {
                        promptText = "Username"
                    }
                }
                field {
                    passwordfield(password) {
                        promptText = "Password"
                    }
                }
                field {
                    button("Submit") {
                        action {
                            val user = User(
                                name = name.value,
                                username = username.value,
                                password = password.value
                            )
                            runAsync {
                                controller.createUser(user)
                            }.ui {
                                myusername = username.value
                                replaceWith<HomeView>()
                            }
                        }
                    }
                }
            }
        }
        bottom = button("Login") {
            action {
                replaceWith<LoginView>()
            }
        }
    }
}