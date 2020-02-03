package modele;

import java.awt.Color;
/**
 * Interface des constantes utilisees dans les differentes classes
 * 
 * @author Celine Laguillon et Louis Barraque
 */
public interface Constantes {
	
	/**
	 * Constante de la largeur de la fenetreMere lors de son ouverture
	 */
	public static final int LARGEUR_FENETRE_MERE = 800;
	
	/**
	 * Constante de la hauteur de la fenetreMere lors de son ouverture
	 */
	public static final int HAUTEUR_FENETRE_MERE = 600;
	
	/**
	 * Constante de la position sur l'axe des abscisses de la fenetreMere lors de son ouverture
	 */
	public static final int POSITION_X_FENETRE_MERE = 300;
	
	/**
	 * Constante de la position sur l'axe des ordonnees de la fenetreMere lors de son ouverture
	 */
	public static final int POSITION_Y_FENETRE_MERE = 70;
	
	/**
	 * Constante de la couleur rouge
	 */
	public static final Color CONSTANTE_ROUGE = new Color(215, 33, 33);
	
	/**
	 * Constante de la couleur jaune
	 */
	public static final Color CONSTANTE_JAUNE = new Color(255, 235, 16);
	
	/**
	 * Constante de la couleur des cellules "mortes"
	 */
	public static final Color CONSTANTE_CELLULE_MORTE = Color.WHITE;
	
	/**
	 * Constante de la couleur des cellules "en vie"
	 */
	public static final Color CONSTANTE_CELLULE_EN_VIE = Color.BLACK;
	
	/**
	 * Tableau des constantes des noms des labels du PanelNord
	 */
	public static final String NOM_LABELS_NORD[] = {"Generation ","Population"};
	
	/**
	 * Tableau des constantes des noms des boutons du PanelSud
	 */
	public static final String NOM_BOUTTONS_SUD[] = {"Generation suivante","Avance rapide","Pause","Enregistrer"};
	
	/**
	 * Constante du nom du label du PanelSud
	 */
	public static final String NOM_LABELS_SUD = "Nom du damier :";
	
	/**
	 * Constante de longueur du JTextField dans le PanelSud
	 */
	public static final int LONGUEUR_JTEXTFIELD_SUD = 10;
	
	/**
	 * Tableau des constantes des noms des menus de la barre de menu
	 */
	public static final String NOM_ITEM_MENU[] = {"Damiers aleatoires", "Damiers exemples", "Damiers vides", "Quitter"};
	
	/**
	 * Tableau des constantes des noms des items du premier et du troisieme menu de la barre
	 */
	public static final String NOM_MENU_DAMIERS_ALEATOIRES_ET_VIDES [] = {"Damier A : 25 x 25", "Damier B : 35 x 35", "Damier C : 45 x 45"};
	
	/**
	 * Tableau des constantes des mnemoniques de la barre
	 */
	public static final char NOM_MNEMONIQUES[] = {'D', 'm', 'v', 'Q'};
	
	/**
	 * Constante du nom du timer
	 */
	public static final String NOM_TIMER = "TIMER";
}