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
import java.util.Scanner;

/**
 *
 * @author s1800591
 */
public class Tietokanta {

    private String uusiOsoiteSQL = "insert into Osoitteet(katu,talonro,postinro,kaupunki) values(?,?,?,?)";

    public void lisaaOsoite(Osoitteet osoite) {
        Connection yhteys = null;
        /*
    Tehdään try-catch rakenne, joka testaa onko tietokantayhteydessä ongelmia
    try-kohta kertoo mitä yritetään tehdä. Catch kertoo mitä tehdään jos ei onnistu.
         */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");
            // Javan puolella ei haittaa vaik insertit ois pienellä.

            PreparedStatement osoitteenLisays = yhteys.prepareStatement(uusiOsoiteSQL);
            // parameter index tarkoittaa mones kysymysmerkki on kyseessä. eka kysmerkki on 1
            osoitteenLisays.setString(1, osoite.getKatu());
            osoitteenLisays.setInt(2, osoite.getTalonro());
            osoitteenLisays.setInt(3, osoite.getPostinro());
            osoitteenLisays.setString(4, osoite.getKaupunki());

            osoitteenLisays.executeUpdate();

        } catch (Exception e) {
            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
    }
    
    // Tässä testataan, että Osoitteet-tauluun voidaan syöttää dataa
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);

        Tietokanta kanta = new Tietokanta();

        System.out.println("Tämä on osoitteenlisäystesti");
        System.out.println("Anna kadun nimi:");
        String katu = lukija.nextLine();
        System.out.println("Anna talon numero:");
        int talonro = Integer.parseInt(lukija.nextLine());
        System.out.println("Anna postinumero:");
        int postinro = Integer.parseInt(lukija.nextLine());
        System.out.println("Anna kaupungin nimi:");
        String kaupunki = lukija.nextLine();
        
        Osoitteet osoite = new Osoitteet(katu, talonro, postinro, kaupunki);
        
        kanta.lisaaOsoite(osoite);
    }
}
