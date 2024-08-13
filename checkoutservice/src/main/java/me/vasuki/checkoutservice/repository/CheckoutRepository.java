package me.vasuki.checkoutservice.repository;

import me.vasuki.checkoutservice.model.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRepository  extends JpaRepository<Checkout, Long> {
}
