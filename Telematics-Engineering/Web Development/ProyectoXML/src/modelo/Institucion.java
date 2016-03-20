package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Institucion {
	
	private File xmlFile;
	private FileWriter escritor;
	

	public Institucion() {
		
			xmlFile = new File("c:\\principal.xml");

			if(!xmlFile.exists()){
				createXMLFILE();
			}
		
	}
	
	public boolean createXMLFILE(){
		
		Element compania = new Element("Compania");
		
		
		Document documentoXML = new Document();
		documentoXML.setRootElement(compania);
		
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try {
			xmlOutput.output(documentoXML, System.out); //en consola
			escritor = new FileWriter(xmlFile);
			xmlOutput.output(documentoXML, escritor); //en el archivo
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	
	public boolean addDepartamento(String nombre, String cenco, String descripcion){

		try {
			//leo documento xml y lo vuelvo un objeto
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(xmlFile);
			
			//le saco al archivo su elemento raiz
			Element elementoRaiz = doc.getRootElement();
			
			//creo un elemento departamento
			Element departamento = new Element("Departamento");
			departamento.setAttribute(new Attribute("Cenco", cenco));
			departamento.addContent(new Element("nombre").setText(nombre));
			departamento.addContent(new Element("descripcion").setText(descripcion));
			
			//se lo agrego al objeto raiz
			elementoRaiz.addContent(departamento);

			//abro fujo de escritura
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			//escribo el documento
			xmlOutput.output(doc, System.out); //en consola
			escritor = new FileWriter(xmlFile);
			xmlOutput.output(doc, escritor); //en el archivo
			escritor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 

		return true;
	}
	
	public boolean addSecretaria(String nombres, String apellidos, String id, String direccion, 
			String telefono, String cencoPrincipal, String pago){

		try {
			//leo documento xml y lo vuelvo un objeto
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(xmlFile);
			
			//le saco al archivo su elemento raiz
			Element elementoRaiz = doc.getRootElement();
			
			//creo una nueva secretaria
			Element secretaria = new Element("Secretaria");
			secretaria.setAttribute(new Attribute("id", id));
			secretaria.addContent(new Element("nombres").setText(nombres));
			secretaria.addContent(new Element("apellidos").setText(apellidos));
			secretaria.addContent(new Element("direccion").setText(direccion));
			secretaria.addContent(new Element("telefono").setText(telefono));
			secretaria.addContent(new Element("cencoPrincipal").setText(cencoPrincipal));
			secretaria.addContent(new Element("pago").setText(pago));
			
			//se lo agrego al objeto raiz
			elementoRaiz.addContent(secretaria);

			//abro fujo de escritura
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			//escribo el documento
			xmlOutput.output(doc, System.out); //en consola\
			escritor = new FileWriter(xmlFile);
			xmlOutput.output(doc, escritor); //en el archivo
			escritor.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 

		return true;
	}
	
	public String getNombresSecretarias(){
		
		String nombres = "";
	
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(xmlFile);
			
			Element elementoRaiz = doc.getRootElement();

			List<Element> listadoSecretarias = elementoRaiz.getChildren("Secretaria");
			
			for (int i = 0; i < listadoSecretarias.size(); i++) {
				
				Element secretaria = listadoSecretarias.get(i);
				
				String nombresSecretaria = secretaria.getChildText("nombres");
				String idSecretaria = secretaria.getAttributeValue("id");
				
				nombres += "["+nombresSecretaria+","+idSecretaria+"]+";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		} 
		
		return nombres;
	}
	
	public String getDatosSecretaria(String id){
		
		try {
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(xmlFile);
			
			Element elementoRaiz = doc.getRootElement();

			List<Element> listadoSecretarias = elementoRaiz.getChildren("Secretaria");
			
			for (int i = 0; i < listadoSecretarias.size(); i++) {
				
				Element secretaria = listadoSecretarias.get(i);
				
				String idSecretaria = secretaria.getAttributeValue("id");
				
				if(idSecretaria.equalsIgnoreCase(id)){
					
					String nombresSecretaria = secretaria.getChildText("nombres");
					String apellidosSecretaria = secretaria.getChildText("apellidos");
					String direccionSecretaria = secretaria.getChildText("direccion");
					String telefonoSecretaria = secretaria.getChildText("telefono");
					String cencoPrincipalSecretaria = secretaria.getChildText("cencoPrincipal");
					String pagoSecretaria = secretaria.getChildText("pago");
					
					
					return "["+nombresSecretaria+","+apellidosSecretaria+","+idSecretaria+","+
					          direccionSecretaria+","+telefonoSecretaria+","+cencoPrincipalSecretaria+","+pagoSecretaria+"]";
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		return "";
	}
	
	
}
