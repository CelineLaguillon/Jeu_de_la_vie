package modele;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe pour lire des fichiers ou ecrire dedans
 * 
 * @author CelineLaguillon et Louis Barraque
 */

public class LectureEcriture {
	
	/**
	 * Lit un fichier
	 * 
	 * @param parFichier le fichier a lire
	 * @return objetLu l'objet lu par la methode
	 */
	public static Object lecture (File parFichier){
		ObjectInputStream flux;
		Object objetLu = null;
		
		// Ouverture du fichier en mode lecture
		try{
			flux = new ObjectInputStream(new FileInputStream(parFichier));
			objetLu = (Object)flux.readObject();
			flux.close();
		}
		
		catch(ClassNotFoundException parException){
			System.err.println(parException.toString());
			System.exit(1);
		}
		
		catch(IOException parException){
			System.err.println("Erreur lecture du fichier " + parException.toString());
			System.exit(1);
		}
		
		return objetLu;
	} // lecture()
	
	/**
	 * Ecrit dans un nouveau fichier
	 * 
	 * @param parFichier le nom du fichier de destination
	 * @param parObjet l'objet a ecrire dans le fichier
	 */
	public static void ecriture(File parFichier, Object parObjet){
		ObjectOutputStream flux = null;
		
		// Ouverture du fichier en mode �criture
		try{
			flux = new ObjectOutputStream(new FileOutputStream(parFichier));
			flux.writeObject(parObjet);
			flux.flush();
			flux.close();
		}
		
		catch(IOException parException){
			System.err.println("Probleme a l'ecriture\n" + parException.toString());
			System.exit(1);
		} 
	} // ecriture()
}