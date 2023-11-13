package mg.tomamiarilaza.gestion_de_stock.article;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

@DBTable(name = "unite", sequenceName = "seq_unite", prefix = "UNT")
public class Unite {
    // Field
    @DBField(name = "id_unite", isPrimaryKey = true)
    String idUnite;

    @DBField(name = "unite_name")
    String uniteName;

    @DBField(name = "etat")
    int etat;

    // Getter and setter

    public String getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(String idUnite) {
        this.idUnite = idUnite;
    }

    public String getUniteName() {
        return uniteName;
    }

    public void setUniteName(String uniteName) {
        this.uniteName = uniteName;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    // Constructor

    public Unite() {
    }

    public Unite(String uniteName, int etat) {
        this.uniteName = uniteName;
        this.etat = etat;
    }

    public Unite(String idUnite, String uniteName, int etat) {
        this.idUnite = idUnite;
        this.uniteName = uniteName;
        this.etat = etat;
    }
}
