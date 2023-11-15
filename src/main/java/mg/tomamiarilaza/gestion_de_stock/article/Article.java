package mg.tomamiarilaza.gestion_de_stock.article;

import generalisation.annotations.DBField;
import generalisation.annotations.DBTable;

@DBTable(name = "article", sequenceName = "seq_article", prefix = "ART")
public class Article {
    // Field
    @DBField(name = "id_article", isPrimaryKey = true)
    String idArticle;

    @DBField(name = "article_code")
    String articleCode;

    @DBField(name = "article_name")
    String articleName;

    @DBField(name = "id_unite", isForeignKey = true)
    Unite unite;

    @DBField(name = "movement_type")
    String movementType;

    @DBField(name = "etat")
    int etat;

    // movement type
    public static final String FIFO_METHOD = "FIFO";
    public static final String LIFO_METHOD = "LIFO";

    // Getter and setter

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public String getMovementType() {
        return movementType;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    // Constructor

    public Article() {
    }

    public Article(String articleCode, String articleName, Unite unite, String movementType, int etat) {
        this.articleCode = articleCode;
        this.articleName = articleName;
        this.unite = unite;
        this.movementType = movementType;
        this.etat = etat;
    }

    public Article(String idArticle, String articleCode, String articleName, Unite unite, String movementType, int etat) {
        this.idArticle = idArticle;
        this.articleCode = articleCode;
        this.articleName = articleName;
        this.unite = unite;
        this.movementType = movementType;
        this.etat = etat;
    }
}
