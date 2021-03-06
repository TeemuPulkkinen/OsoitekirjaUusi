/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import sql.Tietokanta;

/**
 *
 * @author s1800591
 */
public class HenkilonHaku extends JFrame {
    
    Tietokanta kanta = new Tietokanta();
    
    private JPanel pPohja = new JPanel(new GridLayout(5, 1));
    private JPanel pHenkilovalinta = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pHenkilonTiedot = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pOsoitteenTiedot = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pButtoni = new JPanel(new FlowLayout(FlowLayout.LEFT));
    
    private JLabel lbHenkilovalinta = new JLabel("Valitse henkilö:");
    private JLabel lbHenkilonTiedot = new JLabel("Tässä henkilön tiedot:");
    private JLabel lbOsoitteenTiedot = new JLabel("Tässä henkilön osoite:");
    
    private JComboBox cbHenkilo = new JComboBox();
    
    private JTextArea taHenkilonTiedot = new JTextArea(20, 20);
    private JTextArea taOsoitteenTiedot = new JTextArea(20, 20);
    
    private JButton btHae = new JButton("Hae");
    private JButton btPeruuta = new JButton("Peruuta");
    
    public HenkilonHaku() {
        
        this.setTitle("Hae tiedot");
        this.setSize(350, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        asetteleKomponentit();
        
        cbHenkilo.setModel(new DefaultComboBoxModel(kanta.haeHenkilotListaan().toArray()));
        
        btHae.addActionListener(new HaeTiedot());
        btPeruuta.addActionListener(new Peruuta());
    }
    
    private void asetteleKomponentit() {
        
        pPohja.add(pHenkilovalinta);
        pPohja.add(pHenkilonTiedot);
        pPohja.add(pOsoitteenTiedot);
        pPohja.add(pButtoni);
        
        pHenkilovalinta.add(lbHenkilovalinta);
        pHenkilovalinta.add(cbHenkilo);
        cbHenkilo.setPrototypeDisplayValue("Tähän tulee henkilön nimi");
        
        pHenkilonTiedot.add(lbHenkilonTiedot);
        pHenkilonTiedot.add(taHenkilonTiedot);
        
        pOsoitteenTiedot.add(lbOsoitteenTiedot);
        pOsoitteenTiedot.add(taOsoitteenTiedot);
        
        pButtoni.add(btHae);
        pButtoni.add(btPeruuta);
        
        this.add(pPohja);
    }
    
    public class HaeTiedot implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            
            //taHenkilonTiedot.setText(kanta.henkilonTietojenHaku());
            //henkilonOsoitteenHaku();
        }
        
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
