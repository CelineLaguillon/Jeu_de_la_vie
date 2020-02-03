package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;

/**
 * Classe de l'element graphique qui place les boutons en bas du PanelFils
 * 
 * @author Celine Laguillon et Louis Barraque
 */

@SuppressWarnings("serial")
public class PanelSud extends JPanel implements modele.Constantes{

	/**
	 * Tableau de boutons
	 */
	private JButton []chBouton = new JButton[NOM_BOUTTONS_SUD.length];
	
	/**
	 * Label pour l'enregistrement
	 */
	private JLabel chLabel = new JLabel(NOM_LABELS_SUD);
	
	/**
	 * Zone de texte qui permet à l'utilisateur d'entrer un nom pour le fichier qu'il enregistre
	 */
	private JTextField chTexte = new JTextField(LONGUEUR_JTEXTFIELD_SUD);
	
	/**
	 * Constucteur du PanelSud
	 */
	public PanelSud(){
		setLayout(new GridBagLayout());
		
		GridBagConstraints contrainte = new GridBagConstraints();
		contrainte.insets = new Insets(10, 20, 10, 10);
		
		for (int i = 0 ; i < chBouton.length ; i++) {
			chBouton[i] = new JButton(NOM_BOUTTONS_SUD[i]);
			chBouton[i].setActionCommand(NOM_BOUTTONS_SUD[i]);
			
			if(i < 3) {
				contrainte.gridx = i;
				contrainte.gridy = 0;
				this.add(chBouton[i], contrainte);
			}
			
			else if(i == 3) {
				contrainte.gridx = 5;
				contrainte.gridy = 1;
				chBouton[3].setActionCommand(NOM_BOUTTONS_SUD[3]);
				this.add(chBouton[3], contrainte);
			}
		}
		
		contrainte.gridx = 4;
		contrainte.gridy = 0;
		this.add(chLabel, contrainte);
		
		contrainte.insets = new Insets(10, 3, 10, 10);
		contrainte.gridx = 5;
		contrainte.gridy = 0;
		this.add(chTexte, contrainte);
		
	}
	
	/**
	 * Met les boutons du PanelSud a l'ecoute
	 * 
	 * @param parControleur le controleur
	 */
	public void enregistreEcouteur(Controleur parControleur){
		for (int i = 0 ; i < chBouton.length ; i++) {
			chBouton[i].addActionListener(parControleur);
		}
	}
	
	/**
	 * Accesseur du tableau de boutons
	 * 
	 * @return chBouton le tableau de boutons
	 */
	public JButton[] getChBouton() {
		return chBouton;
	}
	
	/**
	 * Modifieur du tableau de boutons
	 * 
	 * @param chBouton le tableau de bouton a modifier
	 */
	public void setChBouton(JButton[] parBouton) {
		chBouton = parBouton;
	}
	
	/**
	 * Accesseur du label
	 * 
	 * @return chLabel le label d'enregistrement
	 */
	public JLabel getChLabel() {
		return chLabel;
	}
	
	/**
	 * Modifieur du label
	 * 
	 * @param chLabel le label a modifier
	 */
	public void setChLabel(JLabel parLabel) {
		chLabel = parLabel;
	}
	
	/**
	 * Accesseur de la zone de saisi du nom du fichier
	 * 
	 * @return chTexte la zone de saisi du nom du fichier
	 */
	public JTextField getChTexte() {
		return chTexte;
	}
	
	/**
	 * Modifieur de la zone de saisi du nom du fichier
	 * 
	 * @param chTexte la zone de texte a mettre
	 */
	public void setChTexte(JTextField parTexte) {
		chTexte = parTexte;
	}
}