package mg.tomamiarilaza.gestion_de_stock.stock;

import mg.tomamiarilaza.gestion_de_stock.store.Store;

import java.time.LocalDate;
import java.util.List;

public class EtatStock {
    // Field
    LocalDate startDate;
    LocalDate endDate;
    String idArticle;
    Store store;
    List<Stock> stockList;
    double stockTotalValue;

    // Getter and setter

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    public double getStockTotalValue() {
        return stockTotalValue;
    }

    public void setStockTotalValue(double stockTotalValue) {
        this.stockTotalValue = stockTotalValue;
    }

    // Constructor

    public EtatStock(LocalDate startDate, LocalDate endDate, String idArticle, Store store, List<Stock> stockList, double stockTotalValue) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.idArticle = idArticle;
        this.store = store;
        this.stockList = stockList;
        this.stockTotalValue = stockTotalValue;
    }

    public EtatStock(LocalDate startDate, LocalDate endDate, String idArticle, Store store) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.idArticle = idArticle;
        this.store = store;
    }
}
