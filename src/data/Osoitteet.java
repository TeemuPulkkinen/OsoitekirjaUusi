/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author s1800591
 */
public class Osoitteet {

    private int osoiteID;
    private String katu;
    private int talonro;
    private String postinro;
    private String kaupunki;

    public Osoitteet(int osoiteID, String katu, int talonro, String postinro, String kaupunki) {

        this.osoiteID = osoiteID;
        this.katu = katu;
        this.talonro = talonro;
        this.postinro = postinro;
        this.kaupunki = kaupunki;
    }
    
    public Osoitteet(String katu, int talonro, String postinro, String kaupunki) {

        this.katu = katu;
        this.talonro = talonro;
        this.postinro = postinro;
        this.kaupunki = kaupunki;
    }

    public String getKatu() {
        return katu;
    }

    public void setKatu(String katu) {
        this.katu = katu;
    }

    public int getTalonro() {
        return talonro;
    }

    public void setTalonro(int talonro) {
        this.talonro = talonro;
    }

    public String getPostinro() {
        return postinro;
    }

    public void setPostinro(String postinro) {
        this.postinro = postinro;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

    public int getOsoiteID() {
        return osoiteID;
    }

    public void setOsoiteID(int osoiteID) {
        this.osoiteID = osoiteID;
    }

    @Override
    public String toString() {
        return "Osoitteet{" + "katu=" + katu + ", talonro=" + talonro + ", postinro=" + postinro + ", kaupunki=" + kaupunki + '}';
    }

}
