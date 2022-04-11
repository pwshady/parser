package Models

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class ElementJSON(doc: Element) {
    var tagName : String
    var elementText : String = ""
    var children = mutableListOf<ElementJSON>()
    var json : String

    init {
        tagName = doc.tagName()
        if (doc.children().size == 0){
            elementText = doc.toString()
        } else{
            for(e in doc.children()){
                children.add(ElementJSON(e))
            }
        }
        json = ""
    }
}