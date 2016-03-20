package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 11C
 */
public class AdminPDF extends javax.swing.JFrame {

	private static int consecutivo;

	/**
	 * Creates new form factura
	 */
	public AdminPDF() {

		consecutivo = 0;
	}
        
       
	public static void generarInforme(String nombreTarea, String descripcion, String fecha, int prioridad,String nombreUsuario) {

		try {
			//Creamos la carpeta donde se almacenaran las facturas
			// Si quieres que las facturas se guarden en una carpeta del computador, 
			// aca colocas la ruta donde quieres que se guarden en lugar de src/facturas, 
			// tanto al crear carpeta y laFactura (de tipo File) y al crear archivo (de tipo FileOutputStream)
			//Ejemplo:  File carpeta = new File("D:\\facturas"); 
			//          FileOutputStream archivo = new FileOutputStream("D:\\facturas" + consecutivo + ".pdf");
			//          File laFactura = new File("src/facturas" + consecutivo + ".pdf");

			File carpeta = new File("Web Pages/pdf/");
			System.out.println(carpeta.exists());
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}
			String[] list = carpeta.list();
			consecutivo=list.length;
			System.out.println("Consecutivo es: " + consecutivo);
			int total = 0;
			FileOutputStream archivo = new FileOutputStream("Web Pages/pdf/" + consecutivo + ".pdf");
			Document documento = new Document();
			PdfWriter.getInstance(documento, archivo);
			documento.open();
			Paragraph titulo = new Paragraph("Resumen de Actividades");
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);
			documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("Fecha : 20 Mayo " ));
			documento.add(new Paragraph("Lugar: Universidad ICESI "));
			documento.add(new Paragraph("Identificaci�n: "));
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph(" "));
			PdfPTable tabla = new PdfPTable(2);

			documento.add(tabla);
			documento.add(new Paragraph("Muchas gracias por utilizar nuestro servicio!"));
			documento.close();
			File elInforme = new File("Web Pages/pdf/" + consecutivo + ".pdf");
			Desktop.getDesktop().open(elInforme);
			archivo.close();
		} catch (FileNotFoundException ex) {
            Logger.getLogger(AdminPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdminPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(AdminPDF.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }

	}

}
