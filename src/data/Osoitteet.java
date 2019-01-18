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

    private String katu;
    private int talonro;
    private int postinro;
    private String kaupunki;

    public Osoitteet(String katu, int talonro, int postinro, String kaupunki) {
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

    public int getPostinro() {
        return postinro;
    }

    public void setPostinro(int postinro) {
        this.postinro = postinro;
    }

    public String getKaupunki() {
        return kaupunki;
    }

    public void setKaupunki(String kaupunki) {
        this.kaupunki = kaupunki;
    }

}
