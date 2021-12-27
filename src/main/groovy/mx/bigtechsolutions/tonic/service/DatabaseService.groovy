package mx.bigtechsolutions.tonic.service

import mx.bigtechsolutions.tonic.model.Product
import mx.bigtechsolutions.tonic.repositories.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DatabaseService {

    @Autowired
    ProductRepository productRepository

    void updatePriceAndName(List<Product> products) {

        products.each {
            println "processing: ${it.code}"
            Product productLoaded = productRepository.findByCodeAndFkIdCountry(it.code, it.fkIdCountry)

            if (productLoaded) {
                productLoaded.name = it.name
                productLoaded.distributorPrice = it.distributorPrice
                productRepository.save(productLoaded)
            } else {
                productRepository.save(it)
            }

        }

    }

}
