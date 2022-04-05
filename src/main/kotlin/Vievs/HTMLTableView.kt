package Vievs

import Models.HTMLTeg
import javafx.scene.Parent
import org.jsoup.nodes.Element
import tornadofx.*

class HTMLTableView(element: Element) : Fragment() {
    var tegs = mutableListOf<HTMLTeg>().asObservable()
    override val root = tableview(tegs){
        for (i in 0 until element.children().size){
            tegs.add(HTMLTeg(element.child(i).tagName(),element.child(i)))
        }
        readonlyColumn("Tag", HTMLTeg::name)
        rowExpander(expandOnDoubleClick = true){
            println("ky")
        }
        println(tegs[0].name)
    }
}