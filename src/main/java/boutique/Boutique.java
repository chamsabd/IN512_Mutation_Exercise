package boutique;

/**
 * Calculateur de prix pour une boutique en ligne.
 */
public class Boutique {

    /**
     * Calcule le prix total d'une commande, remises quantite et fidelite appliquees.
     *
     * Remise quantite : -5% a partir de 3 articles, -10% a partir de 10 articles.
     * Remise fidelite : -3% a partir de 12 mois d'anciennete, -7% a partir de 24 mois.
     */
    public double calculerPrix(double prixUnitaire, int quantite, int moisFidelite) {
        double total = prixUnitaire * quantite;

        double remiseQuantite = 0.0;
        if (quantite >= 10) {
            remiseQuantite = 0.10;
        } else if (quantite >= 3) {
            remiseQuantite = 0.05;
        }

        double remiseFidelite = 0.0;
        if (moisFidelite >= 24) {
            remiseFidelite = 0.07;
        } else if (moisFidelite >= 12) {
            remiseFidelite = 0.03;
        }

        total = total * (1 - remiseQuantite) * (1 - remiseFidelite);
        return Math.round(total * 100.0) / 100.0;
    }

    /**
     * Calcule les frais de port.
     *
     * Gratuits a partir de 50 euros de commande. En dessous, 2.99 euros si le
     * colis pese moins de 500g, 4.99 euros sinon.
     */
    public double fraisDePort(double totalCommande, int poidsGrammes) {
        if (totalCommande >= 50.0) {
            return 0.0;
        }
        if (poidsGrammes < 500) {
            return 2.99;
        }
        return 4.99;
    }

    /**
     * Determine le niveau de fidelite d'un client a partir de son anciennete en mois.
     */
    public String niveauFidelite(int moisAnciennete) {
        if (moisAnciennete >= 24) {
            return "or";
        } else if (moisAnciennete >= 12) {
            return "argent";
        } else {
            return "bronze";
        }
    }

    /**
     * Calcule les points de fidelite gagnes pour un montant depense, avec un
     * bonus x2 pour le niveau or et x1.5 pour le niveau argent.
     */
    public int pointsFidelite(double montant, String niveau) {
        double bonus = 1.0;
        if ("or".equals(niveau)) {
            bonus = 2.0;
        } else if ("argent".equals(niveau)) {
            bonus = 1.5;
        }
        return (int) Math.floor(montant * bonus);
    }
}
