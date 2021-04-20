package sample.JPA;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelWithProductCatalog {
    public static List<ProductCatalog> readFileUsingPOI(File file) throws IOException {
        List<ProductCatalog> products = new ArrayList<>();

        //String excelFilePath = "C:\\Users\\Dovyd\\IdeaProjects\\ECOSprendimai\\target\\classes\\sample\\JPA\\products.xlsx";
        //File file = new File(excelFilePath);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = (Row) iterator.next();

            // Not creating country object for header
            if (nextRow.getRowNum() == 0)
                continue;

            ProductCatalog productCatalog = new ProductCatalog();
            Iterator cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = (Cell) cellIterator.next();
                int columnIndex = cell.getColumnIndex();
                switch (columnIndex + 1) {
                    case 1:
                        productCatalog.setCatalogNo((int) cell.getNumericCellValue());
                        break;
                    case 2:
                        productCatalog.setSymbol(cell.getStringCellValue());
                        break;
                    case 3:
                        productCatalog.setPriceNet(cell.getNumericCellValue());
                        break;
                    case 4:
                        productCatalog.setStock((int) cell.getNumericCellValue());
                        break;
                    case 5:
                        productCatalog.setGroupId((int) cell.getNumericCellValue());
                        break;
                }
            }
            products.add(productCatalog);

        }
        workbook.close();
        inputStream.close();

        return products;
    }

}
