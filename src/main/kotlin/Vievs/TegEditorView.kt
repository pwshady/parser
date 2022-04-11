package Vievs

import javafx.geometry.Side
import org.jsoup.nodes.Element
import tornadofx.*

class TegEditorView(element: Element) : Fragment(){
    override val root = hbox{
        drawer (side = Side.BOTTOM, multiselect = false){
            item("Element", expanded = true) {
                textarea(element.toString())
            }
            item("Text") {
                textarea(element.text())
            }
        }
        button("b1")
    }
}