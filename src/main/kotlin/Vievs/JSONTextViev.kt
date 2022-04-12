package Vievs

import Models.ElementJSON
import Models.ParserData
import javafx.scene.control.TextArea
import tornadofx.*

class JSONTextViev(elementJSON: ElementJSON) : Fragment() {
    var fulText : String = ""
    fun setText(elementJSON: ElementJSON){
        fun addTag(elementJSON: ElementJSON, preview : String){
            if (elementJSON.children.size == 0){
                fulText += "${preview}tag=${elementJSON.tagName}    json=${elementJSON.json}    value=${elementJSON.elementText}\n"
            }else{
                fulText += "${preview}tag=${elementJSON.tagName}    json=${elementJSON.json}\n"
                for (i in 0 until elementJSON.children.size){
                    addTag(elementJSON.children[i],"    ${preview}")
                }
            }
        }
        addTag(elementJSON,"")
    }

    override val root = hbox {
        setText(elementJSON)

        var ta : TextArea
        ta = textarea(fulText){
            minWidth = 400.0
        }
        button("gg"){
            action {
                fulText = ""
                setText(elementJSON)
                ta.text = fulText
            }
        }
        button("kk"){
            action {
                fulText = ""
                setText(ParserData.page.JSONList[0])
                ta.text = fulText
            }
        }
    }
}