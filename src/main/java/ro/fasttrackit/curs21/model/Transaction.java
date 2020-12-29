package ro.fasttrackit.curs21.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;

    private String product;
    private Type type;
    private double amount;
    @OneToOne
    private Account account;
    @ManyToMany
    private List<Category> categories;

    public Transaction() {
    }

    public Transaction(String product, Type type, double amount, Account account) {
        this(product, type, amount, account, List.of());
    }

    public Transaction(String product, Type type, double amount, Account account, List<Category> categories) {
        this.product = product;
        this.type = type;
        this.amount = amount;
        this.account = account;
        this.categories = categories;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
