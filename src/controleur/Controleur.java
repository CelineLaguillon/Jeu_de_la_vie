package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import modele.Cellule;
import modele.Damier;
import modele.LectureEcriture;
import vue.FenetreMere;
import vue.PanelCentre;
import vue.PanelNord;
import vue.PanelSud;

/**
 * Classe qui execute toutes les actions lors d'une interaction avec l'utilisateur
 * 
 * @author Celine Laguillon et Louis Barraque
 *
 */

public class Controleur implements ActionListener,modele.Constantes{
	
	/**
	 * FenetreMere retenu par le controleur
	 */
	private FenetreMere chFenetreMere;
	
	/**
	 * PanelCentre retenu par le controleur
	 */
	private PanelCentre chPanelCentre;
	
	/**
	 * PanelNord retenu par le controleur
	 */
	private PanelNord chPanelNord;
	
	/**
	 * PanelSud retenu par le controleur
	 */
	private PanelSud chPanelSud;
	
	/**
	 * Entier correspondant au numero de la generation d'un damier
	 */
	private int chGeneration = 0;
	
	/**
	 * Timer pour l'avance rapide
	 */
	private Timer chTimer;
	
	/**
	 * Contructeur d'un controleur
	 * 
	 * @param parFenetreMere la fenetre qu'il doit retenir
	 */
	public Controleur(FenetreMere parFenetreMere){
		chFenetreMere = parFenetreMere;
		chFenetreMere.ajoutItem(this);
		
		chTimer = new Timer(300, this);
		chTimer.setActionCommand(NOM_TIMER);
	}
	
	/**
	 * Affiche la population en vie sur le damier
	 * 
	 * @param parDamier le damier compose par les cellules
	 */
	public void affichePopulation(Damier parDamier){
		chPanelNord.getChLabel(1).setText(NOM_LABELS_NORD[1] + " " + parDamier.populationEnVie());
	}
	/**
	 * Affiche le numero de la generation en cours
	 */
	public void afficheGeneration(){
		chPanelNord.getChLabel(0).setText(NOM_LABELS_NORD[0] + " " + ++chGeneration);
	}

