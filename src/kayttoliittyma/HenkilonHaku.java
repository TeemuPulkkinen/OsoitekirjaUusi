/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/**
 *
 * @author s1800591
 */
public class HenkilonHaku extends JFrame {

    private JPanel pPohja = new JPanel(new GridLayout(5, 1));
    private JPanel pHenkilovalinta = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHenkilonTiedot = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtoni = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JLabel lbHenkilovalinta = new JLabel("Valitse henkilö:");
    private JLabel lbTiedot = new JLabel("Tässä henkilön tiedot:");

    private JComboBox cbHenkilo = new JComboBox();

    private JTextArea taTiedot = new JTextArea(20,20);
    
    private JButton btHae = new JButton("Hae");
    private JButton btPeruuta = new JButton("Peruuta");

    public HenkilonHaku() {
        
        this.setTitle("Hae tiedot");
        this.setSize(350, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        asetteleKomponentit();
    }
    
    private void asetteleKomponentit() {
        
        pPohja.add(pHenkilovalinta);
        pPohja.add(pHenkilonTiedot);
        pPohja.add(pButtoni);
        
        pHenkilovalinta.add(lbHenkilovalinta);
        pHenkilovalinta.add(cbHenkilo);
        cbHenkilo.setPrototypeDisplayValue("Tähän tulee henkilön nimi");
        
        pHenkilonTiedot.add(lbTiedot);
        pHenkilonTiedot.add(taTiedot);
        
        pButtoni.add(btHae);
        pButtoni.add(btPeruuta);
        
        this.add(pPohja);
    }
}
