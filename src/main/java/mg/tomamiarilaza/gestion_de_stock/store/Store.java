package mg.tomamiarilaza.gestion_de_stock.store;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

@DBTable(name = "store", sequenceName = "seq_store", prefix = "STR")
public class Store {
    // Field
    @DBField(name = "id_store", isPrimaryKey = true)
    String idStore;

    @DBField(name = "store_name")
    String storeName;

    @DBField(name = "etat")
    int etat;

    // Getter and setter

    public String getIdStore() {
        return idStore;
    }

    public void setIdStore(String idStore) {
        this.idStore = idStore;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    // Constructor

    public Store() {
    }

    public Store(String storeName, int etat) {
        this.storeName = storeName;
        this.etat = etat;
    }

    public Store(String idStore, String storeName, int etat) {
        this.idStore = idStore;
        this.storeName = storeName;
        this.etat = etat;
    }
}
