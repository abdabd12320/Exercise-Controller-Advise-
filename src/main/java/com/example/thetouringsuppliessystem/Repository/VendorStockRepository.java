package com.example.thetouringsuppliessystem.Repository;

import com.example.thetouringsuppliessystem.Model.VendorStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorStockRepository extends JpaRepository<VendorStock,Integer> {

    VendorStock findVendorStockById(Integer id);

    VendorStock findVendorStockByProductID(Integer productID);
}
