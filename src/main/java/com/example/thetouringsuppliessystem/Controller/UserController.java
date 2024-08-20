package com.example.thetouringsuppliessystem.Controller;

import com.example.thetouringsuppliessystem.Api.ApiResponse;
import com.example.thetouringsuppliessystem.Model.User;
import com.example.thetouringsuppliessystem.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUsers()
    {
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("add")
    public ResponseEntity addUser(@Valid@RequestBody User user)
    {
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@Valid@RequestBody User user)
    {
        userService.updateUser(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("User updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted"));
    }
    @PutMapping("/buy-product/{productid}/{userid}/{stock}")
    public ResponseEntity buyProduct(@PathVariable Integer productid,@PathVariable Integer userid,@PathVariable int stock)
    {
        userService.buyProduct(productid, userid, stock);
        return ResponseEntity.status(200).body(new ApiResponse("Done bought"));
    }
    @PutMapping("/return-product/{productid}/{userid}/{stock}")
    public ResponseEntity returnProduct(@PathVariable Integer productid,@PathVariable Integer userid,@PathVariable int stock)
    {
        userService.returnProduct(productid, userid, stock);
        return ResponseEntity.status(200).body(new ApiResponse("Done returned"));
    }
    @PutMapping("/replace-product/{productidbefore}/{productidafter}/{billid}")
    public ResponseEntity replaceProduct(@PathVariable Integer productidbefore,@PathVariable Integer productidafter,@PathVariable Integer billid)
    {
        userService.ReplaceProduct(productidbefore, productidafter, billid);
        return ResponseEntity.status(200).body(new ApiResponse("Done replaced"));
    }
    @PutMapping("/product-rental/{productid}/{userid}/{stock}")
    public ResponseEntity productRental(@PathVariable Integer productid,@PathVariable Integer userid,@PathVariable int stock)
    {
        userService.productRental(productid, userid, stock);
        return ResponseEntity.status(200).body(new ApiResponse("Done rental"));
    }
    @PutMapping("/done-rent/{orderid}")
    public ResponseEntity doneRent(@PathVariable Integer orderid)
    {
        userService.doneRent(orderid);
        return ResponseEntity.status(200).body(new ApiResponse("Rent is done"));
    }
    @PutMapping("/plus/{userid}/{number}/{plus}")
    public ResponseEntity plus(@PathVariable Integer userid,@PathVariable int number,@PathVariable int plus)
    {
        userService.thePlus(userid,number,plus);
        return ResponseEntity.status(200).body(new ApiResponse("Done plus"));
    }

}
