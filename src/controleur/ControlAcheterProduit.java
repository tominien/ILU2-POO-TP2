package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isHabitant(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}

	public String[] rechercherVendeursProduit(String produit) {
		Gaulois[] vendeursProduit = village.rechercherVendeursProduit(produit);
		if (vendeursProduit == null) {
			return null;
		}
		
		String[] nomsVendeurs = new String[vendeursProduit.length];
		for (int i = 0; i < vendeursProduit.length; i++) {
			nomsVendeurs[i] = vendeursProduit[i].getNom();
		}

		return nomsVendeurs;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal == null) {
			return -1;
		}
		int quantiteeAchetee = etal.acheterProduit(quantite);
		return quantiteeAchetee;
	}
}
