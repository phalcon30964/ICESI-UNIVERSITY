package XML;

import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Creacion {
	
	public static void main(String[] args) {
		 
		  try {
	 
			//---------------------------CREACION DEL DOCUMENTO DESDE CERO-----------------------------------------------------------
			  
			Element company = new Element("company");
			//creamos un elemento raiz
			Document doc = new Document();
			//creamos un documento sobre el que se trabajará
			doc.setRootElement(company);
			//se le asigna el elemento root al documento
	 
			Element staff = new Element("staff");
			//se crea un child de company llamado staff, un elemento contenido
			
			staff.setAttribute(new Attribute("id", "1"));
			//se le asigna un atributo id
			staff.addContent(new Element("firstname").setText("yong"));
			staff.addContent(new Element("lastname").setText("mook kim"));
			staff.addContent(new Element("nickname").setText("mkyong"));
			staff.addContent(new Element("salary").setText("199999"));
			//se le agregan elementos child y se les da valor
	 
			doc.getRootElement().addContent(staff);
			//se agrega al elemento raiz el nuevo elemento creado anteriormente con .addContent(), 
			//yo creo que se podia haber primero creado el child y luego metido todo dentro del documento
	 
			Element staff2 = new Element("staff");
			staff2.setAttribute(new Attribute("id", "2"));
			staff2.addContent(new Element("firstname").setText("low"));
			staff2.addContent(new Element("lastname").setText("yin fong"));
			staff2.addContent(new Element("nickname").setText("fong fong"));
			staff2.addContent(new Element("salary").setText("188888"));
			//se crea un nuevo elemento
	 
			doc.getRootElement().addContent(staff2);
			//se agrega el nuevo elemento.
	 
			//---------------------------ESCRITURA DEL DOCUMENTO CREADO-----------------------------------------------------------

			// new XMLOutputter().output(doc, System.out);
			XMLOutputter xmlOutput = new XMLOutputter();
			
			// passsed System.out to see document content on console  
			xmlOutput.output(doc, System.out);  
	 
			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(doc, new FileWriter("c:\\file.xml"));
	 
			System.out.println("File Saved!");
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  }
		}

}
