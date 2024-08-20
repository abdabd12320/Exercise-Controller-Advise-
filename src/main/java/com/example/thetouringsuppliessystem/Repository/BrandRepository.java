package com.example.thetouringsuppliessystem.Repository;

import com.example.thetouringsuppliessystem.Model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {

    Brand findBrandById(Integer id);

    Brand findBrandByName(String name);
}
