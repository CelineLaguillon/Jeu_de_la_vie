package vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import controleur.Controleur;

import modele.Damier;

/**
 * Classe qui contient tous les elements graphiques de la FenetreMere
 * 
 * @author Celine Laguillon et Louis Barraque
 *
 */

@SuppressWarnings("serial")
public class PanelFils extends JPanel implements modele.Constantes{
	
	/**
	 * Panel affiche au centre de la fenetre
	 */
	private PanelCentre chPanelCentre;
	
	/**
	 * Panel affiche en haut de la fenetre
	 */
	private PanelNord chPanelNord;
	
	/**
	 * Panel affiche en bas de la fenetre
	 */
	private PanelSud chPanelSud;
	
	/**
	 * Constructeur du PanelFils
	 * 
	 * @param parControleur Controleur qui se met a l'ecoute des differents elements
	 */
	public PanelFils(Controleur parControleur){
		setLayout(new BorderLayout());
		Damier damierTemp = new Damier(25);
		
		chPanelCentre = new PanelCentre(damierTemp);
		chPanelNord = new PanelNord();
		chPanelSud = new PanelSud();
		
		parControleur.setChPanelCentre(chPanelCentre);
		parControleur.setChPanelNord(chPanelNord);
		parControleur.setChpanelSud(chPanelSud);
		
		chPanelSud.enregistreEcouteur(parControleur);
		chPanelCentre.enregistreEcouteur(parControleur);
		
		add(chPanelNord,BorderLayout.NORTH);
		add(chPanelCentre,BorderLayout.CENTER);
		add(chPanelSud,BorderLayout.SOUTH);
	}
	
	/**
	 * Accesseur du PanelCentre
	 * 
	 * @return chPanelCentre le PanelCentre
	 */
	public PanelCentre getChPanelCentre() {
		return chPanelCentre;
	}
	
	/**
	 * Modifieur du PanelCentre
	 * 
	 * @param chPanelCentre le panel a modifier
	 */
	public void setChPanelCentre(PanelCentre parPanelCentre) {
		chPanelCentre = parPanelCentre;
	}
	
	/**
	 * Accesseur du PanelNord
	 * 
	 * @return chPanelNord le PanelNord
	 */
	public PanelNord getChPanelNord() {
		return chPanelNord;
	}
	
	/**
	 * Modifieur du PanelNord
	 * 
	 * @param chPanelNord le panel a modifier
	 */
	public void setChPanelNord(PanelNord parPanelNord) {
		chPanelNord = parPanelNord;
	}
	
	/**
	 * Accesseur du PanelSud
	 * 
	 * @return chPanelSud le PanelSud
	 */
	public PanelSud getChPanelSud() {
		return chPanelSud;
	}

	/**
	 * Modifieur du PanelSud
	 * 
	 * @param chPanelSud le panel a modifier
	 */
	public void setChPanelSud(PanelSud parPanelSud) {
		chPanelSud = parPanelSud;
	}
}