package stockRoro;

import java.util.Scanner;

/**
 * @author Ronan
 *
 */

public class Article {
   /** Attributes */
   private final String code;
   private String libelle;
   private float prix;
   protected int entrees;
   private int sorties;
   private int nbMvtsSortie;
   private int nbMvtsEntree;

   /**
    * Un constructeur.
    *
    * @param code
    *           le code de l'article.
    * @param lib
    *           le libellé de l'article.
    * @param prix
    *           le prix de l'article.
    */
   public Article(String code, String lib, float prix) {
      final String M_PRIX = "Prix incorrect, veuillez donner un prix > 0 : ";
      Scanner clavier = new Scanner(System.in);
      this.code = code;
      this.libelle = lib;
      while (!(prix > 0)) {
         System.out.println(M_PRIX);
         prix = clavier.nextFloat();
      }
      clavier.close();
      this.prix = prix;
   }

   /**
    * Permet de modifier le libellé de l'article
    *
    * @param valeur
    *           le nouveau libellé de l'article.
    */
   public void setLibelle(String valeur) {
      libelle = valeur;
   }

   /**
    * Permet de modifier le prix de l'article
    *
    * @param valeur
    *           le nouveau prix de l'article.
    */
   public void setPrix(float valeur) {
      prix = valeur;
   }

   /**
    * Permet de connaître la valeur de l'attribut libellé
    *
    * @return le libellé de l'article.
    */
   public String getLibelle() {
      return libelle;
   }

   /**
    * Permet de connaître la valeur de l'attribut code
    *
    * @return le code de l'article.
    */
   public String getCode() {
      return code;
   }

   /**
    * Permet de connaître la valeur de l'attribut prix
    *
    * @return le prix de l'article.
    */
   public float getPrix() {
      return prix;
   }

   /**
    * Permet d'ajouter des articles en stock
    *
    * @param valeur
    *           le nombre d'articles à ajouter.
    */
   public void ajouter(int valeur) {
      this.entrees += valeur;
      this.nbMvtsEntree++;
   }

   /**
    * Permet de connaître le nombre actuel d'articles en stock
    *
    * @return le nombre d'articles en stock.
    */
   public int getQuantite() {
      return this.entrees - this.sorties;
   }

   /**
    * Permet de prélever des articles du stock
    *
    * @param valeur
    *           le nombre d'articles à prélever
    */
   public void prelever(int valeur) {
      final String ERR = " : Quantité impossible à prélever car il en reste ";
      final int quantite;

      quantite = getQuantite();
      if (valeur > quantite) {
         javax.swing.JOptionPane.showMessageDialog(null, valeur + ERR
               + quantite + "\n");
      } else {
         this.sorties += valeur;
         this.nbMvtsSortie++;
      }
   }

   /**
    * Permet de connaître le nombre de sorties
    *
    * @return le nombre de fois où l'on a sorti cet objet.
    */
   public int getNbSorties() {
      return nbMvtsSortie;
   }

   /**
    * Permet de connaître le nombre d'entrées.
    *
    * @return le nombre de fois où l'on a entré cet objet
    */
   public int getNbEntrees() {
      return nbMvtsEntree;
   }

   /**
    * Permet de connaître le montant en stock de l'article.
    *
    * @return le montant
    */
   public float getMontant() {
      return this.getQuantite() * this.prix;
   }

   /**
    * Permet de connaître le montant total des entrées.
    *
    * @return le montant total des entrées.
    */
   public float getMontantEntrees() {
      return this.entrees * this.prix;
   }

   /**
    * Permet de connaître le montant total des sorties.
    *
    * @return le montant total des sorties
    */
   public float getMontantSorties() {
      return this.sorties * this.prix;
   }

   /**
    * Donne une représentation texte de l'article.
    * 
    * @return un texte représentant l'état de l'article en valeur.
    */
   @Override
   public String toString() {
      final String M_CODE = "Code : ";
      final String M_FOUR = " Libellé : ";
      final String M_PRIX = " Prix unitaire : ";
      final String M_QUANT = " Quantité : ";
      final String M_VALEUR = "Valeur en stock : ";

      return M_CODE + this.code + M_FOUR + this.libelle + M_PRIX + this.prix
            + " € " + M_QUANT + this.getQuantite() + "\n" + M_VALEUR
            + this.getMontant() + " €\n";
   }

   /**
    * Donne une représentation texte de l'article.
    * 
    * @param lib
    *           le libellé de l'article
    * @return un texte représentant les entrées/sorties de l'article.
    */
   public String toString(String lib) {
      final String M_ART = "\nArticle : ";
      final String M_ENTREES = " entrée(s)  (";
      final String M_SORTIES = " sortie(s) (";

      return M_ART + this.code + " " + this.libelle + " : "
            + this.getNbEntrees() + M_ENTREES + getMontantEntrees() + "€) + "
            + this.getNbSorties() + M_SORTIES + getMontantSorties() + "€)";
   }

   /**
    * Donne une représentation texte de l'article.
    * 
    * @return un texte donnant les code et libellé de l'article.
    */

   public String codeEtLib() {
      final String M_CODE = "Code : ";
      final String M_LIB = " Libellé : ";

      return M_CODE + this.code + M_LIB + this.libelle + "\n";
   }

}