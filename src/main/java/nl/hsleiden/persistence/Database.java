package nl.hsleiden.persistence;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.postgresql.util.PSQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;
import java.util.Properties;

/**
 * Deze klasse bevat functionaliteit voor het verbinden met de database.
 * Zodra een connectie geopened wordt met de connectFromConfig methode,
 * dient deze ook weer gesloten te worden met disconnect methode.
 *
 * @author Kasper, Jazzlyn, Jacco
 */
public class Database
{
    private Connection connection;

    public boolean hasConnection() throws SQLException
    {
        return connection != null && !connection.isClosed();
    }

    private void connect(String host, String name, String user, String password) throws SQLException
    {
        String connectionString = String.format(
                "jdbc:postgresql://%s/%s?user=%s&password=%s&serverTimezone=UTC",
                host, name, user, password);

        connect(connectionString);
    }


    private void connect(String connectionString) throws SQLException
    {
        if (hasConnection())
        {
            System.err.println("Connection already opened");

            return;
        }

        connection = DriverManager.getConnection(connectionString);
    }

    public void disconnect()
    {

        try {
            if (!hasConnection())
            {
                System.err.println("Connection already closed");

                return;
            }
            connection.close();
        }

        catch (SQLException e) {
            System.err.println("Connection failed to close, leaking...\n" + e);
        }
    }

    public ResultSet query(String queryString) throws SQLException
    {
        Statement statement = connection.createStatement();

        try {
            return statement.executeQuery(queryString);
        } catch (PSQLException e) { return null;}

    }

    public void closeResult(ResultSet result)
    {
        // @NOTE: Keep the null check, so we can just call closeResult on any ResultSet!
        if (result == null) {
            return;
        }
        try {
            Statement statement = result.getStatement();
            result.close();
            statement.close();
        }

        catch (SQLException e) {
            System.err.println("Resulset failed to close, leaking...\n" + e);
        }
    }

    public void useTransactions() throws SQLException
    {
        connection.setAutoCommit(false);
    }

    public void commit() throws SQLException
    {
        connection.commit();
    }

    public void rollback() throws SQLException
    {
        connection.rollback();
    }

    /**
     * Leest het bestand `config.properties`,
     * om hier de naam van de hostname, de databasenaam, gebruikersnaam en wachtwoord uit te halen.
     * `config.properties` moet te vinden zijn in de folder `/src`.
     * Vervolgens verbind deze methode met de database, gebruik makende van gegevens uit `config.properties`.
     * @throws Exception Als de verbinding met de database mislukt is.
     */
    public void connectFromConfig() throws Exception {
        //InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");

//        Properties prop = new Properties();
//        try {
//            File jarpath = new File(Database.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//            String propertiesPath = jarpath.getParentFile().getAbsolutePath();
//            prop.load(new FileInputStream(propertiesPath+"/config.properties"));
//        }catch (IOException e){
//            e.printStackTrace();
//            //deze in is alleen maar zodat wij het bestand niet hoeven te verplaatsen
//            InputStream in = ClassLoader.getSystemResourceAsStream("config.properties");
//            prop.load(in);
//        }

//        String host = prop.getProperty("hostname");
//        String name = prop.getProperty("dbname");
//        String user = prop.getProperty("username");
//        String password = prop.getProperty("password");

        String host = "localhost";
        String name = "wat";
        String user = "postgres";
        String password = "postgres";

        connect(host, name, user, password);
    }

}
