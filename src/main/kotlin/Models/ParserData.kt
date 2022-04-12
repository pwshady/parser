package Models

import org.jsoup.nodes.Element
import tornadofx.observable
import java.util.*
import kotlin.properties.Delegates

class ParserData {
    object page {
        var HTMLList = mutableListOf<Element>().observable()
        var JSONList = mutableListOf<ElementJSON>().observable()
        var flag = false
    }

    object SignalChange {
        var flag : Boolean by Delegates.observable(true){
            prop, old, new ->
            //println("$old->$new")
        }

        var rc = mutableListOf<Boolean>().observable()
    }
}