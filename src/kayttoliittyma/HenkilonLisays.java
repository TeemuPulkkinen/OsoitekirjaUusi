/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author s1800591
 */
public class HenkilonLisays extends JFrame {

    //paneelit
    private JPanel pIkkuna = new JPanel();
    private JPanel pEtunimi = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pSukunimi = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pOsoite = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pSyntymaaika = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHenkilotunnus = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtonit = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    //labelit
    private JLabel lbEtunimi = new JLabel("Etunimi");
    private JLabel lbSukunimi = new JLabel("Sukunimi");
    private JLabel lbOsoite = new JLabel("Osoite");
    private JLabel lbSyntymaaika = new JLabel("Syntymäaika");
    private JLabel lbHenkilotunnus = new JLabel("Henkilötunnus");
    //text fieldit
    private JTextField tfEtunimi = new JTextField();
    private JTextField tfSukunimi = new JTextField();
    private JTextField tfOsoite = new JTextField();
    private JTextField tfSyntymaaika = new JTextField();
    private JTextField tfHenkilotunnus = new JTextField();
    //buttonit
    private JButton btLisaa = new JButton();
    private JButton btPeruuta = new JButton();

    public HenkilonLisays() {

        this.setTitle("Henkilötietojen syöttö");
        this.setSize(600, 450);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        asetteleKomponentit();
        this.setVisible(true);

    }
    private void asetteleKomponentit() {
        
        pIkkuna.add(pEtunimi);
        pIkkuna.add(pSukunimi);
        pIkkuna.add(pSukunimi);
        pIkkuna.add(pOsoite);
        pIkkuna.add(pSyntymaaika);
        pIkkuna.add(pHenkilotunnus);
        pIkkuna.add(pButtonit);
        
    }
    public static void main(String[] args) {
        
        HenkilonLisays ikkuna = new HenkilonLisays();
    }
}
