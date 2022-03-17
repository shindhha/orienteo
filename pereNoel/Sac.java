/* Sac.java                                                   DATE : 02/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel;

import java.util.ArrayList;

import pereNoel.Jouet.*;
import pereNoel.Plage.*;
/**
 * Representation d'un sac sous la forme d'un objet java
 * L'objet possede des caracteristique comme :
 * - son nom
 * - Une masse qui augmente avec les objets que l'on y integre
 *   Cette masse ne peut dépacer une certaine quantité "CAPACITE"
 * @author Guillaume MEDARD
 */
public class Sac {

    private ArrayList<Jouet> content = new ArrayList<Jouet>();
    private static final int MAX_LENTGH_PATRONYME = 50;
    private final int CAPACITE = 100000;

    private  String name;
    private int masseInitiale;
    private int masse;
    /** 
     * Constructeur de l'objet Sac 
     * @param name nom du Sac
     */

    public Sac(String name) {
        super();
        
        if (name == null ||name.length() > MAX_LENTGH_PATRONYME || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.masse = 0;
        this.masseInitiale = 0;
    }
    /**
     * TODO commenter l'�tat initial atteint
     * @param name
     * @param masseInitiale
     */
    public Sac(String name,int masseInitiale) {
        super();
        
        if (name == null ||name.length() > MAX_LENTGH_PATRONYME || name.isBlank() || masseInitiale < 0) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.masse = 0;
        this.masseInitiale = masseInitiale;
    }
    /** 
     * Ajoute un objet de la classe Jouet au Sac uniquement si :
     * La masse du sac plus la masse de l'objet est inferieure ou égale 
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

    /** @return la masse cumule du sac et des objets qu'il contient */
    public int getMasse() {
        return this.masse;
    }
    /** @return true si le sac ne comptien aucun Jouet */
    public boolean isEmpty() {
        return content.isEmpty();
    }
    /** @return true si la masse totale est egale a la capacite du sac*/
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
     * Retire le premier jouet ayant le nom donne en parametre
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
    /** Vide entierement le Sac */
    public void clear() {
        this.content.clear();
    }
    /**
     * @param jouet le jouet que dont on veut savoir si il est present dans le sac
     * @return retourne la position du jouet dans le Sac si il est present sinon retourne -1
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