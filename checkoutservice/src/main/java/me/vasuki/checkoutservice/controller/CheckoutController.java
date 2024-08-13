package me.vasuki.checkoutservice.controller;

import me.vasuki.checkoutservice.model.Checkout;
import me.vasuki.checkoutservice.repository.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:3000") // Adjust to match your React app URL
public class CheckoutController {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @PostMapping("/add")
    public ResponseEntity<String> submitCheckoutForm(@RequestBody Checkout formDTO) {
        try {
            Checkout checkout = new Checkout();
            checkout.setName(formDTO.getName());
            checkout.setAddress(formDTO.getAddress());
            checkout.setCardNumber(formDTO.getCardNumber());
            checkout.setExpirationDate(formDTO.getExpirationDate());
            checkout.setCvv(formDTO.getCvv());

            checkoutRepository.save(checkout);

            return new ResponseEntity<>("Checkout information saved successfully!", HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the error for further analysis
            System.err.println("Failed to save checkout information: " + e.getMessage());
            return new ResponseEntity<>("Failed to save checkout information", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
