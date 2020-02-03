package modele;

import javax.swing.JButton;

/**
 * Classe qui represente graphiquement une case du damier
 * 
 * @author Celine Laguillon et Louis Barraque
 *
 */

@SuppressWarnings("serial")
public class Cellule extends JButton{
	
	/**
	 * Etat de la cellule, true si elle est "en vie" et false si elle est "morte"
	 */
	private boolean chEtat; 
	
	/**
	 * Position de la cellule sur l'axe des abscisses
	 */
	private int chLargeur;
	
	/**
	 * Position de la cellule sur l'axe des ordonnees
	 */
	private int chHauteur;
	
	/**
	 * Constructeur d'une cellule
	 * 
	 * @param parEtat l'etat de la cellule
	 * @param parLargeur la position de la cellule sur l'axe des abscisses
	 * @param parHauteur la position de la cellule sur l'axe des abscisses
	 */
	public Cellule(boolean parEtat,int parLargeur,int parHauteur){
		chEtat = parEtat;
		chLargeur = parLargeur;
		chHauteur = parHauteur;
	}
	
	/**
	 * Accesseur de l'etat d'une cellule
	 * 
	 * @return chEtat l'etat de la cellule
	 */
	public boolean getChEtat() {
		return chEtat;
	}
	
	/**
	 * Modifieur de l'etat de la cellule
	 * 
	 * @param chEtat l'etat de cellule a modifier
	 */
	public void setChEtat(boolean parEtat) {
		chEtat = parEtat;
	}
	
	/**
	 * Accesseur de la position de la cellule sur l'axe des abscisses
	 * 
	 * @return chLargeur la postion de la cellule sur l'axe des abscisses
	 */
	public int getChLargeur() {
		return chLargeur;
	}
	
	/**
	 * Modifieur de la position de la cellule sur l'axe des abscisses
	 * 
	 * @param chLargeur la postion de la cellule sur l'axe des abscisses a modifier
	 */
	public void setChLargeur(int parLargeur) {
		chLargeur = parLargeur;
	}
	
	/**
	 * Accesseur de la position de la cellule sur l'axe des ordonnees
	 *  
	 * @return chHauteur la position de la cellule sur l'axe des ordonnees
	 */
	public int getChHauteur() {
		return chHauteur;
	}
	
	/**
	 * Modifieur de la position de la cellule sur l'axe des ordonnees
	 * 
	 * @param chHauteur la position de la cellule sur l'axe des ordonnees a modifier
	 */
	public void setChHauteur(int parHauteur) {
		chHauteur = parHauteur;
	}
}