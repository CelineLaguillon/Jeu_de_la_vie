package modele;

import java.io.Serializable;
import java.util.Random;

/**
 * Classe qui represente un damier d'etats
 * 
 * @author Celine Laguillon et Louis Barraque
 */

@SuppressWarnings("serial")
public class Damier implements Serializable{
	
	/**
	 * Tableau de booleens des cellules "mortes" ou "en vie"
	 */
	private boolean [][]chTab;
	
	/**
	 * Taille du damier
	 */
	private int chTaille ;
	
	/**
	 * Constructeur du damier
	 * 
	 * @param parTaille le nombre d'elements sur un cote du damier
	 */
	public Damier(int parTaille){
		
		chTaille = parTaille;
		chTab = new boolean[parTaille][parTaille];
		
		for (int i = 0; i < chTab.length; i++) {
			for (int j = 0; j < chTab[i].length; j++) {
				chTab[i][j] = false;
			}
		}
	}
	
	/**
	 * Affiche un damier avec un nombre aleatoire d'elements "en vie" (1 chance sur 2)
	 */
	public void aleatoire(){
		Random rand = new Random();
		for (int i = 0 ; i < chTab.length ; i++) {
			for (int j = 0 ; j < chTab[i].length ; j++) {
				if(rand.nextInt(10) % 2 == 1)
					chTab[i][j] = true;
			}
		}	
	}
	
	/**
	 * Compte le nombre d'elements "en vie"
	 * 
	 * @return compteur le nombre d'elements "en vie"
	 */
	public int populationEnVie(){
		int compteur = 0;
		for (int i = 0 ; i < chTab.length ; i++) {
			for (int j = 0 ; j < chTab[i].length ; j++) {
				if(chTab[i][j])
					compteur++;
			}
		}
		return compteur;
	}
	
	/**
	 * Change l'etat des elements lors du passage a la generation suivante, tout en suivant les regles du jeu
	 */
	public void generationSuivante(){
	
		boolean temp[][] = new boolean[chTaille][chTaille];
		
		for (int i = 0 ; i < chTab.length ; i++) {
			for (int j = 0 ; j < chTab[i].length ; j++) {
				boolean a = chTab[i][j];
				temp[i][j] = a;
			}
		}
		
		int compteur = 0;
		
		for(int i = 0 ; i < chTaille ; i++) {
			for(int j = 0 ; j < chTaille ; j++) {
				compteur = 0;
				
				if(i == 0){
					if(j == 0){
						if(chTab[i + 1][j])
							compteur++;
						if(chTab[i][j + 1])
							compteur++;
						if(chTab[i + 1][j + 1])
							compteur++;
					}
					
					else if(j == chTaille - 1){
						if(chTab[i + 1][j])
							compteur++;
						if(chTab[i][j - 1])
							compteur++;
						if(chTab[i + 1][j - 1])
							compteur++;
					}
					
					else{
						if(chTab[i][j - 1])
							compteur++;
						if(chTab[i][j + 1])
							compteur++;
						if(chTab[i + 1][j - 1])
							compteur++;
						if(chTab[i + 1][j])
							compteur++;
						if(chTab[i + 1][j + 1])
							compteur++;
					}					
				}
				
				else if(i == chTaille - 1){
					if(j == 0){
						if(chTab[i - 1][j])
							compteur++;
						if(chTab[i][j + 1])
							compteur++;
						if(chTab[i - 1][j + 1])
							compteur++;
					}
					
					else if(j == chTaille - 1){
						if(chTab[i - 1][j])
							compteur++;
						if(chTab[i][j - 1])
							compteur++;
						if(chTab[i - 1][j - 1])
							compteur++;
					}
					
					else{
						if(chTab[i - 1][j - 1])
							compteur++;
						if(chTab[i - 1][j])
							compteur++;
						if(chTab[i - 1][j + 1])
							compteur++;
						if(chTab[i][j - 1])
							compteur++;
						if(chTab[i][j + 1])
							compteur++;
					}		
				}
				
				else{
					if(j == 0){
						if(chTab[i - 1][j])
							compteur++;
						if(chTab[i - 1][j + 1])
							compteur++;
						if(chTab[i][j + 1])
							compteur++;
						if(chTab[i + 1][j])
							compteur++;
						if(chTab[i + 1][j + 1])
							compteur++;
					}
					
					else if(j == chTaille - 1){
						if(chTab[i - 1][j - 1])
							compteur++;
						if(chTab[i - 1][j])
							compteur++;
						if(chTab[i][j - 1])
							compteur++;
						if(chTab[i + 1][j - 1])
							compteur++;
						if(chTab[i + 1][j])
							compteur++;
					}
					
					else{
						if(chTab[i - 1][j - 1])
							compteur++;
						if(chTab[i - 1][j])
							compteur++;
						if(chTab[i - 1][j + 1])
							compteur++;
						if(chTab[i][j - 1])
							compteur++;
						if(chTab[i][j + 1])
							compteur++;
						if(chTab[i + 1][j - 1])
							compteur++;
						if(chTab[i + 1][j])
							compteur++;
						if(chTab[i + 1][j + 1])
							compteur++;
					}
				}
				
				// Si la cellule est en vie
				if(chTab[i][j]){
					if(compteur < 2 || compteur > 3)
						temp[i][j] = false;
				}
				
				else{
					if(compteur == 3)
						temp[i][j] = true;
				}
			}
		}
		chTab = temp;
	}
	
	/**
	 * Accesseur du tableau double dimension avec l'etat des elements du damier
	 * 
	 * @return chTab le tableau double dimension du damier
	 */
	public boolean[][] getChTab() {
		return chTab;
	}
	
	/**
	 * Modifieur du tableau double dimension avec l'etat des elements du damier
	 * 
	 * @param chTab le tableau double dimension du damier a modifier
	 */
	public void setChTab(boolean[][] parTab) {
		chTab = parTab;
	}

	/**
	 * Accesseur de la taille d'un cote du damier
	 * 
	 * @return chTaille la taille du cote du damier
	 */
	public int getChTaille() {
		return chTaille;
	}
	
	/**
	 * Modifieur de la taille du damier
	 * 
	 * @param chTaille La taille du damier a mettre
	 */
	public void setChTaille(int parTaille) {
		chTaille = parTaille;
	}
	
	/**
	 * Affiche les etats du damier sous la forme d'une chaine de caracteres
	 */
	public String toString(){
		String str = new String();
		for (int i = 0 ; i < chTab.length ; i++) {
			for (int j = 0 ; j < chTab[i].length ; j++) {
				str += chTab[i][j] + "|";
			}
			str += "\n";
		}
		return str;
	}
}