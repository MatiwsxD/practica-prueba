package sql;

import com.sun.java.browser.plugin2.DOM;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class createXML {
    Document documento;

    public createXML(){


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation=builder.getDOMImplementation();

            documento = implementation.createDocument(null, "Usuarios", null);
            documento.setXmlVersion("1.0");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }

    public void addUsuario(String cedula, String nombres, String telefono, String mail){
        Element Usuario = documento.createElement("Usuario");
        Usuario.appendChild(setAtribute("Cedula", cedula));
        Usuario.appendChild(setAtribute("Nombres", nombres));
        Usuario.appendChild(setAtribute("Telefono", telefono));
        Usuario.appendChild(setAtribute("Mail", mail));
        documento.getDocumentElement().appendChild(Usuario);



    }
    public void endDocument(){
        Source source = new DOMSource(documento);
        Result result = new StreamResult(new File("data.xml"));
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    public Element setAtribute(String element, String textElement){
        Element elm = documento.createElement(element);
        Text textElm = documento.createTextNode(textElement);
        elm.appendChild(textElm);
        return elm;

    }

}
