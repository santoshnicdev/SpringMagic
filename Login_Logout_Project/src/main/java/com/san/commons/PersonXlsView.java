package com.san.commons;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;



public class PersonXlsView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
response.addHeader("Content-Disposition", "attachment;filename=persondata.xls");
		
		//create one sheet
		Sheet sheet = workbook.createSheet("DUMMY");
		
		//create one row
		Row row=sheet.createRow(0);
		
		//create one cell
		Cell cell = row.createCell(0);
		
		//set data to this cell
		cell.setCellValue("HELLO DATA");

	}

}
