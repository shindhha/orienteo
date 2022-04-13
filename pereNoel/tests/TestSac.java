/*
 * TestSac.java                                  31 mars 2022
 * IUT de Rodez, Info1 2021-2022 Groupe 3, pas de copyright 
 */
package pereNoel.tests;

import pereNoel.Jouet;
import pereNoel.Sac;
import static pereNoel.tests.Tests.JEU_DE_TEST_JOUET;
import static pereNoel.tests.Tests.JEU_DE_TEST_SAC;
import static pereNoel.tests.Tests.plageTest;
import static pereNoel.tests.Tests.CAPACITE;
/** TODO commenter la responsabilité de cette classe
 * @author guillaume.medard
 *
 */
public class TestSac {

    
    /* Base de données pour les tests */
    /** 
     * Test du constructeur du Sac
     * @return si les tests sont bons
     */
    protected static boolean testSacString() {
        
        boolean testOk = false;
        
        final String[] JEU_DE_TEST_NOM =
                    {
                                    null,
                                    "",
                                    "        ",
                                    "sduioqqsdiopdjsqjdoqsjdqsodqsiodqshdjioqshdijoqshdijqshdiqosjdhioqsudhqsioudhqsioduqhsdiquosdh",   
                    };
        
        for (int i = 0; i < JEU_DE_TEST_NOM.length; i++ ) {
            try {
                new Sac(JEU_DE_TEST_NOM[i],CAPACITE);
                testOk = false;
            } catch (IllegalArgumentException nomNull) {
                testOk = true;
            }
        }
        return testOk;
        
    }
    /** 
     * Test de la méthode qui constate la présence d'un objet dans le sac
     * @return true si les tests sont bon , false sinon
     */
    protected static boolean testSacIsHere() {
        boolean testOk = true;
        Jouet present = JEU_DE_TEST_JOUET[0];
        Jouet absent = JEU_DE_TEST_JOUET[1];
        
        JEU_DE_TEST_SAC[2].add(present);
        
        testOk = JEU_DE_TEST_SAC[2].isHere(present) != -1;
        testOk &= JEU_DE_TEST_SAC[2].isHere(absent) == -1;
        
        
        return testOk;
    }
    /** Test pour ajouter des jouet au sac
     * @return true si les tests sont satisfesant
     */
    protected static boolean testSacAdd() {
        boolean testOk = true;
        double masseIniSac;
        double masseDuJouet;
        double masseApresAjout;
        
        
        
        for (int i = 0; i < JEU_DE_TEST_JOUET.length; i++) {
            
            masseDuJouet = JEU_DE_TEST_JOUET[i].getMasseKg();
            masseIniSac = JEU_DE_TEST_SAC[0].getMasse();
            JEU_DE_TEST_SAC[0].add(JEU_DE_TEST_JOUET[i]);
            masseApresAjout = JEU_DE_TEST_SAC[0].getMasse();
            
            
         /* Test sur la variation de la masse du sac lors de l'ajout d'un objet 
          * ainsi que pour s'assurer que l'on retrouve bien l'occurence de l'objet
          * dans le tableau associé au sac
          */
            if (!(masseIniSac +  masseDuJouet == masseApresAjout)
                  ||  JEU_DE_TEST_SAC[0].isHere(JEU_DE_TEST_JOUET[i]) == -1) {
                
                testOk = false;
            }
         /* Test pour également vérifier que le programme retourne bien une erreur
          * si l'objet que l'on essaye de retrouver ne se trouve pas dans le sac
          */
            Jouet testJouet = new  Jouet("Jouet de test ",50,plageTest);
            if (!((JEU_DE_TEST_SAC[0].isHere(testJouet)) == -1)) {
                testOk = false;
            }
            
            try {
                JEU_DE_TEST_SAC[1].testSetMasse(99999);
                JEU_DE_TEST_SAC[1].add(JEU_DE_TEST_JOUET[0]);
                testOk = false;
            } catch (IllegalArgumentException error) {
                testOk = true;
            }
        }
        return testOk;
        
    }
    

    /** Test de la methode pour retirer un objet du sac
     * @return true si les tests sont satisfesant
     */
    protected static boolean testRemove() {
        boolean testOk = true;
        
        return testOk;
    }
    // TODO testToString
    
}
