package ro.fasttrackit.curs21.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    private String product;
    private Type type;
    private double amount;

    public Transaction(String product, Type type, double amount) {
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public Transaction() {
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
