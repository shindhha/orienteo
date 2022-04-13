/*
 * TestPlage.java                                  31 mars 2022
 * IUT de Rodez, Info1 2021-2022 Groupe 3, pas de copyright 
 */
package pereNoel.tests;

import pereNoel.Plage;
import static pereNoel.tests.Tests.JEU_DE_TEST_JOUET;
import static pereNoel.tests.Tests.JEU_DE_TEST_SAC;
import static pereNoel.tests.Tests.plageTest;
/** TODO commenter la responsabilité de cette classe
 * @author guillaume.medard
 *
 */
public class TestPlage {
    
    /** Test des constructeurs / Methode pour la classe 'Plage'
     * @return si les tests sont bon
     */
    protected static boolean testPlageIntInt() {
        boolean testOk = false;
        final int[][] JEU_DE_TEST_PLAGE =
                    {
                                    {10,-8},
                                    {-10,8},
                                    {-10,-8}
                    };
        
        
        for (int i = 0; i < JEU_DE_TEST_PLAGE.length; i++ ) {
            try {
                new Plage(JEU_DE_TEST_PLAGE[i][0],JEU_DE_TEST_PLAGE[i][1]);
                testOk= false;
                
            } catch (IllegalArgumentException ageNegatif) {
                testOk = true;
            }
        }
        return testOk;
    }
}
