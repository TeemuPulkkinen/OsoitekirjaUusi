/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import data.Henkilot;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author s1800591
 */
public class Tietokanta {
    
    /*private String etunimi;
    private String sukunimi;
    private String osoite;
    private int syntymaaika;
    private String henkilotunnus;
    */
    private String sqlLisaaHenkilo = "insert into henkilo (henkiloID, "
            + " etunimi, sukunimi, syntymaaika, osoite, henkilotunnus) select (coalesce(max(henkiloID)+1,0)),?,?,?,?,? from henkilo";
    
    public void lisaaHenkilo(Henkilot henkilo) {
        Connection yhteys = null;
        /*
    Tehdään try-catch rakenne, joka testaa onko tietokantayhteydessä ongelmia
    try-kohta kertoo mitä yritetään tehdä. Catch kertoo mitä tehdään jos ei onnistu.
         */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // tähän tietokannan nimi, käyttäjätunnus ja salasana kun testaat
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");
            // Javan puolella ei haittaa vaik insertit ois pienellä.

            PreparedStatement henkilonLisays = yhteys.prepareStatement(sqlLisaaHenkilo);
            // parameter index tarkoittaa mones kysymysmerkki on kyseessä. eka kysmerkki on 1
            /*sqlLisaaHenkilo.setString(1, henkilo.getEtunimi());
            sqlLisaaHenkilo.setString(2, henkilo.getSukunimi());
            sqlLisaaHenkilo.setInt(3, henkilo.getSyntymaaika());
            sqlLisaaHenkilo.setString(4, henkilo.getHenkilotunnus());
            */
            henkilonLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }
}
