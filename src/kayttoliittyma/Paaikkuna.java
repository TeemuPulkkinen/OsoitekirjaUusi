package kayttoliittyma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s1800591
 */
public class Paaikkuna extends JFrame {

    private JPanel ikkuna = new JPanel();
    private JPanel lisaaOsoitePaneeli = new JPanel();
    private JPanel lisaaHenkiloPaneeli = new JPanel();
    private JPanel muutaOsoitePaneeli = new JPanel();
    private JPanel haeHenkiloPaneeli = new JPanel();
    private JButton lisaaOsoite = new JButton("Lisää osoite.");
    private JButton lisaaHenkilo = new JButton("Lisää henkilö.");
    private JButton muutaOsoite = new JButton("Muuta henkilön osoite.");
    private JButton haeHenkilo = new JButton("Hae henkilötiedot.");

    public Paaikkuna() {

        GridLayout ikkunaAsettelu = new GridLayout(4, 1);

        ikkuna.setLayout(ikkunaAsettelu);

        ikkuna.add(lisaaOsoitePaneeli);
        ikkuna.add(lisaaHenkiloPaneeli);
        ikkuna.add(muutaOsoitePaneeli);
        ikkuna.add(haeHenkiloPaneeli);

        lisaaOsoitePaneeli.add(lisaaOsoite);
        lisaaHenkiloPaneeli.add(lisaaHenkilo);
        muutaOsoitePaneeli.add(muutaOsoite);
        haeHenkiloPaneeli.add(haeHenkilo);

        this.add(ikkuna);
        this.setLocation(100, 100);
        this.setSize(250, 300);
        this.setTitle("Osoitekirja");
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                suoritaLopputoimet();
            }
        });

    }

    private void suoritaLopputoimet() {
        System.exit(0);
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Paaikkuna();
            }
        });
    }
}
// Testiä
// testi 2
