/* Sac.java                                                   DATE : 02/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel;

import java.nio.BufferOverflowException;
import java.util.ArrayList;

import pereNoel.Jouet.*;
import pereNoel.Plage.*;
/**
 * Representation d'un sac sous la forme d'un objet java
 * L'objet possede des caracteristique comme :
 * - son nom
 * - Une masse qui augmente avec les objets que l'on y integre
 *   Cette masse ne peut d√©pacer une certaine quantit√© "CAPACITE"
 * @author Guillaume MEDARD
 */
public class Sac {
    private ArrayList<Jouet> content = new ArrayList<Jouet>();
    private static final int MAX_LENTGH_PATRONYME = 50;
    private static final int CAPACITE_MAX = 100000;
    private final int CAPACITE;

    private  String name;
    private int masseInitiale;
    private int masse;
    /** 
     * Constructeur de l'objet Sac 
     * @param name nom du Sac
     * @param CAPACITE dqs
     */

    public Sac(String name,final int CAPACITE) {
        super();
        
        if (name == null ||name.length() > MAX_LENTGH_PATRONYME || name.isBlank()
            || CAPACITE < 0 || CAPACITE > CAPACITE_MAX) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.masse = 0;
        this.masseInitiale = 0;
        this.CAPACITE = CAPACITE;
    }
    /**
     * TODO commenter l'Ètat initial atteint
     * @param name nom du sac
     * @param masseInitiale masse du sac sans objet ‡ l'intÈrieur
     * @param CAPACITE 
     * @throw si l'utilisateur n'a pas donner de nom , 
     *        si il est trop long ou si la masseInitiale passer en argument est nÈgative 
     */
    public Sac(String name,int masseInitiale,final int CAPACITE)  {
        super();
        
        if (name == null ||name.length() > MAX_LENTGH_PATRONYME 
            || name.isBlank() || masseInitiale < 0 || CAPACITE < 0 || CAPACITE > CAPACITE_MAX) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.masse = 0;
        this.masseInitiale = masseInitiale;
        this.CAPACITE = CAPACITE;
    }
    
    /** 
     * Ajoute un objet de la classe Jouet au Sac uniquement si :
     * La somme de la masse du sac plus la masse de l'objet est inferieure ou egale 
     * a la CAPACITE
     * @param jouetAjouter Le jouet que l'on veut ajouter
     * @throw si le sac ne possËde pas la place pour accueillir le jouet
     */
    public void add(Jouet jouetAjouter) {
        if (jouetAjouter == null) {
            throw new NullPointerException();
        }
        if (this.masse + jouetAjouter.getMasseKg() > CAPACITE) {
            throw new BufferOverflowException();
        }
        this.masse += jouetAjouter.getMasseKg();
        this.content.add(jouetAjouter);
    }
    
    /** Affiche la liste des jouets contenu dans le sac */
    @Override
    public String toString() {
        StringBuilder sacToString = new StringBuilder();
        for (Jouet jouet : content) {
            sacToString.append(jouet.getName() + " ");
        }
        return sacToString.toString();
    }
    /**
     * Retire le premier jouet ayant le nom donne en parametre
     * @param jouet le nom du jouet a retirer
     */

    public void retirer(Jouet jouet) {

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
        this.masse = 0;
    }
    /**
     * @param aTrouver le jouet que dont on veut savoir si il est present dans le sac
     * @return retourne si le jouet est contenue dans un sac
     */ 
    public boolean isHere(Jouet aTrouver) {

        boolean present = false;
        
        for (int rang = 0; rang < this.content.size() && !present; rang++)  {

            if (this.content.get(rang) == aTrouver) {
                present = true;
            } 
            
        } 
        return present;
    }
    /** TODO commenter le rÙle de cette mÈthode (SRP)
     * @param indiceATrouver
     * @return l'indice de l'objet
     */
    public int getIndex(Jouet indiceATrouver) {
        if (!isHere(indiceATrouver)) {
            throw new IllegalArgumentException();
        }
        return CAPACITE;
        
    }
    /** @return le nom du sac */
    public String getName() {
        return this.name;
    }

    /** @return la masse cumule du sac et des objets qu'il contient */
    public int getMasse() {
        return this.masse;
    }
    /** @return la masse du sac sans prendre en compte les jouets en l'interieur */
    public int getMasseIni() {
        return this.masseInitiale;
    }
    /** @return true si le sac ne comptien aucun Jouet */
    public boolean isEmpty() {
        return content.isEmpty();
    }
    /** @return true si la masse totale est egale a la capacite du sac*/
    public boolean isFull() {
        return this.masse == CAPACITE;
    }
    /* ******************** COMMANDE TEMPORAIRES ******************** */
    /** TODO commenter le rÙle de cette mÈthode (SRP)
     * @param masse
     */
    public void testSetMasse(int masse) {
        this.masse = masse;
    }

}