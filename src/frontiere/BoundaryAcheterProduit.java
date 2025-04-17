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
			System.out.println("Je suis désolée " + nomGaulois
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		}
		return isHabitant;
	}

	public void acheterProduit(String nomAcheteur) {
		if (verifierHabitant(nomAcheteur)) {
			String produit = Clavier.entrerChaine("Quel produit souhaitez-vous acheter ?\n");
			Gaulois[] vendeursProduit = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeursProduit != null) {
				int choixUtilisateur;
				do {
					StringBuilder question = new StringBuilder();
					question.append("De quel commerçant voulez-vous acheter des " + produit + " ?\n");
					for (int i = 0; i < vendeursProduit.length; i++) {
						question.append((i + 1) + " - " + vendeursProduit[i].getNom() + "\n");
					}
					choixUtilisateur = Clavier.entrerEntier(question.toString());
				} while (0 >= choixUtilisateur || choixUtilisateur > vendeursProduit.length);
				choixUtilisateur--;
				String nomVendeur = vendeursProduit[choixUtilisateur].getNom();
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur + ".");
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAchetee = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
				if (quantiteAchetee == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
							+ ", malheureusement il n'y en a plus !");
				} else if (quantiteAchetee == quantite) {
					System.out.println(nomAcheteur + " achète " + quantiteAchetee + " " + produit + " à " + nomVendeur);
				} else {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit
							+ ", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee + ".\n"
							+ nomAcheteur + " achète tout le stock de " + nomVendeur + ".");
				}
			} else {
				System.out.println("Désolé, personne ne vend de ce produit au marché.");
			}
		}
	}
}
