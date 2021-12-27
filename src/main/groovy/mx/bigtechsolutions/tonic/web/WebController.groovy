package mx.bigtechsolutions.tonic.web

import mx.bigtechsolutions.tonic.model.Product
import mx.bigtechsolutions.tonic.service.DatabaseService
import mx.bigtechsolutions.tonic.service.ExcelReaderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WebController {

    static final SUCCESS = "success"
    @Autowired
    ExcelReaderService excelReaderService
    @Autowired
    DatabaseService databaseService

    @GetMapping("/get-products")
    String getProducts() {
        try {
            List<Product> products = excelReaderService.getProductsFromExcel()
            databaseService.updatePriceAndName(products)
            SUCCESS
        } catch(Exception e) {
            "Error: ${e.message}"
        }
    }

}
