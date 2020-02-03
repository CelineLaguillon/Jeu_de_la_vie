package vue;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controleur.Controleur;

import modele.Cellule;
import modele.Damier;

/**
 * Classe de l'element graphique place au centre du PanelFils qui affiche le damier 
 * 
 * @author Celine Laguillon et Louis Barraque
 */

@SuppressWarnings("serial")
public class PanelCentre extends JPanel implements modele.Constantes{
	
	/**
	 * Collection qui contient toute les cellules du diamier
	 */
	private ArrayList <Cellule> chCollectionCellule;
	
	/**
	 * Plateau de jeu
	 */
	private Damier chDamier;
	
	/**
	 * Constructeur du PanelCentre
	 * 
	 * @param parDamier le damier a afficher dans un premier temps
	 */
	public PanelCentre(Damier parDamier){
		chDamier = parDamier;
		chDamier = new Damier(25);
		afficheDamier(chDamier);
	}
	
	/**
	 * Affiche le damier a l'ecran
	 * 
	 * @param parDamier le damier a afficher
	 */
	public void afficheDamier(Damier parDamier){
		chDamier = parDamier;
		removeAll();
		
		setLayout(new GridLayout(chDamier.getChTaille(), chDamier.getChTaille()));
		
		boolean [][]rep = chDamier.getChTab();
		chCollectionCellule = new ArrayList<Cellule>();
		
		for (int i = 0 ; i < rep.length ; i++) {
			for (int j = 0 ; j < rep[i].length ; j++) {
				Cellule cel = new Cellule(rep[i][j],i,j);
				chCollectionCellule.add(cel);
				if( !(rep[i][j]) )
					cel.setBackground(CONSTANTE_CELLULE_MORTE);
				else
					cel.setBackground(CONSTANTE_CELLULE_EN_VIE);
				this.add(cel);
				}
			}
		
		revalidate();
		repaint();
	}
	
	/**
	 * Met toutes les cellules a l'ecoute
	 * 
	 * @param parControleur le controleur qui se met a l'ecoute des cellules
	 */
	public void enregistreEcouteur(Controleur parControleur) {
		for (Cellule indiceCel : chCollectionCellule) {
			indiceCel.addActionListener(parControleur);
		}
	}
	
	/**
	 * Accesseur de la collection de cellules
	 * 
	 * @return chCollectionCellule la collection de cellules
	 */
	public ArrayList<Cellule> getChCollectionCellule() {
		return chCollectionCellule;
	}
	
	/**
	 * Modifieur de la collection de cellule
	 * 
	 * @param chCollectionCellule la collection de cellules a modifier
	 */
	public void setChCollectionCellule(ArrayList<Cellule> parCollectionCellule) {
		chCollectionCellule = parCollectionCellule;
	}
	
	/**
	 * Accesseur du damier
	 * 
	 * @return chDamier le damier
	 */
	public Damier getChDamier() {
		return chDamier;
	}
	
	/**
	 * Modifieur du damier
	 * 
	 * @param parDamier le nouveau damier a modifier
	 */
	public void setChDamier(Damier parDamier) {
		chDamier = parDamier;
	}
}