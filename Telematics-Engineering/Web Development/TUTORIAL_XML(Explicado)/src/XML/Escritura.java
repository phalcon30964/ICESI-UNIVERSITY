package XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Escritura {
	
	public static void main(String[] args) {
		 
		  try {
	 
			SAXBuilder builder = new SAXBuilder();
			//como siempre cramos un saxbuilder para convertir un file en un document
			File xmlFile = new File("c:\\file2.xml");
			//importamos el archivo a escribir en forma de file
	 
			Document doc = (Document) builder.build(xmlFile);
			//con el builder volvemos el file en un document, este metodo es el que mas hace porque lee
			//el archivo y convierte toda el xml en un objeto que por dentro tiene elements esos elements tienen atributos
			
			Element rootNode = doc.getRootElement();
			//una vez leido y convertido el file en document, sacamos el elemento raiz del documento,
			//AL PARECER, EL METODO .GET
	 
			// Para cambiar el atributo de un elemento , obtenemos el elemento del ELEMENTO RAIZ, no del documento.
			//luego obtenemos el objeto atributo Attribute con el nombre pasado por paramento y usamos .setValue(String nuevo valor)
			Element staff = rootNode.getChild("staff");
			staff.getAttribute("id").setValue("2");
			//AL PARECER EL METODO .GETCHILDREN(String tipoelemento):List devuelve la lista de todos los elementos con nombre pasado por parametro
			//En cambio .GETCHILD(String tipoelemento):Element solo devuelve el primer elemento del tipo especificado, util cuando solo hay un elemento
			//
	 
			// Para agregar un nuevo elemento contenido dentro del elemento staff (el primero y unico que habia dentro del elemento raiz)
			//(aqui es lo que yo pensaba que eran atributos pero en verdad atributo es solo lo que se especifique en el enunciado de la declaracion del elemento)
			//Creo un nuevo elemento contenido "child" que se llamara  age y tendra valor de 28 asi  <age>28</age>
			Element age = new Element("age");
			//se crea el elemento age
			age.setText("28");
			//se le asigna 28
			staff.addContent(age);
			//se le agrega el elemento age al elemento staff
	 
			//Modificando elementos contenidos "child"
			staff.getChild("salary").setText("7000");
			//priemro sacamos el Element child de staff con .getChild y usamos .setTex() para cambiar el valor
	 
			// remove firstname element
			staff.removeChild("firstname");
			//para remover un child  se usa simplemente el metodo .removeChild(nombredelchild)
	 
			XMLOutputter xmlOutput = new XMLOutputter();
			
			
			xmlOutput.setFormat(Format.getPrettyFormat());
			// passsed System.out to see document content on console  
			xmlOutput.output(doc, System.out);  
			xmlOutput.output(doc, new FileWriter(xmlFile));
			//el primero escribe en consola y el segundo en el archivo
	 
			// xmlOutput.output(doc, System.out);
	 
			System.out.println("File updated!");
		  } catch (IOException io) {
			io.printStackTrace();
		  } catch (JDOMException e) {
			e.printStackTrace();
		  }
		}

}
