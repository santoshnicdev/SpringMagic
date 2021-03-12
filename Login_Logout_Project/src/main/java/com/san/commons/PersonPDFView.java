package com.san.commons;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.san.controller.LoginController;

public class PersonPDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//response.addHeader("Content-Disposition", "attachment;filename=Person.pdf");

		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) model.get("person");

		// create elements
		Font font = new Font(Font.TIMES_ROMAN, 22, Font.BOLD, new Color(84, 192, 247));
		Paragraph p = new Paragraph("HELLO USER!!", font);
		p.setSpacingAfter(10.0f);
		p.setAlignment(Element.ALIGN_CENTER);
		// add element to document
		document.add(p);

		// create table that one row should contains - n columns.
		PdfPTable table = new PdfPTable(7);
		table.addCell("Id");
		table.addCell("Name");
		table.addCell("Father_Name");
		table.addCell("DOB");
		table.addCell("Email");
		table.addCell("Country");
		table.addCell("City");

		// document.add(table);

		list.forEach(row -> {
			for (Object obj : row) {
				table.addCell(String.valueOf(obj));

			} //
		});

		document.add(table);
		document.close();
		

		// model.put("doc", document);
		
		  
		
		
		  LoginController lc = new LoginController(); 
		String msg=  lc.emailPage(document, request, response);
		System.out.println("PersonPDFView.buildPdfDocument()"+msg);
		 
		 

	}
	

}
