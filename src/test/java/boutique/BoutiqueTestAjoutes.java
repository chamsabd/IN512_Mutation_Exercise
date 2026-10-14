package boutique;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Tests ajoutes a l'issue de l'analyse de mutation : chaque test cible un
 * mutant survivant identifie dans target/pit-reports (valeurs exactement sur
 * une frontiere, plus leur voisin immediatement en dehors de la plage).
 */
public class BoutiqueTestAjoutes {

    private final Boutique boutique = new Boutique();

    // --- calculerPrix : frontiere quantite >= 10 (mutant ligne 18) ---

    @Test
    void remiseDixPourcentExactementAQuantiteDix() {
        assertEquals(90.0, boutique.calculerPrix(10.0, 10, 0));
    }

    @Test
    void remiseCinqPourcentJusteAvantQuantiteDix() {
        assertEquals(85.5, boutique.calculerPrix(10.0, 9, 0));
    }

    // --- calculerPrix : frontiere quantite >= 3 (mutant ligne 20) ---

    @Test
    void remiseCinqPourcentExactementAQuantiteTrois() {
        assertEquals(28.5, boutique.calculerPrix(10.0, 3, 0));
    }

    @Test
    void aucuneRemiseJusteAvantQuantiteTrois() {
        assertEquals(20.0, boutique.calculerPrix(10.0, 2, 0));
    }

    // --- calculerPrix : frontiere moisFidelite >= 24 (mutant ligne 25) ---

    @Test
    void remiseSeptPourcentExactementAVingtQuatreMois() {
        assertEquals(9.3, boutique.calculerPrix(10.0, 1, 24));
    }

    @Test
    void remiseTroisPourcentJusteAvantVingtQuatreMois() {
        assertEquals(9.7, boutique.calculerPrix(10.0, 1, 23));
    }

    // --- calculerPrix : frontiere moisFidelite >= 12 (mutant ligne 27) ---

    @Test
    void remiseTroisPourcentExactementADouzeMois() {
        assertEquals(9.7, boutique.calculerPrix(10.0, 1, 12));
    }

    @Test
    void aucuneRemiseFideliteJusteAvantDouzeMois() {
        assertEquals(10.0, boutique.calculerPrix(10.0, 1, 11));
    }

    // --- fraisDePort : frontiere totalCommande >= 50.0 (mutant ligne 42) ---

    @Test
    void portGratuitExactementACinquanteEuros() {
        assertEquals(0.0, boutique.fraisDePort(50.0, 100));
    }

    @Test
    void portPayantJusteAvantCinquanteEuros() {
        assertEquals(2.99, boutique.fraisDePort(49.99, 100));
    }

    // --- fraisDePort : frontiere poidsGrammes < 500 (mutant ligne 45) ---

    @Test
    void portLourdExactementACinqCentsGrammes() {
        assertEquals(4.99, boutique.fraisDePort(20.0, 500));
    }

    @Test
    void portLegerJusteAvantCinqCentsGrammes() {
        assertEquals(2.99, boutique.fraisDePort(20.0, 499));
    }

    // --- niveauFidelite : frontieres >= 24 et >= 12 (mutants lignes 55, 57) ---

    @Test
    void niveauOrExactementAVingtQuatreMois() {
        assertEquals("or", boutique.niveauFidelite(24));
    }

    @Test
    void niveauArgentExactementADouzeMois() {
        assertEquals("argent", boutique.niveauFidelite(12));
    }

    // --- pointsFidelite : bonus argent/or (mutant MATH ligne 75, et branches non couvertes) ---

    @Test
    void pointsFideliteAvecBonusArgent() {
        assertEquals(150, boutique.pointsFidelite(100.0, "argent"));
    }

    @Test
    void pointsFideliteAvecBonusOr() {
        assertEquals(200, boutique.pointsFidelite(100.0, "or"));
    }
}
