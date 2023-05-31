package pl.kamski.Sales.cart;

import pl.kamski.Sales.cart.Cart;
import pl.kamski.Sales.reservation.Reservation;

import java.util.HashMap;
import java.util.Optional;

public class CartStorage {
    HashMap<String, Cart> carts;

    public CartStorage() {
        this.carts = new HashMap<>();
    }

    public Optional<Cart> load(String customerId) {
        return Optional.ofNullable(carts.get(customerId));
    }

    public void save(String customerId, Cart customersCart) {
        carts.put(customerId, customersCart);
    }

    public void save(Reservation reservation) {

    }
}