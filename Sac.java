/* Sac.java                                                   DATE : 02/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package orienteo;

import orienteo.Jouet.*;
import java.util.ArrayList;
import orienteo.Plage.*;
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

    public Sac(String name) {
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
    /**
     * Retire le premier jouet ayant le nom donné en paramètre
     * @param jouet le nom du jouet a retirer
     */

    public void remove(Jouet jouet) {

        boolean retirer = false;
        for (int rang = 0; 
                 rang <= this.content.size() && !retirer;rang++) {

            if (this.content.get(rang) == jouet) {
                this.content.remove(rang);
                retirer = true;
            } 
        }
    }
    /** Vide entièrement le Sac */
    public void clear() {
        this.content.clear();
    }
    /**
     * @param jouet le jouet que dont on veut savoir si il est présent dans le sac
     * @return retourne la position du jouet dans le Sac si il est présent sinon retourne -1
     */ 
    public int isHere(Jouet jouet) {

        final int NOT_HERE = -1;
        boolean retirer = false;
        int rang = 0;
        while ( rang < this.content.size() && !retirer)  {

            if (this.content.get(rang) == jouet) {
                retirer = true;
            } 
            rang++;
        } 
        if(retirer == false) {
            return NOT_HERE;
        }
        return rang;
    }

}