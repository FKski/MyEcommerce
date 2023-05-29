package pl.kamski.Sales;

import org.aspectj.apache.bcel.util.Repository;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class ReservationStorageTest {

    @Autowired
    ReservationRepository repository;
    @Test
    void insert(){
        Reservation reservation = new Reservation("res-1234abcd", BigDecimal.valueOf(10.10), "payu/12345");
        repository.save(reservation);

        Reservation loaded = repository
                .findById("res-12345abcd")
                .get();

        assert loaded.getId().equals(reservation.getId());
    }
    @Test
    void select(){

    }


}
