//package fr.delpharm.esacp.excel;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.Date;
//import java.util.Optional;
//
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//
//import fr.delpharm.esacp.domain.Rapport;
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//public class ExtractAtInterne {
//
//	static File fileName = new File("C:\\Users\\afpa\\workplaceDelpharm\\esacp\\src\\main\\resources\\static\\xls\\HSE_RAPP_CIR_AT_INTERNE.xls");
//	static File fileName = new File("C:\\Users\\Afpa\\Documents\\GitHub\\esacp\\src\\main\\resources\\static\\xls\\HSE_RAPP_CIR_AT_INTERNE.xls");
//	
//	public static void ExtractATInterne(Rapport rapport) throws IOException {
//	log.info(" OOOOOOOOOOOOOOO   ExtractATInterne OOOOOOOOOOOOOOO   ");
//	// Read XSL file
//    FileInputStream inputStream = new FileInputStream(fileName);
//
//    // Get the workbook instance for XLS file
//    HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
//
//    // Get first sheet from the workbook
//    HSSFSheet sheet = workbook.getSheetAt(0);
//    Row row     = sheet.createRow(4);  
//    Cell cell   = row.createCell(5);  
//    
//    cell.setCellValue(rapport.getPersonneAT().getMatricule());
//    
//    row     = sheet.createRow(5);  
//    cell   = row.createCell(5); 
//    
//    cell.setCellValue(rapport.getPersonneAT().getLastName());
//    
//    row     = sheet.createRow(6);  
//    cell   = row.createCell(5); 
//    
//    cell.setCellValue(rapport.getPersonneAT().getFirstName());
//    
//    row     = sheet.createRow(6);  
//    cell   = row.createCell(5); 
//    
//    cell.setCellValue(rapport.getDepartement().getDepartement());
//    
//    row     = sheet.createRow(8);  
//    cell   = row.createCell(10); 
//    
//    cell.setCellValue(rapport.getStatut().getStatut());
//    
//    inputStream.close();
//    
//    FileOutputStream outputStream = new FileOutputStream(fileName);
//    workbook.write(outputStream);
//    workbook.close();
//    outputStream.close();
//    log.info(" OOOOOOOOOOOOOOO   DATE ECRITE  OOOOOOOOOOOOOOO   ");
//	}
//}

