package com.example.thetouringsuppliessystem.Repository;

import com.example.thetouringsuppliessystem.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findUserById(Integer id);

    @Query("SELECT u FROM User u WHERE u.numberOfPurchases >= ?1")
    List<User> toFindUserByNumberOfPurchases(int number);

}
