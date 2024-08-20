package com.example.thetouringsuppliessystem.Repository;

import com.example.thetouringsuppliessystem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findProductById(Integer id);

//    @Query("SELECT p FROM Product p WHERE p.id = ?1")
//    Product toFindProductByBillID(Integer id);

    List<Product> findProductByCategoryID(Integer categoryID);

    List<Product> findProductByBrandID(Integer brandID);

    List<Product> findProductByNameStartsWith(String name);

    List<Product> findProductByPriceBetween(int min,int max);

}
