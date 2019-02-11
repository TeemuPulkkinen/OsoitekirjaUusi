/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author s1800591
 */
public class HenkilonLisays extends JFrame {

    //paneelit
    private JPanel pPohja = new JPanel(new GridLayout(6, 1));
    private JPanel pEtunimi = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pSukunimi = new JPanel(new FlowLayout(FlowLayout.LEFT));
    //private JPanel pOsoite = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pSyntymaaika = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHenkilotunnus = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtonit = new JPanel(new FlowLayout(FlowLayout.LEFT));

    //labelit
    private JLabel lbEtunimi = new JLabel("Etunimi");
    private JLabel lbSukunimi = new JLabel("Sukunimi");
    //private JLabel lbOsoite = new JLabel("Osoite");
    private JLabel lbSyntymaaika = new JLabel("Syntymäaika");
    private JLabel lbHenkilotunnus = new JLabel("Henkilötunnus");

    //text fieldit
    private JTextField tfEtunimi = new JTextField(15);
    private JTextField tfSukunimi = new JTextField(15);
    //private JTextField tfOsoite = new JTextField();
    private JTextField tfSyntymaaika = new JTextField(15);
    private JTextField tfHenkilotunnus = new JTextField(15);

    //buttonit
    private JButton btLisaa = new JButton("Lisää");
    private JButton btPeruuta = new JButton("Peruuta");

    public HenkilonLisays() {

        this.setTitle("Henkilötietojen syöttö");
        this.setSize(400, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        asetteleKomponentit();

    }

    private void asetteleKomponentit() {

        pEtunimi.add(lbEtunimi);
        pEtunimi.add(tfEtunimi);

        pSukunimi.add(lbSukunimi);
        pSukunimi.add(tfSukunimi);

        pSyntymaaika.add(lbSyntymaaika);
        pSyntymaaika.add(tfSyntymaaika);

        pHenkilotunnus.add(lbHenkilotunnus);
        pHenkilotunnus.add(tfHenkilotunnus);

        pButtonit.add(btLisaa);
        pButtonit.add(btPeruuta);
        
        /*pOsoite.add(lbOsoite);
        pOsoite.add(tfOsoite);
        */
        pPohja.add(pEtunimi);
        pPohja.add(pSukunimi);
        //pPohja.add(pOsoite);
        pPohja.add(pSyntymaaika);
        pPohja.add(pHenkilotunnus);
        pPohja.add(pButtonit);

        this.add(pPohja);

    }
    // Lisäysikkunat ei enää tarvitse omaa main metodia.
    //public static void main(String[] args) {

        //HenkilonLisays ikkuna = new HenkilonLisays();
        //ikkuna.setVisible(true);
    //}
}