	/**
	 * Actions a executer lors d'une interaction avec l'utilisateur
	 */
	public void actionPerformed(ActionEvent parEvenement) {
		
		if(parEvenement.getActionCommand().equals(NOM_BOUTTONS_SUD[0])){
			Damier damierTemp = chPanelCentre.getChDamier();
			damierTemp.generationSuivante();
			
			chPanelCentre.afficheDamier(damierTemp);
			chPanelCentre.enregistreEcouteur(this);
			
			affichePopulation(damierTemp);
			afficheGeneration();
		}
		
		else if(parEvenement.getSource() instanceof Cellule){
			Cellule cellule =(Cellule)parEvenement.getSource();
			Damier damierRecup = chPanelCentre.getChDamier();
			boolean [][]recup = damierRecup.getChTab();
			boolean etat = recup[cellule.getChLargeur()][cellule.getChHauteur()];
			
			if(cellule.getBackground().equals(CONSTANTE_CELLULE_EN_VIE))
				cellule.setBackground(CONSTANTE_CELLULE_MORTE);
			else
				cellule.setBackground(CONSTANTE_CELLULE_EN_VIE);
			
			recup[cellule.getChLargeur()][cellule.getChHauteur()] = !(etat);
			affichePopulation(damierRecup);
		}
		
		else if(parEvenement.getActionCommand().equals(NOM_BOUTTONS_SUD[3])){
			if(!chPanelSud.getChTexte().getText().equals(new String())){
				int compteur = 0;
				File repertoire = new File("exemples");
				String chIntitulesFichiers[] = repertoire.list();
				
				File fichier = new File(chPanelSud.getChTexte().getText() + ".ser");
				
				for (int i = 0 ; i < chIntitulesFichiers.length ; i++){
					if(chIntitulesFichiers[i].equals(fichier.toString())) {
						compteur++;
					}
				}
				
				if(compteur == 0){
					int input = JOptionPane.showConfirmDialog(chPanelCentre, "Enregistrer le damier sous le nom de \"" + chPanelSud.getChTexte().getText()+"\"","Voulez-vous vraiment enregistrer ce fichier ?",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
					
					if(input == 0) {
						fichier = new File("exemples" + File.separator + chPanelSud.getChTexte().getText() + ".ser");
							
						LectureEcriture.ecriture(fichier, chPanelCentre.getChDamier());
						
						String nomFichier = chPanelSud.getChTexte().getText()+".ser";
						
						JMenuItem item = new JMenuItem(nomFichier, nomFichier.charAt(0));
						chFenetreMere.getchMenus(1).add(item);
						item.setAccelerator(KeyStroke.getKeyStroke(nomFichier.charAt(0), java.awt.Event.CTRL_MASK));
						item.addActionListener(this);
						chPanelSud.getChTexte().setText(new String());
					}
				}
				
				else{
					JOptionPane.showMessageDialog(chPanelCentre, "Ce nom de fichier est d�j� pris. Veuillez donner un autre nom.");
					chPanelSud.getChTexte().setText(new String());
				}
			}

			else{
				JOptionPane.showMessageDialog(chPanelCentre, "Veuillez entrer un nom de fichier valable.");
			}
		}
		
		else if(parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [0] + "a") || parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [1] + "a") ||parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [2] + "a")){
			int a = 45;
			if(parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [0] + "a"))
					a = 25;
			else if(parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [1] + "a"))
					a = 35;
			
			Damier damierTemp = new Damier(a);
			damierTemp.aleatoire();
			chPanelCentre.afficheDamier(damierTemp);
			chPanelCentre.enregistreEcouteur(this);
			
			affichePopulation(damierTemp);
			chGeneration = -1;
			afficheGeneration();
		}
		else if(parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [0] + "v") || parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [1] + "v") ||parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [2] + "v")){
			int a = 45;
			if(parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [0] + "v"))
					a = 25;
			else if(parEvenement.getActionCommand().equals(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [1] + "v"))
					a = 35;
			
			Damier damierTemp = new Damier(a);
			chPanelCentre.afficheDamier(damierTemp);
			chPanelCentre.enregistreEcouteur(this);
			
			affichePopulation(damierTemp);
			chGeneration = -1;
			afficheGeneration();
		}
		
		else if (parEvenement.getActionCommand().equals(NOM_TIMER)){
			Damier damierTemp = chPanelCentre.getChDamier();
			damierTemp.generationSuivante();
			
			chPanelCentre.afficheDamier(damierTemp);
			chPanelCentre.enregistreEcouteur(this);
			
			affichePopulation(damierTemp);
			afficheGeneration();
		}
		
		else if(parEvenement.getActionCommand().equals(NOM_BOUTTONS_SUD[1])){
			chTimer.start();
		}
		
		else if(parEvenement.getActionCommand().equals(NOM_BOUTTONS_SUD[2])){
			chTimer.stop();
		}
		
		else if(parEvenement.getActionCommand().equals(NOM_ITEM_MENU[3])) {
			int saisi = JOptionPane.showConfirmDialog(chFenetreMere, "etes-vous sur de votre choix ?", "Dialogue de confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if(saisi == JOptionPane.OK_OPTION) {
				System.exit(1);
			}
		}
		
		else{
			JMenuItem item = (JMenuItem) parEvenement.getSource();
			
			File fichier = new File("exemples" + File.separator + item.getText());
			
			Damier damierTemp = (Damier) LectureEcriture.lecture(fichier);
			chPanelCentre.afficheDamier(damierTemp);
			chPanelCentre.enregistreEcouteur(this);
			
			affichePopulation(damierTemp);
			chGeneration = -1;
			afficheGeneration();
		}
	}

	/**
	 * Accesseur de la FenetreMere
	 * 
	 * @return chFenetreMere la FenetreMere
	 */
	public FenetreMere getChFenetreMere() {
		return chFenetreMere;
	}

	/**
	 * Modifieur de la FenetreMere
	 * @param chFenetreMere la fenetre a modifier
	 */
	public void setChFenetreMere(FenetreMere parFenetreMere) {
		chFenetreMere = parFenetreMere;
	}

	/**
	 * Accesseur du PanelCentre
	 * @return le PanelCentre
	 */
	public PanelCentre getChPanelCentre() {
		return chPanelCentre;
	}

	/**
	 * Modifieur du PanelCentre
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
	public PanelSud getChpanelSud() {
		return chPanelSud;
	}

	/**
	 * Modifieur du PanelSud
	 * 
	 * @param chpanelSud le panel a modifier
	 */
	public void setChpanelSud(PanelSud parPanelSud) {
		chPanelSud = parPanelSud;
	}
}
