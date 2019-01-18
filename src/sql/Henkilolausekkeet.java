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
public class Henkilolausekkeet {
    
    private String ajuri;
    private String url;
    private String kayttaja;
    private String salasana;
    //sql-lauseet 
    private String sqlHaeHenkilo = "select henkilotunnus,etunimi,"
            + "sukunimi, syntymaaika, osoite from henkilo where henkilotunnus=?";
    private String sqlHaeKaikkiHenkilot = "select henkilotunnus,etunimi,"
            + "sukunimi, syntymaaika, osoite from henkilo";
    private String sqlHaeHenkilonID = "select henkiloID from henkilo "
            + "where henkilotunnus=?";

    private String sqlLisaaHenkilo = "insert into henkilo (henkiloID, "
            + " etunimi, sukunimi, syntymaaika, osoite, henkilotunnus) select (coalesce(max(henkiloID)+1,0)),?,?,?,?,? from henkilo";

    private String sqlPoistaHenkilo = "delete from henkilo where henkilotunnus=?";
    private String sqlMuutaHenkilonTietoja = "update henkilo set etunimi=?, sukunimi=?, syntymaaika=? WHERE henkilotunnus=?";

    private String sqlMuutaHenkilonOsoite = "update henkilo set osoite=? where henkilotunnus = ?";

    public Henkilolausekkeet(String ajuri, String url, String kayttaja, String salasana) {
        this.ajuri = ajuri;
        this.url = url;
        this.kayttaja = kayttaja;
        this.salasana = salasana;
    }
}
