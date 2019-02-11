/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author s1800591
 */
public class OsoitteenMuutos extends JFrame {

    private JPanel pPohja = new JPanel(new GridLayout(7, 1));
    private JPanel pHenkilovalinta = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pKatu = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pTalonro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pPostinro = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pKaupunki = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtoni = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JLabel lbHenkilovalinta = new JLabel("Valitse henkilö:");
    private JLabel lbKatu = new JLabel("Katu:");
    private JLabel lbTalonro = new JLabel("Talonumero:");
    private JLabel lbPostinro = new JLabel("Postinumero:");
    private JLabel lbKaupunki = new JLabel("Kaupunki:");

    private JComboBox cbHenkilo = new JComboBox();

    private JTextField tfKatu = new JTextField(15);
    private JTextField tfTalonro = new JTextField(7);
    private JTextField tfPostinro = new JTextField(5);
    private JTextField tfKaupunki = new JTextField(15);

    private JButton btTallenna = new JButton("Tallenna");
    private JButton btPeruuta = new JButton("Peruuta");

    public OsoitteenMuutos() {

        this.setTitle("Muuta osoite");
        this.setSize(350, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        asetteleKomponentit();

        Connection yhteys = null;
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();
            yhteys = DriverManager.getConnection("jdbc:mysql://10.9.0.60/", "", "");
            String st = "select * from Henkilot order by ?";
            PreparedStatement haeHenkiloKannasta = yhteys.prepareStatement(st);
            haeHenkiloKannasta.setString(1, "etunimi");
            // Koska SQL-haussa on tähti, tulokset tulevat ResultSettinä
            ResultSet hakutulos = haeHenkiloKannasta.executeQuery();

            while (hakutulos.next()) {
                cbHenkilo.addItem(hakutulos.getString(1) + " " + hakutulos.getString(2) + " " + hakutulos.getString(3));
            }

        } catch (Exception e) {

            System.out.println("Tapahtui virhe " + e);
            e.printStackTrace();
        }
        btPeruuta.addActionListener(new Peruuta());
    }

    private void asetteleKomponentit() {

        pPohja.add(pHenkilovalinta);
        pPohja.add(pKatu);
        pPohja.add(pTalonro);
        pPohja.add(pPostinro);
        pPohja.add(pKaupunki);
        pPohja.add(pButtoni);

        pHenkilovalinta.add(lbHenkilovalinta);
        pHenkilovalinta.add(cbHenkilo);

        cbHenkilo.setPrototypeDisplayValue("Tähän tulee henkilön nimi");

        pKatu.add(lbKatu);
        pKatu.add(tfKatu);

        pTalonro.add(lbTalonro);
        pTalonro.add(tfTalonro);

        pPostinro.add(lbPostinro);
        pPostinro.add(tfPostinro);

        pKaupunki.add(lbKaupunki);
        pKaupunki.add(tfKaupunki);

        pButtoni.add(btTallenna);
        pButtoni.add(btPeruuta);

        this.add(pPohja);
    }

    private class Peruuta implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            suljeIkkuna();
        }

    }

    private void suljeIkkuna() {

        super.dispose();
    }
}
