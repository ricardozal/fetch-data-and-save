package mx.bigtechsolutions.tonic.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "product")
class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    String code
    String name
    @Column(name="image_url")
    String imageUrl
    @Column(name="distributor_price")
    double distributorPrice
    double points
    @Column(name="is_kit")
    Integer isKit = 0
    Integer active = 1
    @Column(name="fk_id_country")
    Integer fkIdCountry
    @Column(name="fk_id_category")
    Integer fkIdCategory = 0
}
