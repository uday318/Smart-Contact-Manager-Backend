package com.scm.ServiceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;



import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.scm.Entities.Contact;
import com.scm.Service.ExcelExportService;

@Service
public class ExcelExportServiceImpl implements ExcelExportService{
	
	 public ByteArrayInputStream contactsToExcel(List<Contact> contacts) throws IOException {
	        String[] COLUMNs = {"Id", "Name", "Email", "Phone Number", "Address", "Favorite", "Website", "LinkedIn"};
	        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {

	            Sheet sheet = (Sheet) workbook.createSheet("Contacts");

	            // Header
	            Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0);

	            for (int col = 0; col < COLUMNs.length; col++) {
	                Cell cell = headerRow.createCell(col);
	                cell.setCellValue(COLUMNs[col]);
	            }

	            int rowIdx = 1;
	            for (Contact contact : contacts) {
	                Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(rowIdx++);

	                row.createCell(0).setCellValue(contact.getId());
	                row.createCell(1).setCellValue(contact.getName());
	                row.createCell(2).setCellValue(contact.getEmail());
	                row.createCell(3).setCellValue(contact.getPhonenumber());
	                row.createCell(4).setCellValue(contact.getAddress());
	                row.createCell(5).setCellValue(contact.isFavorite());
	                row.createCell(6).setCellValue(contact.getWebsiteLink());
	                row.createCell(7).setCellValue(contact.getLinkedInLink());
	               
	            }

	            workbook.write(out);
	            return new ByteArrayInputStream(out.toByteArray());
	        }
	    }

}
