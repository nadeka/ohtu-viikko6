
package ohtu;

import javax.swing.JTextField;

public class Nollaa implements Komento {
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinen;

    public Nollaa(Sovelluslogiikka sovellus,
            JTextField tuloskentta,
            JTextField syotekentta) {
        
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.edellinen = 0;
    }

    @Override
    public void suorita() {
        this.edellinen = sovellus.tulos();
        sovellus.nollaa();
        tuloskentta.setText(String.valueOf(sovellus.tulos()));
    }

    @Override
    public void peru() {
        sovellus.setTulos(edellinen);
        tuloskentta.setText(String.valueOf(sovellus.tulos()));       
    }
}
