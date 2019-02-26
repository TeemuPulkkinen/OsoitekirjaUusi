/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

import data.Henkilot;
import data.Osoitteet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import kayttoliittyma.HenkilonHaku;

/**
 *
 * @author s1800591
 */
public class Tietokanta {

    private String uusiOsoiteSQL = "insert into Osoitteet(katu,talonro,postinro,kaupunki) values(?,?,?,?)";
    private String uusiHenkiloSQL = "insert into Henkilot(etunimi,sukunimi,syntymaaika,henkilotunnus) values(?,?,?,?)";
    private String haeHenkilonTiedotSQL = "select * from Henkilot order by ?";
    private String haeHenkilotListaanSQL = "select henkiloID, etunimi, sukunimi, syntymaaika, henkilotunnus from Henkilot order by ?";
    private String haeOsoitteetListaanSQL = "select osoiteID, katu, talonro, postinro, kaupunki from Osoitteet order by ?";
    private String yhdistaHenkiloJaOsoiteSQL = "update Henkilot set osoite = ? where henkiloID = ?";

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

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");

            PreparedStatement henkilonLisays = yhteys.prepareStatement(uusiHenkiloSQL);

            henkilonLisays.setString(1, henkilo.getEtunimi());
            henkilonLisays.setString(2, henkilo.getSukunimi());
            henkilonLisays.setString(3, henkilo.getSyntymaaika());
            henkilonLisays.setString(4, henkilo.getHenkilotunnus());

            henkilonLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }
    
    public void yhdistaHenkiloJaOsoite(Osoitteet osoite, Henkilot henkilo) {
        
        Connection yhteys = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");
            
            PreparedStatement henkilonJaOsoitteenYhdistaminen = yhteys.prepareStatement(yhdistaHenkiloJaOsoiteSQL); 
            henkilonJaOsoitteenYhdistaminen.setInt(1, osoite.getOsoiteID());
            henkilonJaOsoitteenYhdistaminen.setInt(2, henkilo.getHenkiloID());
            
            henkilonJaOsoitteenYhdistaminen.executeUpdate();
            
            
        } catch (Exception e) {

            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        
    }

    public ArrayList<Henkilot> henkilonTietojenHaku(Henkilot henkiloTulos) {

        ArrayList<Henkilot> haetut = new ArrayList();

        Connection yhteys = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");

            PreparedStatement haeHenkiloKannasta = yhteys.prepareStatement(haeHenkilonTiedotSQL);
            haeHenkiloKannasta.setInt(1, henkiloTulos.getHenkiloID());
            // Koska SQL-haussa on tähti, tulokset tulevat ResultSettinä
            ResultSet hakutulos = haeHenkiloKannasta.executeQuery();

            while (hakutulos.next()) {

                String etunimiHaku = hakutulos.getString("etunimi");
                String sukunimiHaku = hakutulos.getString("sukunimi");
                String syntymaaikaHaku = hakutulos.getString("syntymäaika");
                String henkilotunnusHaku = hakutulos.getString("henkilötunnus");

                //String henkiloTulos = katuHaku + " " + talonroHaku + " " + postinroHaku + " " + kaupunkiHaku;
            }

        } catch (Exception e) {

            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        return haetut;
    }

    public ArrayList<Osoitteet> haeOsoitteetListaan() {

        ArrayList osoiteLista = new ArrayList<>();

        Connection yhteys = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");

            PreparedStatement haeOsoitteetListaan = yhteys.prepareStatement(haeOsoitteetListaanSQL);
            haeOsoitteetListaan.setString(1, "katu");

            ResultSet hakutulos = haeOsoitteetListaan.executeQuery();

            while (hakutulos.next()) {

                while (hakutulos.next()) {

                    Osoitteet haetutOsoitteet = new Osoitteet(hakutulos.getInt(1), hakutulos.getString(2),
                            hakutulos.getInt(3), hakutulos.getString(4), hakutulos.getString(5));

                    osoiteLista.add(haetutOsoitteet);
                }
            }

        } catch (Exception e) {

            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        return osoiteLista;
    }

    public ArrayList<Henkilot> haeHenkilotListaan() {

        ArrayList<Henkilot> haetut = new ArrayList<>();

        Connection yhteys = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");

            PreparedStatement haeHenkiloKannasta = yhteys.prepareStatement(haeHenkilotListaanSQL);
            haeHenkiloKannasta.setString(1, "etunimi");
            
            ResultSet hakutulos = haeHenkiloKannasta.executeQuery();

            while (hakutulos.next()) {

                Henkilot haetutHenkilot = new Henkilot(hakutulos.getInt(1), hakutulos.getString(2),
                        hakutulos.getString(3), hakutulos.getString(4), hakutulos.getString(5));

                haetut.add(haetutHenkilot);
            }

        } catch (Exception e) {

            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }

        return haetut;

    }
    
}
