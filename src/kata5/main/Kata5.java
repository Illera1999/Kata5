package kata5.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import kata5.model.Histograma;
import kata5.model.Mail;
import kata5.view.HistogramDisplay;
import kata5.view.MailHistogramBuilder;

public class Kata5 {
    
    private static final List<Mail> miList = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data/US500.db");
                Statement statement = connection.createStatement()){
            ResultSet set = statement.executeQuery("SELECT * FROM people");
            while (set.next()){
                String email = set.getString("email");
                miList.add(new Mail(email));

            }
                Histograma <String> histograma = MailHistogramBuilder.build(miList);
                HistogramDisplay histoDisplay= new HistogramDisplay("HISTOGRAMA", histograma);
        }
    }

}
