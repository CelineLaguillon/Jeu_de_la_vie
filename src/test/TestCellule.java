package test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import modele.Cellule;
import modele.Damier;
import vue.PanelCentre;

public class TestCellule implements modele.Constantes{
	
	
	
	
	@Test
	public void testAjoutCellule(){
		int taille = 25;
		Damier damier = new Damier(taille);
		
		PanelCentre panelCentre = new PanelCentre(damier);
		Iterator<Cellule> iterateur = panelCentre.getChCollectionCellule().iterator();
		
		int resultat1 = 0;
		
		while (iterateur.hasNext()) {
			iterateur.next();
			resultat1++;
		}
		int resultat2 = taille*taille;
		
		assertTrue(resultat1 == resultat2);
	}
	
	
	@Test
	public void testAfficheDamier() {
		Damier damier = new Damier(25);
		PanelCentre panelCentre = new PanelCentre(damier);
		damier.aleatoire();
		panelCentre.afficheDamier(damier);
		Iterator<Cellule> iterateur = panelCentre.getChCollectionCellule().iterator();
		
		int resultat1 = 0;
		int resultat2;
		
		while (iterateur.hasNext()) {
			Cellule cellule = iterateur.next();
			if(cellule.getBackground().equals(CONSTANTE_CELLULE_EN_VIE))
				resultat1++;System.out.println(resultat1);
		}
		
		resultat2 = damier.populationEnVie();
		assertTrue(resultat1 == resultat2);
	}

}
