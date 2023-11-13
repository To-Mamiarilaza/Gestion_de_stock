package mg.tomamiarilaza.gestion_de_stock.movement;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;
import mg.tomamiarilaza.gestion_de_stock.article.Article;
import mg.tomamiarilaza.gestion_de_stock.store.Store;

import java.time.LocalDate;

@DBTable(name = "incoming", sequenceName = "seq_incoming", prefix = "INC")
public class Incoming {
    // Field
    @DBField(name = "id_incoming", isPrimaryKey = true)
    String idIncoming;

    @DBField(name = "date")
    LocalDate date;

    @DBField(name = "id_article", isForeignKey = true)
    Article article;

    @DBField(name = "id_store", isForeignKey = true)
    Store store;

    @DBField(name = "quantity")
    double quantity;

    @DBField(name = "unit_price")
    double unitPrice;

    @DBField(name = "etat")
    int etat;

    // Getter and setter


    public String getIdIncoming() {
        return idIncoming;
    }

    public void setIdIncoming(String idIncoming) {
        this.idIncoming = idIncoming;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    // Constructor

    public Incoming() {
    }

    public Incoming(LocalDate date, Article article, Store store, double quantity, double unitPrice, int etat) {
        this.date = date;
        this.article = article;
        this.store = store;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.etat = etat;
    }

    public Incoming(String idIncoming, LocalDate date, Article article, Store store, double quantity, double unitPrice, int etat) {
        this.idIncoming = idIncoming;
        this.date = date;
        this.article = article;
        this.store = store;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.etat = etat;
    }
}
