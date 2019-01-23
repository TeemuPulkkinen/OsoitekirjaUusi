/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import javax.swing.*;

/**
 *
 * @author s1800591
 */
public class HenkilonLisays extends JFrame {

    private JPanel lbIkkuna = new JPanel();
    private JLabel lbEtunimi = new JLabel("Etunimi");
    private JLabel lbSukunimi = new JLabel("Sukunimi");
    private JLabel lbOsoite = new JLabel("Osoite");
    private JLabel lbSyntymaaika = new JLabel("Syntymäaika");
    private JLabel lbHenkilotunnus = new JLabel("Henkilötunnus");
    private JTextField tfEtunimi = new JTextField();
    private JTextField tfSukunimi = new JTextField();
    private JTextField tfOsoite = new JTextField();
    private JTextField tfSyntymaaika = new JTextField();
    private JTextField tfHenkilotunnus = new JTextField();
    private JButton btLisaa = new JButton();
    private JButton btPeruuta = new JButton();

    public HenkilonLisays() {
        Container paneeli = null;
        
        GroupLayout ikkunaAsettelu = new GroupLayout(paneeli);
        paneeli.setLayout(ikkunaAsettelu);
        
        ikkunaAsettelu.setAutoCreateGaps(true);
        ikkunaAsettelu.setAutoCreateContainerGaps(true);
        
        
    }
}
