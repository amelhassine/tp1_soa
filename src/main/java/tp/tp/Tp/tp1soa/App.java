package tp.tp.Tp.tp1soa;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class App {
     public static void main(String[] args) {

        System.out.println(" Domaine du Cinéma ");

        String xmlPath = "src/main/resources/films.xml";
        String xsdPath = "src/main/resources/films.xsd";
        String xslPath = "src/main/resources/films.xsl";
        String htmlOutput = "src/main/resources/films.html";

        System.out.println("\n--- Validation XML/XSD ---");
        boolean isValid = XMLValidator.validateXMLSchema(xsdPath, xmlPath);
        if (!isValid) {
            System.out.println(" Erreur : le fichier XML n'est pas valide, arrêt du programme.");
            return;
        }
        System.out.println("\n--- Requêtes XPath ---");
        try {
            Xpath.main(args); 
        } catch (Exception e) {
            System.out.println("Erreur lors de l'exécution des requêtes XPath : " + e.getMessage());
        }

        System.out.println("\n--- Transformation XSL → HTML ---");
        try {
            transformXMLToHTML(xmlPath, xslPath, htmlOutput);
            System.out.println(" Transformation réussie !");
            System.out.println(" Fichier généré : " + htmlOutput);
        } catch (Exception e) {
            System.out.println(" Erreur lors de la transformation XSL : " + e.getMessage());
        }

        System.out.println("\n Fin du programme ");
    }

    /**
     * Méthode pour transformer le XML en HTML à l’aide de la feuille XSL
     */
    public static void transformXMLToHTML(String xmlPath, String xslPath, String outputPath) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Source xsl = new StreamSource(new File(xslPath));
        Transformer transformer = factory.newTransformer(xsl);
        Source xml = new StreamSource(new File(xmlPath));
        transformer.transform(xml, new StreamResult(new File(outputPath)));
    }
    
}
