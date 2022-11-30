package models;

import java.time.LocalDate;
import java.time.Clock;

public class Transaction {
    private String itemID;
    private Integer qty;
    private LocalDate dateTrans;
    private Clock timeTrans;

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public LocalDate getDateTrans() {
        return dateTrans;
    }

    public void setDateTrans(LocalDate dateTrans) {
        this.dateTrans = dateTrans;
    }

    public Clock getTimeTrans() {
        return timeTrans;
    }

    public void setTimeTrans(Clock timeTrans) {
        this.timeTrans = timeTrans;
    }
}
