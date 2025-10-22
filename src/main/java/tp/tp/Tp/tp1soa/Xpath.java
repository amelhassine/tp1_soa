package tp.tp.Tp.tp1soa;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.Document;
import java.io.File;

public class Xpath {
     public static void main(String[] args) throws Exception {
        File xmlFile = new File("src/main/resources/films.xml");
        Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);

        XPath xPath = XPathFactory.newInstance().newXPath();

        // Exemple 1 : Tous les titres de films
        String expression1 = "/cinema/films/film/titre";
        org.w3c.dom.NodeList nodes1 = (org.w3c.dom.NodeList) xPath.evaluate(expression1, doc, XPathConstants.NODESET);
        System.out.println(" Liste des films :");
        for (int i = 0; i < nodes1.getLength(); i++) {
            System.out.println(" - " + nodes1.item(i).getTextContent());
        }

        // Exemple 2 : Les films réalisés par Christopher Nolan
        String expression2 = "/cinema/films/film[realisateur='Christopher Nolan']/titre";
        org.w3c.dom.NodeList nodes2 = (org.w3c.dom.NodeList) xPath.evaluate(expression2, doc, XPathConstants.NODESET);
        System.out.println("\nFilms de Christopher Nolan :");
        for (int i = 0; i < nodes2.getLength(); i++) {
            System.out.println(" - " + nodes2.item(i).getTextContent());
        }
    }
    
}
