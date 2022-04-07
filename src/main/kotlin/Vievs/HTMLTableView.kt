package Vievs

import Models.HTMLTeg
import javafx.scene.Parent
import org.jsoup.nodes.Element
import tornadofx.*

class HTMLTableView(element: Element) : Fragment() {
    var tegs = mutableListOf<HTMLTeg>().asObservable()
    override val root = tableview(tegs){
        minWidth = 1200.0
        minHeight = 800.0
        for (i in 0 until element.children().size){
            tegs.add(HTMLTeg(element.child(i).tagName(),element.child(i)))
        }
        readonlyColumn("Tag", HTMLTeg::name)
        rowExpander(expandOnDoubleClick = true){
            paddingLeft = expanderColumn.width
            if (it.tegs.children().size > 0){
                this += HTMLTableView(it.tegs)
            } else{
                this += TegEditorView(it.tegs)
            }
        }
        println(tegs[0].name)
    }
}