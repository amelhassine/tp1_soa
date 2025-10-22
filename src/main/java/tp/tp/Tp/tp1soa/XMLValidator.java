package tp.tp.Tp.tp1soa;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidator {

    public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
            System.out.println(" XML valide par rapport au XSD !");
            return true;
        } catch (Exception e) {
            System.out.println(" XML non valide : " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        validateXMLSchema("src/main/resources/films.xsd", "src/main/resources/films.xml");
    }
}