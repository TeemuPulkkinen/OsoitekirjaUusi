package kayttoliittyma;

import data.Henkilot;
import data.Osoitteet;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sql.Tietokanta;

/**
 *
 * @author s1800591
 */
public class OsoitteenMuutos extends JFrame {

    Tietokanta kanta = new Tietokanta();

    private JPanel pPohja = new JPanel(new GridLayout(3, 1));
    private JPanel pHenkilovalinta = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private JPanel pOsoitteenvalinta = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JPanel pButtoni = new JPanel(new FlowLayout(FlowLayout.LEFT));

    private JLabel lbHenkilovalinta = new JLabel("Valitse henkilö:");
    private JLabel lbOsoitteenvalinta = new JLabel("Valitse osoite:");

    private JComboBox cbHenkilo = new JComboBox();
    private JComboBox cbOsoite = new JComboBox();

    private JButton btTallenna = new JButton("Tallenna");
    private JButton btPeruuta = new JButton("Peruuta");
    
    // muuttujat listoille
    ArrayList<Osoitteet> osoitelista = new ArrayList<>();
    ArrayList<Henkilot> henkilolista = new ArrayList<>();
    
    public OsoitteenMuutos() {

        this.setTitle("Muuta osoite");
        this.setSize(450, 250);
        this.setLocation(200, 100);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        asetteleKomponentit();
        //alle listamuuttujien tiedot
        henkilolista = kanta.haeHenkilotListaan();
        osoitelista = kanta.haeOsoitteetListaan();
        
        cbHenkilo.setModel(new DefaultComboBoxModel(henkilolista.toArray()));
        cbOsoite.setModel(new DefaultComboBoxModel(osoitelista.toArray()));

        btTallenna.addActionListener(new TallennaTiedot());
        btPeruuta.addActionListener(new Peruuta());
    }

    private void asetteleKomponentit() {

        pPohja.add(pHenkilovalinta);
        pPohja.add(pOsoitteenvalinta);
        pPohja.add(pButtoni);

        pHenkilovalinta.add(lbHenkilovalinta);
        pHenkilovalinta.add(cbHenkilo);

        cbHenkilo.setPrototypeDisplayValue("Tähän tulee henkilön nimi");

        pOsoitteenvalinta.add(lbOsoitteenvalinta);
        pOsoitteenvalinta.add(cbOsoite);

        cbOsoite.setPrototypeDisplayValue("Tähän tulee osoitteen nimi ja muut tiedot");

        pButtoni.add(btTallenna);
        pButtoni.add(btPeruuta);

        this.add(pPohja);

    }

    private class TallennaTiedot implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            yhdistaHenkilo();
        }

    }
    
    private void yhdistaHenkilo() {
        
        Henkilot henkilonID = henkilolista.get(cbHenkilo.getSelectedIndex());
        Osoitteet osoite = osoitelista.get(cbOsoite.getSelectedIndex());
        
        kanta.yhdistaHenkiloJaOsoite(osoite, henkilonID);
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
