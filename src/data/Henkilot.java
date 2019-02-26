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
public class Henkilot {

    private int henkiloID;
    private String etunimi;
    private String sukunimi;
    private String syntymaaika;
    private int osoite;
    private String henkilotunnus;

    public Henkilot(int henkiloID, String etunimi, String sukunimi, String syntymaaika, String henkilotunnus) {

        this.henkiloID = henkiloID;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymaaika = syntymaaika;
        this.henkilotunnus = henkilotunnus;
    }

    public Henkilot(String etunimi, String sukunimi, String syntymaaika, String henkilotunnus) {

        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.syntymaaika = syntymaaika;
        this.henkilotunnus = henkilotunnus;
    }
    

    public String getEtunimi() {
        return etunimi;
    }

    public void setEtunimi(String etunimi) {
        this.etunimi = etunimi;
    }

    public String getSukunimi() {
        return sukunimi;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public String getSyntymaaika() {
        return syntymaaika;
    }

    public void setSyntymaaika(String syntymaaika) {
        this.syntymaaika = syntymaaika;
    }

    public String getHenkilotunnus() {
        return henkilotunnus;
    }

    public void setHenkilotunnus(String henkilotunnus) {
        this.henkilotunnus = henkilotunnus;
    }

    @Override
    public String toString() {
        return (String) etunimi +" "+ sukunimi;
    }

    public int getHenkiloID() {
        return henkiloID;
    }

    public void setHenkiloID(int henkiloID) {
        this.henkiloID = henkiloID;
    }

    public int getOsoite() {
        return osoite;
    }

    public void setOsoite(int osoite) {
        this.osoite = osoite;
    }
    
    
}
