package pl.kamski.Sales;

import org.springframework.expression.spel.ast.OpAnd;

import java.util.Optional;

public class CartStorage {
    public Optional<Cart> cart;

    public Optional<Cart> load(String customerId) {
    return null;
    }

    public void save(String customerId, Cart cart) {
    }
}
