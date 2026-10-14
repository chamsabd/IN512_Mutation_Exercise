package boutique;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Suite de tests initiale : 8 tests simples, un par cas "evident" de chaque
 * methode. Ne couvre volontairement pas les valeurs limites.
 */
public class BoutiqueTest {

    private final Boutique boutique = new Boutique();

    @Test
    void prixSansRemise() {
        assertEquals(10.0, boutique.calculerPrix(10.0, 1, 0));
    }

    @Test
    void prixAvecRemiseQuantite() {
        assertEquals(47.5, boutique.calculerPrix(10.0, 5, 0));
    }

    @Test
    void prixAvecRemiseFidelite() {
        assertEquals(9.7, boutique.calculerPrix(10.0, 1, 15));
    }

    @Test
    void fraisDePortGratuitAuDessusDeCinquanteEuros() {
        assertEquals(0.0, boutique.fraisDePort(60.0, 100));
    }

    @Test
    void fraisDePortColisLeger() {
        assertEquals(2.99, boutique.fraisDePort(20.0, 200));
    }

    @Test
    void fraisDePortColisLourd() {
        assertEquals(4.99, boutique.fraisDePort(20.0, 800));
    }

    @Test
    void niveauFideliteBronze() {
        assertEquals("bronze", boutique.niveauFidelite(5));
    }

    @Test
    void pointsFideliteBronze() {
        assertEquals(100, boutique.pointsFidelite(100.0, "bronze"));
    }
}
