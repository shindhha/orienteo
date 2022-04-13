
/* Tests.java                                                 DATE : 05/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel.tests;

import pereNoel.Jouet;
import pereNoel.Plage;
import pereNoel.Sac;

/**
 * 
 * 
 * 
 */
public class Tests {

    static final int CAPACITE = 1000;
    /** Plage aléatoire necessaire pour la création des autres objets */
    protected static final Plage  plageTest = new Plage(0,10);
    /** Jeu de test de type de jouet */
    protected static final Jouet[] JEU_DE_TEST_JOUET =
                {
                                new Jouet("Jouet de Test",50,plageTest),
                                new Jouet("Jouet de Test 2",80,plageTest)
                };
    /** Jeu de test de type de Sac */
    protected static final Sac[] JEU_DE_TEST_SAC = 
                {
                                new Sac("Sac de Test",CAPACITE),
                                new Sac("Sac de Test2",CAPACITE),
                                new Sac("Sac de Test pour 'isHere' ",CAPACITE)
                };
    
    /** 
     * Lancement des tests unitaires et affichage du resultat
     * @param args non utilise
     */
    public static void main(String[] args) {
        
        
        boolean ok;
        
        ok =  TestJouet.testJouetStringIntPlage();
        ok &= TestPlage.testPlageIntInt();
        ok &= TestSac.testSacString();
//        ok &= TestJouet.testGetMassekg();
        ok &= TestSac.testSacIsHere();
        if (ok) {
            System.out.println("Réussite des tests unitaires");
        } else {
            System.out.println("Echec des tests unitaires");
        }
    }





        
}
