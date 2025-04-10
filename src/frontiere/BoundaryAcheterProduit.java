package frontiere;

import personnages.Gaulois;
import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public boolean verifierHabitant(String nomGaulois) {
		boolean isHabitant = controlAcheterProduit.isHabitant(nomGaulois);
		if (!isHabitant) {
			System.out.println("Je suis désolée " + nomGaulois + " mais il faut être un habitant de notre village pour commercer ici.");
		}
		return isHabitant;
	}

	public void acheterProduit(String nomAcheteur) {
		if (verifierHabitant(nomAcheteur)) {
			String produit = Clavier.entrerChaine("quel produit souhaitez-vous acheter ?\n");
			Gaulois[] vendeursProduit = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeursProduit != null) {
				for (int i = 0; i < vendeursProduit.length; i++) {
					System.out.println((i + 1) + " - " + vendeursProduit[i].getNom());
				}
				// Demander de quel commerçant on veut acheter le produit et boucler tant qu'on n'a pas un commerçant valide.
			} else {
				System.out.println("Désolé, personne ne vend de ce produit au marché.");
			}
		}
	}
}
