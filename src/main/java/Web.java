import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.rmi.server.LogStream.log;

public class Web {
    public static void main(String[] args) throws IOException {
        //Creamos un documento con el Jsoup y le añadimos el enlace de la pagina que queremos parsear
        Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/9828ef4989632378cb01f05c18a0ca3a47781f777d705291ec60422ef13d871c").get();
        log(doc.title());

        //Introducimos los elementos que posteriormente sacaremos por pantalla
        Elements newsHeadlines1 = doc.select(".CurrentConditions--location--kyTeL");
        Elements newsHeadlines2 = doc.select(".CurrentConditions--tempValue--3a50n");
        Elements newsHeadlines3 = doc.select(".CurrentConditions--phraseValue--2Z18W");

        //Recorremos todos los elementos
        for (Element headline : newsHeadlines1) {
            System.out.println("Localización: " + headline.html());
        }
        for (Element headline : newsHeadlines2) {
            System.out.println("Temperatura: " +headline.html());
        }
        for (Element headline : newsHeadlines3) {
            System.out.println("Tiempo: "+headline.html());
        }



    }
}
