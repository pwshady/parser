package Vievs

import Models.ElementJSON
import tornadofx.Fragment
import tornadofx.hbox
import tornadofx.textarea

class JSONTextViev(elementJSON: ElementJSON) : Fragment() {
    var text : String = ""
    override val root = hbox {
        fun addTag(elementJSON: ElementJSON, preview : String){
            text += "${preview}${elementJSON.tagName}\n"
            if (elementJSON.children.size != 0){
                for (i in 0 until elementJSON.children.size){
                    addTag(elementJSON.children[i],"    ${preview}")
                }
            }
        }
        addTag(elementJSON,"")
        textarea(text)
    }
}