package pl.kamski.Sales.offering;

import java.math.BigDecimal;

public class Offer {

    BigDecimal total;
    Integer itemsCount;
    public Offer(){
        this.total = BigDecimal.valueOf(100);
        this.itemsCount = 0;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Integer getItemsCount() {
        return itemsCount;
    }
}
