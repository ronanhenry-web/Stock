package stockRoro;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * 
 * @author Ronan
 *
 */
public class Geststock {
	static private ArrayList<Article> lesArticles = new ArrayList<>();

	static public void main(String[] args) {
      final String MENU1 = "1: Création d'un article";
      final String MENU2 = "\n2: Consultation du stock";
      final String MENU3 = "\n3: Entrée en stock par position";
      final String MENU4 = "\n4: Sortie du stock par position";
      final String MENU5 = "\n5: Entrée en stock par code d'article";
      final String MENU6 = "\n6: Sortie du stock par code d'article";
      final String MENU7 = "\n7: Récapitulatif des mouvements";
      final String MENU8 = "\n8: Modification du libellé d'un article par son code";
      final String MENU9 = "\n9: Nombre d'entrées/sorties tous articles confondus";
      final String QUESTION = "\nVotre choix SVP :";
      final String QCODE = "Entrez un code d'article";
      final String QLIB = "Entrez un libellé d'article";
      final String QLIBN = "Opération Nouveau libellé";
      final String QPRIX = "Entrez un prix d'article";
      final String QPOS = "Entrez la position de l'article en stock";
      final String ERR = "Erreur dans le choix de l'article !";
      final String QENTREE = "Entrez le nombre d'article à entrer en stock";
      final String QSORTIE = "Entrez le nombre d'article à prélever du stock";
      final String QARTCODE = "Entrez le code de l'article en stock";
      final String NVLIB = "Entrez le nouveau libellé d'article";
      
      int nbArticles = 0;

      String menu = MENU1 + MENU2;
      menu += MENU3 + MENU4;
      menu += MENU5 + MENU6;
      menu += MENU7 + MENU8;
      menu += MENU9;
      menu += QUESTION;

      String choix;
      choix = JOptionPane.showInputDialog(menu);

      while (!(choix == null)) {
         switch (choix) {
         case "1":
            if (nbArticles <= lesArticles.size()) {
               String unCode = JOptionPane.showInputDialog(QCODE);
               String unLib = JOptionPane.showInputDialog(QLIB);
               float unPrix = Float.parseFloat(JOptionPane.showInputDialog(QPRIX));
               lesArticles.add(new Article(unCode, unLib, unPrix));
               nbArticles++;
            }
            break;
         case "2": {
            String res = "**** Les articles ****";
            double total = 0;
            for (int i = 0; i < nbArticles; i++) {
               res += "\n***********\n" + lesArticles.get(i).toString();
               total += lesArticles.get(i).getMontant();
            }
            res += "\n***********\nMontant total en stock " + total;
            JOptionPane.showMessageDialog(null, res);
         }
            break;
         case "3":
         case "4": {
            String spos = JOptionPane.showInputDialog(QPOS);
            String res = "";
            int pos = Integer.parseInt(spos);
            if (!(pos >= 0 && pos < nbArticles)) {
               JOptionPane.showMessageDialog(null, ERR);
            } else {
               if ("3".equals(choix)) {
                  String sEntree = JOptionPane.showInputDialog(QENTREE);
                  int entree = Integer.parseInt(sEntree);
                  res += lesArticles.get(pos).toString();
                  lesArticles.get(pos).ajouter(entree);
               } else {
                  String sSortie = JOptionPane.showInputDialog(QSORTIE);
                  int sortie = Integer.parseInt(sSortie);
                  res += lesArticles.get(pos).toString();
                  lesArticles.get(pos).prelever(sortie);
               }
               res += "\n" + lesArticles.get(pos).toString();
               JOptionPane.showMessageDialog(null, res);
            }
         }
            break;
         case "5":
         case "6": {
            String code = JOptionPane.showInputDialog(QARTCODE);
            String res = "";
            // recherche de la position de l'article dans le tableau
            int pos = -1;
            int i = 0;
            while (!lesArticles.get(i).getCode().equals(code) && i < nbArticles - 1) {
               i++;
            }
            if (lesArticles.get(i).getCode().equals(code)) {
               pos = i;
            }
            // a-t-on trouvé sa position dans la liste ?
            if (pos >= 0) {
               // oui, on peut poursuivre.
               if ("5".equals(choix)) {
                  String sEntree = JOptionPane.showInputDialog(QENTREE);

                  int entree = Integer.parseInt(sEntree);
                  res += lesArticles.get(pos).toString();
                  lesArticles.get(pos).ajouter(entree);
               } else {
                  String sSortie = JOptionPane.showInputDialog(QSORTIE);
                  int sortie = Integer.parseInt(sSortie);
                  res += lesArticles.get(pos).toString();
                  lesArticles.get(pos).prelever(sortie);
               }
               res += "\n" + lesArticles.get(pos).toString();
               JOptionPane.showMessageDialog(null, res);
            } else {
               JOptionPane.showMessageDialog(null, ERR);
            }
            
         }
            break;
         case "7":
            String recap = " *** Recap ***";

            for (int i = 0; i < nbArticles; i++) {
               recap += lesArticles.get(i).toString(lesArticles.get(i).getLibelle());
            }
            System.out.println(recap);
            break;
         case "8": {
        	 String code = JOptionPane.showInputDialog(QARTCODE);
             String res = "";
             int pos = -1;
             int i = 0;
             while (!lesArticles.get(i).getCode().equals(code) && i < nbArticles - 1) {
                i++;
             }
             if (lesArticles.get(i).getCode().equals(code)) {
                pos = i;
             }
             
             if (pos >= 0) {
                 if ("8".equals(choix)) {
                	 String leLib = JOptionPane.showInputDialog(NVLIB);
                	 
                     res += lesArticles.get(pos).toString();
                     //lesArticles.get(pos).codeEtLib(leLib);
                 }
                 res += "\n" + QLIBN + "/n" + lesArticles.get(pos).toString();
                 JOptionPane.showMessageDialog(null, res);
              } else {
                 JOptionPane.showMessageDialog(null, ERR);
              }
        	break;
         	}
         case "9": {
 			String msg = " *** Nombre d'entrées/sorties tous les articles confondues ***";
 			for (int i = 0; i < nbArticles; i++) {
                msg += "\n" + lesArticles.get(i).toString(lesArticles.get(i).getLibelle());
             }
 			JOptionPane.showMessageDialog(null, msg);
 			System.out.println(msg);
 			break;
 			}
         } 
         // redemande un choix à l'utilisateur
         choix = JOptionPane.showInputDialog(menu);
      }
      // pour forcer la fermeture.
      System.exit(0);
   }
}