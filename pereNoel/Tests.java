
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
        boolean testOk = true;
        int masseIniSac;
        int masseDuJouet;
        int masseApresAjout;
        final Sac[] JEU_DE_TEST_SAC = 
                    {
                                    new Sac("Sac de Test"),
                                    new Sac("Sac de Test2")
                    };
        final Jouet[] JEU_DE_TEST_JOUET =
                    {
                                    new Jouet("Jouet de Test",50,plageTest),
                                    new Jouet("Jouet de Test 2",80,plageTest)
                    };
        
        for (int i = 0; i < JEU_DE_TEST_JOUET.length; i++) {
            
            masseDuJouet = JEU_DE_TEST_JOUET[i].getMasse();
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
            } catch (IllegalArgumentException e) {
                testOk = true;
            }
        }
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
        ok &= testSacAdd();
        
        if (ok) {
            System.out.println("Réussite des tests unitaires");
        } else {
            System.out.println("Echec des tests unitaires");
        }
    }





        
}
