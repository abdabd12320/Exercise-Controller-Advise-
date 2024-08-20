package com.example.thetouringsuppliessystem.Repository;

import com.example.thetouringsuppliessystem.Model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {

    Bill findBillById(Integer id);

    Bill findBillByProductIDAndUserID(Integer productID, Integer userID);

    @Query("SELECT COUNT(b.id) FROM Bill b")
    String findCountBills();

    @Query("SELECT SUM(b.total) FROM Bill b")
    String findSumBills();

    List<Bill> findBillByTypeOfOrder(String typeOfOrder);
}
