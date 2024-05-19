package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private final String databaseURL = "jdbc:sqlite:base.db";
    private Connection connection;

    public Database() {
        try {
            // Cria a conexão com o banco de dados
            Connection connectionObject = DriverManager.getConnection(this.databaseURL);
            this.connection = connectionObject;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void initTables() {
        Connection connection = new Database().getConnection();

        try {
            Statement statement = connection.createStatement();

            // Roda os comandos para o SQLite
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,               name TEXT NOT NULL, email TEXT NOT NULL UNIQUE, password TEXT NOT NULL)");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getQuery() {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
