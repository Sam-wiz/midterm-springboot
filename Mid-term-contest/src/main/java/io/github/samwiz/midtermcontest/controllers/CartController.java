package io.github.samwiz.midtermcontest.controllers;


import io.github.samwiz.midtermcontest.models.Cart;
import io.github.samwiz.midtermcontest.services.Carts;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController
{

    private final Carts service;
    public CartController(Carts service)
    {
        this.service = service;
    }
    @GetMapping("")
    public ResponseEntity<List<Cart>> getAll()
    {
        return ResponseEntity.ok(this.service.getAll());
    }
    @GetMapping("/{id}")
    public  ResponseEntity<Cart> getById(@PathVariable Long id)
    {
        Cart c = this.service.getById(id);
        return ResponseEntity.ok(c);
    }
    @GetMapping("/{startdate}/{enddate}")
    public ResponseEntity<List<Cart>> getByDate(@PathVariable String startdate, @PathVariable String enddate)
    {
        List<Cart> ans = this.service.getByDate(startdate, enddate);
        return ResponseEntity.ok(ans);
    }
    @GetMapping("/user/{userId}")
    public  ResponseEntity<List<Cart>> getByUser(@PathVariable Long userId)
    {
        List<Cart> ans = this.service.getByUser(userId);
        return ResponseEntity.ok(ans);
    }
    @PostMapping("")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart newCart)
    {
        Cart cartadded = this.service.addToCart(newCart);
        return ResponseEntity.ok(cartadded);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Cart> updateCart(@PathVariable Long id, @RequestBody Cart updatetheCart){
        this.service.updateCart(id,updatetheCart);
        return ResponseEntity.ok(updatetheCart);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Cart> deleteCart(@PathVariable Long id){
        Cart response = this.service.deleteCart(id);
        return ResponseEntity.ok(response);
    }
}
