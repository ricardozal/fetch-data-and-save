package mx.bigtechsolutions.tonic.service

import mx.bigtechsolutions.tonic.model.Product
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExcelReaderService {

    @Value('${excel.path}')
    String excelPath

    List<Product> getProductsFromExcel() {

        List<Product> products = []

        FileInputStream file = new FileInputStream(new File(excelPath))
        XSSFWorkbook workbook = new XSSFWorkbook(file)
        XSSFSheet sheet = workbook.getSheetAt(0)

        DataFormatter dataFormatter = new DataFormatter()

        int rowsCounter = sheet.getLastRowNum()
        for (int i = 0;i <= rowsCounter;i++) {
            XSSFRow row = sheet.getRow(i)

            String code = dataFormatter.formatCellValue(row.getCell(0))
            String name = dataFormatter.formatCellValue(row.getCell(1))
            double price = row.getCell(2).getNumericCellValue()
            //double points = row.getCell(3).getNumericCellValue()

            products.add(new Product(code: code,
                                     name: name,
                                     imageUrl: "product/${code}.jpg",
                                     distributorPrice: price,
                                     points: 0,
                                     isKit: name.contains('KIT') ? 1 : 0,
                                     fkIdCountry: 2))
        }

        products

    }

}
