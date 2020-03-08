import view.LoginView
import tornadofx.App
import tornadofx.launch

class MyApp: App(LoginView::class)

fun main() {
    launch<MyApp>()
}