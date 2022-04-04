package Vievs

import Models.ParserData
import javafx.geometry.Side
import tornadofx.*

class ParserViev : View() {
    override val root = tabpane(){
        tab("s1") {
            drawer (side = Side.LEFT, multiselect = false) {
                item("Viev", expanded = true) {
                }

                item("HTML") {
                    this += HTMLTableView(ParserData.page.HTMLList[0])
                }
                item("JSON") {
                    textfield {  }
                }
            }
        }

    }
}