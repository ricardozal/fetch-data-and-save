package mx.bigtechsolutions.tonic.repositories

import mx.bigtechsolutions.tonic.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByCodeAndFkIdCountry(@Param("code") String code, @Param("fk_id_country") Integer fkIdCountry)

}