package mg.tomamiarilaza.gestion_de_stock.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Class for getting connection to the database
    public static Connection getConnection() throws Exception {
        // Fonction qui renvoie la connection vers la base :
        String database = "gestion_stock";       // Nom de la base
        String user = "postgres";       // User dans postgres
        String mdp = "postgres";       // Mot de passe

        // Creation de l'objet de connection
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + database, user, mdp);

        connection.setAutoCommit(false);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Connection : " + getConnection());
    }

}
