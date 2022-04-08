import Models.ElementJSON
import Models.ParserData
import Vievs.ParserApp
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import tornadofx.launch
import java.io.File

fun main(){

    val file = File("C:\\Users\\4\\Desktop\\test01.html")
    var doc = Jsoup.parse(file, "UTF-8", "C:\\Users\\4\\Desktop\\test01.html")
    //println(doc.children()[0].children().size)
    //for (el in doc.children()[0].children()){
    //    println(el.children().size)
    //}
    ParserData.page.HTMLList.add(doc)
    var t : ElementJSON = ParserData.page.HTMLList[0]
    println(t)
    launch<ParserApp>()
    //WVP.main()
}


