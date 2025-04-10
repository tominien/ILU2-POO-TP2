package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			boolean etalOccupe = Boolean.parseBoolean(donneesEtal[0]);
			if (etalOccupe) {
				String produit = donneesEtal[2];
				String quantiteInitiale = donneesEtal[3];
				String quantiteVendu = donneesEtal[4];
				System.out.println("Vous avez vendu " + quantiteVendu + " sur " + quantiteInitiale + " " + produit + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée.");
			}
		}
	}

}
