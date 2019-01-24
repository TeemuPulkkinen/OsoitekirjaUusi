/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author s1800591
 */
public class OsoitteenMuutos extends JFrame {
    
    //Ulos kommentoidut komponentit voidaan koittaa saada toimimaan tarvittaessa :)
    private JPanel pPohja = new JPanel(new GridLayout(7,1));
    private JPanel pKatu = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pTalonro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pPostinro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pKaupunki = new JPanel(new FlowLayout(FlowLayout.LEFT));
    //private JPanel combo = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtoni = new JPanel(new FlowLayout(FlowLayout.LEFT));
    //private JPanel pTiedot = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JLabel lbKatu = new JLabel("Katu:");
    private JLabel lbTalonro = new JLabel("Talonumero:");
    private JLabel lbPostinro = new JLabel("Postinumero:");
    private JLabel lbKaupunki = new JLabel("Kaupunki:");
    private JTextField tfKatu = new JTextField(15);
    private JTextField tfTalonro = new JTextField(7);
    private JTextField tfPostinro = new JTextField(5);
    private JTextField tfKaupunki = new JTextField(15);
    //private JComboBox osoitteenHenkilo;
    private JTextArea vanhanOmistajanTiedot = new JTextArea(5, 20);
    //private JScrollPane rullaavaOmistaja = new JScrollPane(vanhanOmistajanTiedot);
    private JButton tallenna = new JButton("Tallenna");

    public OsoitteenMuutos() {
        
        this.setTitle("Muuta osoite");
        this.setSize(350, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        asetteleKomponentit();
    }

    private void asetteleKomponentit() {
        
        pPohja.add(pKatu);
        pPohja.add(pTalonro);
        pPohja.add(pPostinro);
        pPohja.add(pKaupunki);
        pPohja.add(pButtoni);
        
        pKatu.add(lbKatu);
        pKatu.add(tfKatu);
        
        pTalonro.add(lbTalonro);
        pTalonro.add(tfTalonro);
        
        pPostinro.add(lbPostinro);
        pPostinro.add(tfPostinro);
        
        pKaupunki.add(lbKaupunki);
        pKaupunki.add(tfKaupunki);
        
        //combo.add(osoitteenHenkilo);
        
        //pTiedot.add(rullaavaOmistaja);
        
        pButtoni.add(tallenna);
        
        this.add(pPohja);
    }
    
    public static void main(String[] args) {
        
        OsoitteenMuutos oikkuna = new OsoitteenMuutos();
        oikkuna.setVisible(true);
    }
}
