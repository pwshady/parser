package Models

import org.jsoup.nodes.Element
import tornadofx.observable

class ParserData {
    object page {
        var HTMLList = mutableListOf<Element>().observable()
    }
}