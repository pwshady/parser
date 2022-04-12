package Vievs

import Models.ParserData
import javafx.geometry.Side
import tornadofx.*
import java.sql.Driver

class ParserViev : View() {
    override val root = tabpane(){
        tab("s1") {
            fun createDrawer(){
                drawer (side = Side.LEFT, multiselect = false) {
                    item("Viev", expanded = true) {
                    }

                    item("HTML") {
                        this += HTMLTableView(ParserData.page.HTMLList[0], ParserData.page.JSONList[0])
                    }
                    item("JSON") {
                        this += JSONTextViev(ParserData.page.JSONList[0])
                    }
                }
            }
            createDrawer()
            ParserData.SignalChange.rc.onChange {
                //createDrawer()
            }
        }

    }
}