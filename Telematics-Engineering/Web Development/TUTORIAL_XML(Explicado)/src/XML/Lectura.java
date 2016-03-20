package XML;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.xalan.xsltc.dom.DOMBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class Lectura {
	
	public static void main(String[] args) {
		 
		  SAXBuilder builder = new SAXBuilder();
		  //primero creamos un sax builder, esto es para leer, se puede usar SAX - SAXBuilder o DOM - DOMBuilder, no es del JDK de java
		  
		  File xmlFile = new File("c:\\file.xml");
		  //importamos el archivo a usar con file
	 
		  try {
	 
			Document document = (Document) builder.build(xmlFile);
			//con el builder convertimos el file en un documento xml
			
			Element rootNode = document.getRootElement();
			//se optiene el elemento raiz del xml del documento
			
			List<Element> list = rootNode.getChildren("staff");
			//con list optenemos el numero de elementos tipo staff y se vuelve una lista de objetos staff 
			//las cuales podemos usar para ir creando cada objeto
	 
			for (int i = 0; i < list.size(); i++) {
				
				//hacemos una iteracion por todos los elementos de la lista
	 
			   System.out.println("Elementos numero "+i+"\n");
			   Element node = list.get(i);
			   //sacamos cada elemento de la lista.
	 
			   System.out.println("First Name : " + node.getChildText("firstname"));
			   System.out.println("Last Name : " + node.getChildText("lastname"));
			   System.out.println("Nick Name : " + node.getChildText("nickname"));
			   System.out.println("Salary : " + node.getChildText("salary"));
			   
			   //con getChildText obtenemos el valor del atributo con el nombre que pasamos por parametro
	 
			   System.out.println("---------------------------------------------------------------------------\n");

			}
	 
		  } catch (IOException io) {
			System.out.println(io.getMessage());
		  } catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		  }
		}
}
