package test;

import static org.junit.Assert.*;

import org.junit.Test;

import modele.Damier;

public class TestDamier {

	@Test
	public void testPopulationEnVie() {
		Damier damier = new Damier(25);
		damier.aleatoire();
		int resultat1 = 0;
		int resultat2 = 0;
		
		for(int i = 0 ; i < damier.getChTab().length ; i++) {
			for(int j = 0 ; j < damier.getChTab()[1].length ; j++) {
				if(damier.getChTab()[i][j])
					resultat1++;
			}
		}
		
		resultat2 = damier.populationEnVie();
		
		assertTrue(resultat1 == resultat2);
	}
	
	
	@Test
	public void testGenerationSuivante(){
		int taille = 25;
		Damier damier = new Damier(taille);
		damier.aleatoire();
		int resultat1 = damier.populationEnVie();
		
		int compteur = 0;
		int popquivamourir = 0;
		int popquivarevivre = 0;
		for(int i = 0 ; i < taille ; i++) {
			for(int j = 0 ; j < taille; j++) {
				compteur = 0;
				
				if(i == 0){
					if(j == 0){
						if(damier.getChTab()[i + 1][j])
							compteur++;
						if(damier.getChTab()[i][j + 1])
							compteur++;
						if(damier.getChTab()[i + 1][j + 1])
							compteur++;
					}
					
					else if(j == taille - 1){
						if(damier.getChTab()[i + 1][j])
							compteur++;
						if(damier.getChTab()[i][j - 1])
							compteur++;
						if(damier.getChTab()[i + 1][j - 1])
							compteur++;
					}
					
					else{
						if(damier.getChTab()[i][j - 1])
							compteur++;
						if(damier.getChTab()[i][j + 1])
							compteur++;
						if(damier.getChTab()[i + 1][j - 1])
							compteur++;
						if(damier.getChTab()[i + 1][j])
							compteur++;
						if(damier.getChTab()[i + 1][j + 1])
							compteur++;
					}					
				}
				
				else if(i == taille - 1){
					if(j == 0){
						if(damier.getChTab()[i - 1][j])
							compteur++;
						if(damier.getChTab()[i][j + 1])
							compteur++;
						if(damier.getChTab()[i - 1][j + 1])
							compteur++;
					}
					
					else if(j == taille - 1){
						if(damier.getChTab()[i - 1][j])
							compteur++;
						if(damier.getChTab()[i][j - 1])
							compteur++;
						if(damier.getChTab()[i - 1][j - 1])
							compteur++;
					}
					
					else{
						if(damier.getChTab()[i - 1][j - 1])
							compteur++;
						if(damier.getChTab()[i - 1][j])
							compteur++;
						if(damier.getChTab()[i - 1][j + 1])
							compteur++;
						if(damier.getChTab()[i][j - 1])
							compteur++;
						if(damier.getChTab()[i][j + 1])
							compteur++;
					}		
				}
				
				else{
					if(j == 0){
						if(damier.getChTab()[i - 1][j])
							compteur++;
						if(damier.getChTab()[i - 1][j + 1])
							compteur++;
						if(damier.getChTab()[i][j + 1])
							compteur++;
						if(damier.getChTab()[i + 1][j])
							compteur++;
						if(damier.getChTab()[i + 1][j + 1])
							compteur++;
					}
					
					else if(j == 25 - 1){
						if(damier.getChTab()[i - 1][j - 1])
							compteur++;
						if(damier.getChTab()[i - 1][j])
							compteur++;
						if(damier.getChTab()[i][j - 1])
							compteur++;
						if(damier.getChTab()[i + 1][j - 1])
							compteur++;
						if(damier.getChTab()[i + 1][j])
							compteur++;
					}
					
					else{
						if(damier.getChTab()[i - 1][j - 1])
							compteur++;
						if(damier.getChTab()[i - 1][j])
							compteur++;
						if(damier.getChTab()[i - 1][j + 1])
							compteur++;
						if(damier.getChTab()[i][j - 1])
							compteur++;
						if(damier.getChTab()[i][j + 1])
							compteur++;
						if(damier.getChTab()[i + 1][j - 1])
							compteur++;
						if(damier.getChTab()[i + 1][j])
							compteur++;
						if(damier.getChTab()[i + 1][j + 1])
							compteur++;
					}
				}
				
				// Si la cellule est en vie
				if(damier.getChTab()[i][j]){
					if(compteur < 2 || compteur > 3)
						popquivamourir++;
				}
				
				else{
					if(compteur == 3)
						popquivarevivre++;
				}
			}
		}
		resultat1 = resultat1 + popquivarevivre - popquivamourir;
		damier.generationSuivante();
		assertTrue(resultat1 == damier.populationEnVie());
	}
}
