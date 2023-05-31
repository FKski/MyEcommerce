package pl.kamski.Sales.reservation;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import pl.kamski.Sales.offering.Offer;

import java.math.BigDecimal;

@Entity
public class Reservation {

    @Id
    private  String id;
    private  BigDecimal total;
    private  String paymentId;

    public Reservation() {}
    public Reservation(String id, BigDecimal total, String paymentId) {
        this.id = id;
        this.total = total;
        this.paymentId = paymentId;
    }
}
