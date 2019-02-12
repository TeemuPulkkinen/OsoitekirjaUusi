/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import data.Henkilot;
import data.Osoitteet;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

/**
 *
 * @author s1800591
 */
public class Tietokanta {

    private String uusiOsoiteSQL = "insert into Osoitteet(katu,talonro,postinro,kaupunki) values(?,?,?,?)";
    private String uusiHenkiloSQL = "insert into Henkilot(etunimi,sukunimi,henkilotunnus) values(?,?,?)";

    public void lisaaOsoite(Osoitteet osoite) {
        Connection yhteys = null;
        /*
    Tehdään try-catch rakenne, joka testaa onko tietokantayhteydessä ongelmia
    try-kohta kertoo mitä yritetään tehdä. Catch kertoo mitä tehdään jos ei onnistu.
         */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");

            PreparedStatement osoitteenLisays = yhteys.prepareStatement(uusiOsoiteSQL);
            // parameter index tarkoittaa mones kysymysmerkki on kyseessä. eka kysmerkki on 1
            osoitteenLisays.setString(1, osoite.getKatu());
            osoitteenLisays.setInt(2, osoite.getTalonro());
            osoitteenLisays.setString(3, osoite.getPostinro());
            osoitteenLisays.setString(4, osoite.getKaupunki());

            osoitteenLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }

    public void lisaaHenkilo(Henkilot henkilo) {
        Connection yhteys = null;
        /*
    Tehdään try-catch rakenne, joka testaa onko tietokantayhteydessä ongelmia
    try-kohta kertoo mitä yritetään tehdä. Catch kertoo mitä tehdään jos ei onnistu.
         */

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");

            PreparedStatement henkilonLisays = yhteys.prepareStatement(uusiHenkiloSQL);

            // Muutetaan String-muotoinen päivämäärä Date-tyypiksi
            /*String syntymaaika = "2018-01-20";
            Date utilDate = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(syntymaaika);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             */
            henkilonLisays.setString(1, henkilo.getEtunimi());
            henkilonLisays.setString(2, henkilo.getSukunimi());
            //henkilonLisays.setDate(3, sqlDate);
            henkilonLisays.setString(3, henkilo.getHenkilotunnus());

            henkilonLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }

}
