package Vievs

import Models.ElementJSON
import Models.HTMLTeg
import Models.ParserData
import javafx.scene.Parent
import javafx.scene.control.Button
import org.jsoup.nodes.Element
import tornadofx.*

class HTMLTableView(element : Element, elementJSON: ElementJSON) : Fragment() {
    var tegs = mutableListOf<HTMLTeg>().observable()
    fun reCreate(element : Element, elementJSON: ElementJSON){
        if (tegs.size > 0){
            for (i in 0 until element.children().size){
                var buttonStart : Button
                buttonStart = button("Start"){
                    action {
                        elementJSON.children[i].json = tegs.size.toString()
                        reCreate(element, elementJSON)
                        //ParserData.SignalChange.flag = false
                    }
                }
                //println(i)
                //tegs[0] = HTMLTeg(element.child(i).tagName(), element.child(i), elementJSON.children[i].json, elementJSON.children[i], buttonStart)
            }
            for (i in 0 .. tegs.size - 1){
            tegs.removeAt(0)}
            var buttonStart : Button
            buttonStart = button("Start"){
                action {
                    //elementJSON.children[0].json = tegs.size.toString()
                    reCreate(element, elementJSON)
                    //ParserData.SignalChange.flag = false
                }
            }
            println(element.children().size)
            for (i in 0 until element.children().size){
                var buttonStart : Button
                buttonStart = button("Start"){
                    action {
                        elementJSON.children[i].json = "yyyyyyyyyyyy"
                        reCreate(element, elementJSON)
                        //ParserData.SignalChange.flag = false
                    }
                }
                //tegs.add(HTMLTeg(element.child(i).tagName(), element.child(i), elementJSON.children[i].json, elementJSON.children[i], buttonStart))
                tegs[1] = HTMLTeg(element.child(0).tagName(), element.child(0), elementJSON.children[0].json, elementJSON.children[0], buttonStart)
            }
            //tegs.add(HTMLTeg(element.child(0).tagName(), element.child(0), elementJSON.children[0].json, elementJSON.children[0], buttonStart))
        } else {
            for (i in 0 until element.children().size){
                var buttonStart : Button
                buttonStart = button("Start"){
                    action {
                        elementJSON.children[i].json = "yyyyyyyyyyyy"
                        reCreate(element, elementJSON)
                        //ParserData.SignalChange.flag = false
                    }
                }
                tegs.add(HTMLTeg(element.child(i).tagName(), element.child(i), elementJSON.children[i].json, elementJSON.children[i], buttonStart))
            }
        }
    }
    override val root = tableview(tegs){
        maxWidth = 400.0
        maxHeight = 400.0
        reCreate(element,elementJSON)
        column("Tag", HTMLTeg::name)
        column("Value", HTMLTeg::json)
        column("ttt",HTMLTeg::buttonStart)
        rowExpander(expandOnDoubleClick = true){
            paddingLeft = expanderColumn.width
            if (it.tegs.children().size > 0){
                this += HTMLTableView(it.tegs, it.elementJSON)
            } else{
                this += TegEditorView(it.tegs)
            }
        }
        button("cle"){

        }
    }

}