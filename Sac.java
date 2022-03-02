/* Sac.java                                                   DATE : 02/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package orienteo;

import orienteo.Jouet.*;
import java.util.ArrayList;
/**
 * Représentation d'un sac sous la forme d'un objet java
 * L'objet possède des caractéristique comme :
 * - son nom
 * - Une masse qui augmente avec les objets que l'on y intégre
 *   Cette masse ne peut dépacer une certaine quantité "CAPACITE"
 * @author Guillaume MEDARD
 */
public class Sac {

	private ArrayList<Jouet> content = new ArrayList<Jouet>();

	private final int CAPACITE = 100000;

	private  String name;

	private  int masse;
	/** 
	 * Constructeur de l'objet Sac 
	 * @param name nom du Sac
	 */

	private Sac(String name) {
		this.name = name;
		this.masse = 0;
	}

	/** 
	 * Ajoute un objet de la classe Jouet au Sac uniquement si :
	 * La masse du sac plus la masse de l'objet est inférieure ou égale 
	 * a la CAPACITE
	 * @param jouet Le jouet que l'on veut ajouter
	 */
	public void add(Jouet jouet) {

		if (this.masse + jouet.getMasse() > CAPACITE) {
			System.out.print("L'Objet est trop lourd pour "
				             +"la capacite restante du sac ! "
				             +"(capacite restante : " + (CAPACITE - this.masse) + ")");
			return;
		}
		this.masse += jouet.getMasse();
		this.content.add(jouet);
	}
    /** @return le nom du sac */
	public String getName() {
		return this.name;
	}

	/** @return la masse cumulé du sac et des objets qu'il contient */
	public int getMasse() {
		return this.masse;
	}
	/** @return true si le sac ne comptien aucun Jouet */
	public boolean isEmpty() {
		return content.isEmpty();
	}
	/** @return true si la masse totale est égale a la capacite du sac*/
	public boolean isFull() {
		return this.masse == CAPACITE;
	}
	/** Affiche la liste des jouets contenue dans le sac */
	public void toStringS() {
		for (Jouet jouet : content) {
			System.out.print(jouet.getName() + " ");
		}
	}
	//TODO Méthode pour extraire la premiere occurence d'un objet
	//TODO Méthode pour vider entièrement le sac
	//TODO Méthode pour tester la présence d'un objet
	/**
	 * Test unitaires mal fait 
	 * @param args non utilisé 
	 */
	public static void main(String[] args) {

		Sac pere = new Sac("hote du pere noel");
		Sac mere = new Sac("hote de la mere noel");
		Sac test = new Sac("Sac de test");

		Jouet bateau = new Jouet(250,"bateau",0,8);

		Jouet tracteur = new Jouet(100000,"tracteur",15,18);

		pere.add(bateau);
		pere.add(tracteur);
		mere.add(bateau);
		mere.add(bateau);

		System.out.println(pere.getMasse());
		System.out.println(mere.getMasse());
		System.out.println(mere.isEmpty());
		System.out.println(test.isEmpty());

		pere.toString();

		
	}
}