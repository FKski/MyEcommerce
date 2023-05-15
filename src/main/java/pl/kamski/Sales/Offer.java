package pl.kamski.Sales;

import java.math.BigDecimal;

public class Offer {

    BigDecimal total;
    Integer itemsCount;
    public Offer(){
        this.total = BigDecimal.valueOf(185);
        this.itemsCount = 2;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }
}
