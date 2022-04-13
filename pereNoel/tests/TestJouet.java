/*
 * TestJouet.java                                  31 mars 2022
 * IUT de Rodez, Info1 2021-2022 Groupe 3, pas de copyright 
 */
package pereNoel.tests;

import pereNoel.Jouet;
import static pereNoel.tests.Tests.JEU_DE_TEST_JOUET;
import static pereNoel.tests.Tests.JEU_DE_TEST_SAC;
import static pereNoel.tests.Tests.plageTest;
/** TODO commenter la responsabilité de cette classe
 * @author guillaume.medard
 *
 */
public class TestJouet {

    /**  
     * Tests de la methode toString pour les jouets 
     * @return si les tests sont bon
     */
    protected static boolean testGetMassekg() {
        boolean ok = true;
        String[] Attendu = {
                        "Jouet de test : 0.05 kg, à partir de 0 jusqu'à 10",
                        "Jouet de test 2 : 0.08 kg à partir de 0 jusqu'à 10"
        };
        for (int noTest = 0 ; noTest < Attendu.length; noTest++ ) {
            ok &= Attendu[noTest].equals(Tests.JEU_DE_TEST_JOUET[noTest].toString());
        }
        
        return ok;
    }
    /** 
     * Test des constructeurs / Methode pour la classe 'Jouet'
     * @return si les tests sont bon
     */
    protected static boolean testJouetStringIntPlage() {
        
        boolean testOk = false;
        final String[] JEU_DE_TEST_NOM = 
                    {
                                    null,
                                    "",
                                    "        ",
                                    "sduioqqsdiopdjsqjdoqsjdqsodqsiodqshdjioqshdijoqshdijqshdiqosjdhioqsudhqsioudhqsioduqhsdiquosdh",
                                    "Tortue ninja"
                    };
        final int[] JEU_DE_TEST_POID =
                    {
                                    50,
                                    50,
                                    30,
                                    30,
                                    -80,
                    };
        
        for (int i = 0; i < JEU_DE_TEST_NOM.length; i++) {
            try {
                new Jouet(JEU_DE_TEST_NOM[i],JEU_DE_TEST_POID[i],Tests.plageTest);
                testOk = false;
            } catch (IllegalArgumentException nomNull) {
                testOk = true;
            }
        }
        
        return testOk;
    }

}
