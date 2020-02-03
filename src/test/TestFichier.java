package test;

import static org.junit.Assert.*;

import java.io.File;

import modele.LectureEcriture;

import org.junit.Test;


public class TestFichier implements modele.Constantes{
	
	
	@Test
	public void testAjoutFichier(){
		File fichier = new File("testExemples");
		String[] repertoire = fichier.list();
		int resultat1 = repertoire.length;
		File fichieramettre = new File("testExemples"+ File.separator + resultat1);
		String objet = "bjr";
		LectureEcriture.ecriture(fichieramettre,objet);
		
		fichier = new File("testExemples");
		repertoire = fichier.list();
		int resultat2 = repertoire.length;
		assertTrue(resultat1  == resultat2 - 1);
	}
}
