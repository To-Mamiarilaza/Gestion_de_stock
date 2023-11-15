package mg.tomamiarilaza.gestion_de_stock.stockservice;

import connection.DBConnection;
import generalisation.GenericDAO.GenericDAO;
import generalisation.utils.GenericUtil;
import mg.tomamiarilaza.gestion_de_stock.article.Article;
import mg.tomamiarilaza.gestion_de_stock.movement.Incoming;
import mg.tomamiarilaza.gestion_de_stock.movement.Outgoing;
import mg.tomamiarilaza.gestion_de_stock.stock.EtatStock;
import mg.tomamiarilaza.gestion_de_stock.stock.Stock;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;

public class StockService {
    // Class for managing stock

    // Method for out of stock
    public static double getStockAmount(List<Stock> stockList) {
        double sum = 0;
        for (Stock stock :
                stockList) {
            sum += stock.getAmount();
        }
        return sum;
    }

    // Get the remaining and stock value between two date
    public static EtatStock getEtatStock(String dateDebut, String dateFin, String idArticle, String idStore) throws Exception {
        LocalDate dateDebutValue = LocalDate.parse(dateDebut);  // Throw if date debut not given
        LocalDate dateFinValue = LocalDate.parse(dateFin);

        String query = "SELECT * FROM get_stock_availability('" + dateDebut + "', '" + dateFin + "') WHERE article_code LIKE '%" + idArticle + "%' AND id_store LIKE '%" + idStore + "%'";

        List<Stock> stockList = GenericDAO.directQuery(Stock.class, query, null);
        double stockAmount = getStockAmount(stockList);

        return new EtatStock(dateDebutValue, dateFinValue, idArticle, idStore, stockList, stockAmount);
    }

    // Verify the input data validity
    public static void checkAllParameter(String date, String idArticle, String idStore, String quantity, String unitPrice) throws Exception {
        if (date == null || date.trim().equals("")) throw new Exception("La date du sortie de stock ne doit pas être null !");
        if (idArticle == null || idArticle.trim().equals("")) throw new Exception("L' article ne doit pas être null !");
        if (idStore == null || idStore.trim().equals("")) throw new Exception("Le magasin ne doit pas être null !");
        if (quantity == null || quantity.trim().equals("")) throw new Exception("La quantité ne doit pas être null !");
        if (unitPrice == null || unitPrice.trim().equals("")) throw new Exception("Le prix unitaire ne doit pas être null !");
    }

    // The minimum possible unit price will be given by ajax ( Think about OutRequest Object )
    public static void sortir(String date, String idArticle, String idStore, String quantity, String unitPrice) throws Exception {
        checkAllParameter(date, idArticle, idStore, quantity, unitPrice);

        // Get all needed value
        LocalDate dateValue = LocalDate.parse(date);
        double quantityValue = Double.valueOf(quantity);
        double unitPriceValue = Double.valueOf(unitPrice);      // We will think about how to get unit price after

        Connection connection = DBConnection.getConnection();
        Article article = GenericDAO.findById(Article.class, idArticle, connection);

        // Remaining article stock
        String order = article.getMovementType().equals(Article.FIFO_METHOD) ? "ASC" : "DESC";
        String query = "SELECT * FROM v_incoming_stock WHERE id_article = '" + article.getIdArticle() + "' AND date <= '" + date + "' ORDER BY date " + order;
        List<Incoming> incomingList = GenericDAO.directQuery(Incoming.class, query, connection);

        for (Incoming incoming : incomingList) {
            if (incoming.getQuantity() < quantityValue) {
                quantityValue -= incoming.getQuantity();
                Outgoing outgoing = new Outgoing(dateValue, incoming, incoming.getQuantity(), unitPriceValue, 1);
                GenericDAO.save(outgoing, connection);
            } else {
                Outgoing outgoing = new Outgoing(dateValue, incoming, quantityValue, unitPriceValue, 1);
                GenericDAO.save(outgoing, connection);
                quantityValue = 0;
                break;
            }
        }

        if (quantityValue != 0) {
            connection.rollback();
            throw new Exception("La quantité dans le stock est insuffisant !");
        } else {
            connection.commit();
        }

    }

    public static void main(String[] args) throws Exception {
        EtatStock etatStock = getEtatStock("2023-01-12", "2023-02-15", "R01", "");
        etatStock.showDetail();
        // sortir("2023-02-01", "ART0002", "STR0001", "1000", "");
    }

}
