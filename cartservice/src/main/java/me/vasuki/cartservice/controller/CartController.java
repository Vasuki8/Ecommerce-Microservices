package me.vasuki.cartservice.controller;

import me.vasuki.cartservice.model.CartItem;
import me.vasuki.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        CartItem cartItem = cartService.getCartItemById(id);
        if (cartItem != null) {
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/cart")
    public ResponseEntity<String> saveCartItem(@RequestBody CartItem cartItem) {
        CartItem savedCartItem = cartService.saveCartItem(cartItem);
        return new ResponseEntity<>("Cart item added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCartItemQuantity(@PathVariable Long id, @RequestBody CartItem updatedCartItem) {
        try {
            cartService.updateCartItemQuantity(id, updatedCartItem.getQuantity());
            return new ResponseEntity<>("Cart item quantity updated successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cart item not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable Long id) {
        try {
            cartService.deleteCartItem(id);
            return new ResponseEntity<>("Cart item deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cart item not found", HttpStatus.NOT_FOUND);
        }
    }
}
