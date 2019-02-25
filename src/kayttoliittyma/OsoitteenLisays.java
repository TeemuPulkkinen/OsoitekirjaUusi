/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import data.Osoitteet;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sql.Tietokanta;

/**
 *
 * @author s1801210
 */
public class OsoitteenLisays extends JFrame {

    private JPanel pPohja = new JPanel(new GridLayout(7, 1));
    private JPanel pKatu = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pTalonro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pPostinro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pKaupunki = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtoni = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JLabel lbKatu = new JLabel("Katu:");
    private JLabel lbTalonro = new JLabel("Talonumero:");
    private JLabel lbPostinro = new JLabel("Postinumero:");
    private JLabel lbKaupunki = new JLabel("Kaupunki:");

    private JTextField tfKatu = new JTextField(15);
    private JTextField tfTalonro = new JTextField(7);
    private JTextField tfPostinro = new JTextField(5);
    private JTextField tfKaupunki = new JTextField(15);

    private JButton btLisaa = new JButton("Lisää");
    private JButton btPeruuta = new JButton("Peruuta");

    public OsoitteenLisays() {

        this.setTitle("Lisää osoite");
        this.setSize(350, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        asetteleKomponentit();

        btLisaa.addActionListener(new osoitetiedonLisays());
        btPeruuta.addActionListener(new peruuta());
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

        pButtoni.add(btLisaa);
        pButtoni.add(btPeruuta);

        this.add(pPohja);
    }

    private class osoitetiedonLisays implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            lisaaOsoiteKantaan();
        }

    }
    
    // Tee osoitteen lisäykselle kotitehtävänä oma metodi.
    private void lisaaOsoiteKantaan() {

        Tietokanta kanta = new Tietokanta();
        
        String katu = tfKatu.getText();
        int talonro = Integer.parseInt(tfTalonro.getText());
        String postinro = tfPostinro.getText();
        String kaupunki = tfKaupunki.getText();
        
        Osoitteet osoite = new Osoitteet(katu, talonro, postinro, kaupunki);
        
        kanta.lisaaOsoite(osoite);
        
        tfKatu.setText("");
        tfTalonro.setText("");
        tfPostinro.setText("");
        tfKaupunki.setText("");
    }

    private class peruuta implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            suljeIkkuna();
        }

    }
    
    private void suljeIkkuna() {
        
        super.dispose();
    }
}
