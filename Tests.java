/* Tests.java                                                 DATE : 05/03/2022
 * Iut-Rodez 2021-2022 
 * pas de droit d'auteur ni de copyright
 */
package orienteo;

import orienteo.*;
/**
 * 
 * 
 * 
 */
public class Tests {


    private void TestsRetirer() {

        

        
    }

    /**
     * 
     * 
     * 
     */
    public static void main(String[] args) {

        Sac pere = new Sac("hote du pere noel");
        Sac mere = new Sac("hote de la mere noel");
        Sac test = new Sac("Sac de test");
        Plage plage1 = new Plage(8,16);


        Jouet bateau = new Jouet(250,"bateau",plage1);

        Jouet tracteur = new Jouet(1000,"tracteur",plage1);

        mere.add(bateau);
        mere.add(tracteur);
        if( mere.isHere(bateau) == -1 ) {
            System.out.println("Erreur l'objet na pas été trouver dans le Sac !");
        } else {
            System.out.println("L'objet est présent au rang : " + (mere.isHere(bateau) + 1));
        }
    





        
    }
}