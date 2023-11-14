package mg.tomamiarilaza.gestion_de_stock.stock;

import generalisation.annotations.DBField;
import mg.tomamiarilaza.gestion_de_stock.article.Article;
import mg.tomamiarilaza.gestion_de_stock.store.Store;

public class Stock {
    // This class is representing the function get_stock_availability(start_date, end_date) on the database

    // Field
    @DBField(name = "id_article", isForeignKey = true)
    Article article;

    @DBField(name = "id_store", isForeignKey = true)
    Store store;

    @DBField(name = "initial_quantity")
    double initialQuantity;

    @DBField(name = "reste")
    double remain;

    @DBField(name = "unit_price")
    double unitPrice;

    @DBField(name = "amount")
    double amount;

    // Getter and setter

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public double getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(double initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public double getRemain() {
        return remain;
    }

    public void setRemain(double remain) {
        this.remain = remain;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Constructor

    public Stock() {
    }

    public Stock(Article article, Store store, double initialQuantity, double remain, double unitPrice, double amount) {
        this.article = article;
        this.store = store;
        this.initialQuantity = initialQuantity;
        this.remain = remain;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }
}
