package vue;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Constantes;

/**
 * Classe De l'element graphique place en haut du PanelFils qui affiche diverses informations sur le damier actuel 
 * 
 * @author Celine Laguillon et Lous Barraque
 */

@SuppressWarnings("serial")
public class PanelNord extends JPanel implements Constantes{
	
	/**
	 * Tableau de labels pour afficher les diverses informations
	 */
	private JLabel []chLabel;
	
	/**
	 * Constructeur du PanelNord
	 */
	public PanelNord(){
		setLayout(new FlowLayout(FlowLayout.CENTER, 60, 10));
		
		chLabel = new JLabel[NOM_LABELS_NORD.length];
		
		for (int i = 0; i < NOM_LABELS_NORD.length ; i++) {
			chLabel[i] = new JLabel(Constantes.NOM_LABELS_NORD[i]+ " " + 0);
			this.add(chLabel[i]);
		}
	}
	
	/**
	 * Accesseur du tableau de labels
	 * 
	 * @return chLabel le tableau de labels
	 */
	public JLabel[] getChLabel() {
		return chLabel;
	}
	
	/**
	 * Accesseur du tableau du labels
	 * 
	 * @param parInt l'indice de l'element recherche
	 * @return chLabel[parInt] l'element recherche
	 */
	public JLabel getChLabel(int parInt) {
		return chLabel[parInt];
	}
	
	/**
	 * Modifieur du tableau du labels
	 * 
	 * @param chLabel le tableau de label a modifier
	 */
	public void setChLabel(JLabel[] parLabel) {
		chLabel = parLabel;
	}
}