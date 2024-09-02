package com.scm.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import com.scm.Entities.Contact;

public interface ExcelExportService {
	
	ByteArrayInputStream contactsToExcel(List<Contact> contacts) throws IOException;

}
