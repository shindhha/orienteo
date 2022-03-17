
/* Tests.java                                                 DATE : 05/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package pereNoel;
/**
 * 
 * 
 * 
 */
public class Tests {

    
    static Plage  plageTest = new Plage(0,10);
    
    /** TODO commenter le rôle de cette méthode (SRP)
     * 
     */
    
    /* Test des constructeurs / Methode pour la classe 'Jouet' */
    private static boolean testJouetStringIntPlage() {
        
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
                new Jouet(JEU_DE_TEST_NOM[i],JEU_DE_TEST_POID[i],plageTest);
                testOk = false;
            } catch (IllegalArgumentException nomNull) {
                testOk = true;
            }
        }
        
        return testOk;
    }
    /* Test des constructeurs / Methode pour la classe 'Plage' */
    private static boolean testPlageIntInt() {
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
    
    /* Test des constructeurs / Methode pour la classe 'Sac' */
    private static boolean testSacString() {
        
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
                new Sac(JEU_DE_TEST_NOM[i]);
                testOk = false;
            } catch (IllegalArgumentException nomNull) {
                testOk = true;
            }
        }
        return testOk;
        
    }
    //TODO testAdd
    private static boolean testSacAdd() {
        boolean testOk = false;
        final Sac[] JEU_DE_TEST_SAC = 
                    {
                                    new Sac("Sac de Test"),
                    };
        final Jouet[] JEU_DE_TEST_JOUET =
                    {
                                    new Jouet("Jouet de Test",50,plageTest)
                    };
        
        for (int i = 0; i < JEU_DE_TEST_JOUET.length; i++) {
            try {
                JEU_DE_TEST_SAC[0].add(JEU_DE_TEST_JOUET[i]);
                testOk = false;
            } catch (Exception e) {
                testOk = true;
            }
        }
        // TODO voir si la masse du Sac bouge bien
        // TODO 
        
        
        return testOk;
        
    }
    // TODO testRemove
    // TODO testToString
    // TODO testIsHere
    /** TODO commenter le rôle de cette méthode (SRP)
     * @param args
     */
    public static void main(String[] args) {
        
        
        boolean ok;
        
        ok =  testJouetStringIntPlage();
        ok &= testPlageIntInt();
        ok &= testSacString();
        
        if (ok) {
            System.out.println("Réussite des tests unitaires");
        } else {
            System.out.println("Echec des tests unitaires");
        }
    }





        
}
