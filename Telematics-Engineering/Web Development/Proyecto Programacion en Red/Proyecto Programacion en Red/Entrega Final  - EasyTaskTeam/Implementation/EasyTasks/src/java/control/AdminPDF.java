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
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Tarea;

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
        
       
public static void generarInforme(ArrayList<Tarea> tareas,String usuario) {

		try {
			//Creamos la carpeta donde se almacenaran las facturas
			// Si quieres que las facturas se guarden en una carpeta del computador, 
			// aca colocas la ruta donde quieres que se guarden en lugar de src/facturas, 
			// tanto al crear carpeta y laFactura (de tipo File) y al crear archivo (de tipo FileOutputStream)
			//Ejemplo:  File carpeta = new File("D:\\facturas"); 
			//          FileOutputStream archivo = new FileOutputStream("D:\\facturas" + consecutivo + ".pdf");
			//          File laFactura = new File("src/facturas" + consecutivo + ".pdf");

			File carpeta = new File("web/pdfs");
			System.out.println(carpeta.exists());
			if (!carpeta.exists()) {
				carpeta.mkdirs();
			}
			String[] list = carpeta.list();
			consecutivo=list.length;
			System.out.println("Consecutivo es: " + consecutivo);
			int total = 0;
			FileOutputStream archivo = new FileOutputStream("web/pdfs/" + consecutivo + ".pdf");
			Document documento = new Document();
			PdfWriter.getInstance(documento, archivo);
			documento.open();
			Paragraph titulo = new Paragraph("Resumen de Actividades");
			titulo.setAlignment(Element.ALIGN_CENTER);
			documento.add(titulo);


			documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
			documento.add(new Paragraph("Usuario: "+usuario));
			documento.add(new Paragraph(" "));
			//			documento.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------"));
			documento.add(new Paragraph(" "));
			documento.add(new Paragraph(" "));
			//			documento.add(new Paragraph(" "));
			//			documento.add(new Paragraph(" "));
			documento.add(new Paragraph("  "));
			PdfPTable tabla = new PdfPTable(7);
			Image image= Image.getInstance("../EasyTasks/web/images/logo.png");
			
//			tabla.addCell(image);
			Paragraph nombreBase = new Paragraph("Nombre ");
			Paragraph descripcionBase = new Paragraph("Descripcion     ");
			Paragraph fechaBase = new Paragraph("Fecha ");
			Paragraph prioridadBase = new Paragraph("Prioridad  ");
			Paragraph tagsBase = new Paragraph("Tags");
			Paragraph categoriaBase = new Paragraph("Categoria  ");
			Paragraph ubicacionBase = new Paragraph("Ubicacion    ");
			
			
//			tabla.addCell(image);
			tabla.addCell(nombreBase);
			tabla.addCell(descripcionBase);
			tabla.addCell(fechaBase);
			tabla.addCell(prioridadBase);
			tabla.addCell(tagsBase);
			tabla.addCell(categoriaBase);
			tabla.addCell(ubicacionBase);
			for (int i = 0; i < tareas.size(); i++) {

				Tarea tareaNueva= tareas.get(i);
				Paragraph nombre = new Paragraph(tareaNueva.getNombre());
				Paragraph descripcion = new Paragraph(tareaNueva.getDescripcion());
				Paragraph fecha = new Paragraph(tareaNueva.getFechaLimite()+"");
				Paragraph prioridad = new Paragraph(tareaNueva.getPrioridad());
				Paragraph tags=null;				for (int k = 0; k < tareaNueva.getTags().size(); k++) {
					tags = new Paragraph(tareaNueva.getTags().get(k));					
				}
				Paragraph categoria = new Paragraph(tareaNueva.getCategoria());
				Paragraph ubicacion = new Paragraph(tareaNueva.getUbiLatitud()+", "+tareaNueva.getUbiLongitud());
				//				Paragraph tost = new Paragraph(tareaNueva.toStringSimple());

				tabla.addCell(nombre);
				tabla.addCell(descripcion);
				tabla.addCell(fecha);
				tabla.addCell(prioridad);
				tabla.addCell(tags);
				tabla.addCell(categoria);
				tabla.addCell(ubicacion);
				//				tabla.addCell(tost);

			}

			//			FileReader fr = new FileReader("src/archivos/pedidos.txt");
			//			BufferedReader bwa = new BufferedReader(fr);
			//			String elProducto = bwa.readLine();
			//			while (elProducto != null) {
			//				if (!elProducto.equalsIgnoreCase("")) {
			//					System.out.println("El producto: " + elProducto);
			//					String[] elProductoConPrecio = elProducto.split("-");
			//					Paragraph producto = new Paragraph(elProductoConPrecio[0]);
			//					Paragraph precio = new Paragraph(elProductoConPrecio[1]);
			//					total += Integer.parseInt(elProductoConPrecio[1]);
			//					precio.setAlignment(Element.ALIGN_RIGHT);
			//					tabla.addCell(producto);
			//					tabla.addCell(precio);
			//					elProducto = bwa.readLine();
			//				}
			//			}
			//			if (!darIva().equals("") && !darIva().equals("0")) {
			//				tabla.addCell("Subtotal");
			//				Paragraph elSubTotal = new Paragraph("" + total);
			//				elSubTotal.setAlignment(Element.ALIGN_RIGHT);
			//				tabla.addCell(elSubTotal);
			//				tabla.addCell("Iva (" + darIva() + ")");
			//				int iva = total * Integer.parseInt(darIva()) / 100;
			//				tabla.addCell("" + iva);
			//				int precioConIva = total + iva;
			//				tabla.addCell("Total");
			//				Paragraph elTotal = new Paragraph("" + precioConIva);
			//				elTotal.setAlignment(Element.ALIGN_RIGHT);
			//				tabla.addCell(elTotal);
			//			} else {
			//				tabla.addCell("Total");
			//				Paragraph elTotal = new Paragraph("" + total);
			//				elTotal.setAlignment(Element.ALIGN_RIGHT);
			//				tabla.addCell(elTotal);
			//			}
			documento.add(tabla);
			documento.add(new Paragraph("----------------------------------------------------------------------------------------------"));
			documento.add(new Paragraph("Muchas gracias por utilizar nuestro servicio,"));
			documento.add(new Paragraph(""));
			//			Image image = Image.getInstance("logo.png");
			documento.addCreator("EasyTask Team");
			documento.add(image);
			documento.addCreationDate();
			//			PdfPCell cell2 = new PdfPCell(image, true);

			//			tabla.addCell(cell2);
			documento.add(new Paragraph(""));
			documento.add(new Paragraph("         EasyTask Team"));
			documento.close();
			File elInforme = new File("../EasyTasks/web/pdfs/" + usuario + ".pdf");
			Desktop.getDesktop().open(elInforme);
			//			BufferedWriter br = new BufferedWriter(new FileWriter("src//pedidos.txt"));
			//			br.write("");
			//			br.close();
			//			fr.close();
			//			bwa.close();
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
