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
    private JButton lisaaHenkilo = new JButton("Lisää henkilö");
    private JButton lisaaOsoite = new JButton("Lisää osoite");
    private JButton muutaOsoite = new JButton("Muuta osoitetiedot");
    private JButton haeHenkilo = new JButton("Hae henkilötiedot");

    public Paaikkuna() {

        GridLayout ikkunaAsettelu = new GridLayout(4, 1);

        ikkuna.setLayout(ikkunaAsettelu);

        ikkuna.add(lisaaHenkiloPaneeli);
        ikkuna.add(lisaaOsoitePaneeli);
        ikkuna.add(muutaOsoitePaneeli);
        ikkuna.add(haeHenkiloPaneeli);

        lisaaHenkiloPaneeli.add(lisaaHenkilo);
        lisaaOsoitePaneeli.add(lisaaOsoite);
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
        // liitetään luonti-oliot buttoneihin
        lisaaHenkilo.addActionListener(new uusiHenkiloIkkuna());
        lisaaOsoite.addActionListener(new uusiOsoiteIkkuna());
        muutaOsoite.addActionListener(new uusiOsoitteenMuutosIkkuna());
        haeHenkilo.addActionListener(new uusiHenkilonHakuIkkuna());

    }

    private void suoritaLopputoimet() {
        System.exit(0);
    }

    // Metodi joka luo uuden HenkilonLisays-luokan olion ikkuna
    private void luoHenkiloIkkuna() {

        HenkilonLisays ikkunaHenkilonLisays = new HenkilonLisays();
        ikkunaHenkilonLisays.setVisible(true);
    }

    private void luoOsoiteIkkuna() {

        OsoitteenLisays ikkunaOsoitteenLisays = new OsoitteenLisays();
        ikkunaOsoitteenLisays.setVisible(true);
    }

    private void luoOsoitteenMuutosIkkuna() {

        OsoitteenMuutos ikkunaOsoitteenMuutos = new OsoitteenMuutos();
        ikkunaOsoitteenMuutos.setVisible(true);
    }
    
    private void luoHenkilonHakuIkkuna() {
        
        HenkilonHaku ikkunaHenkilonHaku = new HenkilonHaku();
        ikkunaHenkilonHaku.setVisible(true);
    }

    /* funktio joka hyödyntää luotua luoHenkiloIkkuna-metodia, tämä voidaan liittää
    buttoniin.   
     */
    private class uusiHenkiloIkkuna implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            luoHenkiloIkkuna();
        }
    }

    private class uusiOsoiteIkkuna implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            luoOsoiteIkkuna();
        }
    }

    private class uusiOsoitteenMuutosIkkuna implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            luoOsoitteenMuutosIkkuna();
        }
    }

    private class uusiHenkilonHakuIkkuna implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            luoHenkilonHakuIkkuna();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Paaikkuna();
            }
        });
    }
}