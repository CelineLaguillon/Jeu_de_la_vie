package vue;

import java.awt.ComponentOrientation;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controleur.Controleur;

/**
 * Classe qui ouvre la fenetre principale du programme
 * 
 * @author Celine Laguillon et Louis Barraque
 */

@SuppressWarnings("serial")
public class FenetreMere extends JFrame implements modele.Constantes{
	
	/**
	 * Barre de menu de la fenetre
	 */
	private JMenuBar chMenusBar;
	
	/**
	 * Tableau de menus de la barre
	 */
	private JMenu[] chMenus;
	
	/**
	 * Item de la barre pour fermer la fenetre
	 */
	private JMenuItem chQuitter;
	
	/**
	 * Controleur qui s'occupe de toutes les interactions avec l'utilisateur
	 */
	private Controleur chControleur;
	
	/**
	 * Tableau de chaines de caracteres avec tous les noms des fichiers dans le dossier "exemple"
	 */
	private String [] chIntitulesFichiers;
	
	/**
	 * Constructeur de la FenetreMere
	 * 
	 */
	public FenetreMere(String parTitre) {
		super(parTitre);

		/*********** Barre de menu ***********/
		
		chMenusBar = new JMenuBar();
		this.setJMenuBar(chMenusBar);
		
		chMenus = new JMenu[3];
		
		for(int i = 0 ; i < chMenus.length ; i++) {
			chMenus[i] = new JMenu(NOM_ITEM_MENU[i]);
			chMenus[i].setMnemonic(NOM_MNEMONIQUES[i]);
			chMenusBar.add(chMenus[i]);
		}
		
		chQuitter = new JMenuItem(NOM_ITEM_MENU[3]);
		chQuitter.setAccelerator(KeyStroke.getKeyStroke(NOM_MNEMONIQUES[3], java.awt.Event.CTRL_MASK));
		chQuitter.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		chMenusBar.add(chQuitter);		
		
		chControleur = new Controleur(this);
		
		PanelFils contentPane = new PanelFils(chControleur);
		setContentPane(contentPane);
		setBackground(CONSTANTE_ROUGE);		
		contentPane.setBackground(CONSTANTE_JAUNE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(LARGEUR_FENETRE_MERE,HAUTEUR_FENETRE_MERE);
		setVisible(true);
		setLocation(POSITION_X_FENETRE_MERE,POSITION_Y_FENETRE_MERE);
	}
	
	public static void main(String [] args) {
		new FenetreMere("Le jeu de la vie");
	}
	
	/**
	 * Ajout des items aux menus ainsi que la mise a� l'ecoute d'un controleur
	 * 
	 * @param parControleur le controleur mis a l'ecoute des items
	 */
	public void ajoutItem(Controleur parControleur){
		
		for(int i = 0 ; i < NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES.length ; i++){
			JMenuItem item = new JMenuItem(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES[i], NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES[i].charAt(0));
			item.setAccelerator(KeyStroke.getKeyStroke(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES[i].charAt(7), java.awt.Event.CTRL_MASK));
			item.addActionListener(parControleur);
			item.setActionCommand(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [i] + "a");
			chMenus[0].add(item);
		}
		
		File repertoire = new File("../exemples");
		chIntitulesFichiers = repertoire.list();
		for (int i = 0 ; i < chIntitulesFichiers.length ; i++){
			JMenuItem item = new JMenuItem(chIntitulesFichiers[i], chIntitulesFichiers[i].charAt(0));
			item.setAccelerator(KeyStroke.getKeyStroke(chIntitulesFichiers[i].charAt(4), java.awt.Event.CTRL_MASK));
			item.addActionListener(parControleur);
			item.setActionCommand(chIntitulesFichiers[i]);
			chMenus[1].add(item);
		}
		
		for(int i = 0 ; i < NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES.length ; i++){
			JMenuItem item = new JMenuItem(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES[i], NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES[i].charAt(0));
			item.setAccelerator(KeyStroke.getKeyStroke(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES[i].charAt(7), java.awt.Event.CTRL_MASK));
			item.addActionListener(parControleur);
			item.setActionCommand(NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [i]+"v");
			chMenus[2].add(item);
		}
		
		chQuitter.addActionListener(parControleur);
		chQuitter.setActionCommand(NOM_ITEM_MENU[3]);
	}
	
	/**
	 * Accesseur d'un element du tableau de menus
	 * 
	 * @param parInt l'indice de l'element a recuperer
	 * @return chMenus[parInt] l'element du menu
	 */
	public JMenu getchMenus(int parInt) {
		return chMenus[parInt];
	}

	/**
	 * Modifieur d'un element du tableau de menus
	 * 
	 * @param parMenu le menu a modifier
	 * @param parInt l'indice de la position du menu dans le tableau a modifier
	 */
	public void setchMenus(JMenu parMenu,int parInt) {
		this.chMenus[parInt] = parMenu;
	}
	
	/**
	 * Accesseur de l'item quitter
	 * 
	 * @return chQuitter l'item quitter
	 */
	public JMenuItem getChQuitter() {
		return chQuitter;
	}

	/**
	 * Modifieur de l'item quitter
	 * 
	 * @param chQuitter l'item a modifier
	 */
	public void setChQuitter(JMenu chQuitter) {
		this.chQuitter = chQuitter;
	}
	
	/**
	 * Accesseur de la barre de menus
	 * 
	 * @return chMenusBar la barre de menus
	 */
	public JMenuBar getChMenusBar(){
		return chMenusBar;
	}
	
	/**
	 * Modifieur de la barre de menus
	 * 
	 * @param chMenusBar la barre de menus a modifier
	 */
	public void setChMenuBar(JMenuBar chMenusBar) {
		this.chMenusBar = chMenusBar;
	}
	
	/**
	 * Accesseur du controleur
	 *
	 * @return chControleur le controleur
	 */
	public Controleur getChControleur() {
		return chControleur;
	}

	/**
	 * Modifieur du Controleur
	 * 
	 * @param chControleur le controleur a modifier
	 */
	public void setChControleur(Controleur chControleur) {
		this.chControleur = chControleur;
	}
	
	/**
	 * Accesseur du tableau avec les noms des fichiers
	 * 
	 * @return chIntitulesFichiers un tableau de chaines de caracteres
	 */
	public String[] getChIntitulesFichiers() {
		return chIntitulesFichiers;
	}

	/**
	 * Modifieur du tableau avec les noms des fichiers
	 * 
	 * @param chIntitulesFichiers le tableau des noms des fichiers a modifier
	 */
	public void setChIntitulesFichiers(String[] chIntitulesFichiers) {
		this.chIntitulesFichiers = chIntitulesFichiers;
	}
}
