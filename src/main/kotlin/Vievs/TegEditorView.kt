package Vievs

import org.jsoup.nodes.Element
import tornadofx.*

class TegEditorView(element: Element) : Fragment(){
    override val root = hbox{
        textarea(element.text())
        button("b1")
    }
}