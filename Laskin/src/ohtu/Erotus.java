
package ohtu;

import javax.swing.JTextField;

public class Erotus implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Erotus(Sovelluslogiikka sovellus,
            JTextField tuloskentta,
            JTextField syotekentta) {
        
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        int luku = Integer.parseInt(syotekentta.getText());
        sovellus.miinus(luku);
        edellinen = luku;
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

    @Override
    public void peru() {
        sovellus.plus(edellinen);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }
   
}
