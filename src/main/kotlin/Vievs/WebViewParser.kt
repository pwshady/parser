package Vievs

import javafx.scene.web.WebView
import tornadofx.*

class WebViewParser : View() {
    lateinit var wb: WebView
    override val root = vbox {
        button("bd"){
            action {
                println("gg")
                wb.engine.load("https://www.google.com")
            }
        }
        webview{
            wb = this
            run {
                engine.load("https://www.google.com")
            }
        }
    }


}