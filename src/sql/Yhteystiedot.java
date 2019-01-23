/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sql;

/**
 *
 * @author s1800591
 */
public class Yhteystiedot {

    static String getAjuri() {
        return "com.mysql.jdbc.Driver";
    }

    static String getUrl() {
        // muuta tähän oman tietokannan osoite
        return "jdbc:mysql://10.9.0.60/";
    }
    // tähän tulee phpMyAdmin käyttäjätunnus

    static String getKayttajatunnus() {
        return "";
    }

    static String getSalasana() {
        // muuta tähän phpMyAdmin salasana kun testaat
        return "";
    }
}

//testiä
