package Test;

import Entitie.Commande.LignePanier;
import Entitie.Produit.Velo;
import Service.Produit.ServiceProduit;
import Service.User.UserService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author toshiba
 */
public class TestCommande {

    public static void menu(int menuIndex, Scanner scanner) throws SQLException {
        String login;
        String password;
        UserService userService = new UserService();
        do {
            switch (menuIndex) {
                case 1:
                    System.out.println("Entrez votre login");
                    login = scanner.next();
                    System.out.println("Entrez votre mot de passe");
                    password = scanner.next();
                    if (userService.connexion(login, password)) {
                        System.out.println("BIENVENUE ADMINISTRATEUR " + login);

                    } else {
                        System.out.println("identifiants invalides");
                    }
                    break;
                case 2:
                    System.out.println("ci-joint la liste des produits");
                    ServiceProduit serviceProduit = new ServiceProduit();
                    serviceProduit.readAll().stream().forEach(s -> System.out.println(s.toString()));
                    System.out.println("1-ajouter un produit au panier");
                    System.out.println("2-consutler le panier");
                    menuIndex=scanner.nextInt();
                    menu2(menuIndex,scanner,serviceProduit.readAll());

                    break;
                default:
                    menu(menuIndex, scanner);
            }
        } while (menuIndex != 0);

    }

    public static void menu2(int menuIndex, Scanner scanner, List<Velo> list) {
        List<LignePanier> lignePaniers = new ArrayList();;
        int idProduit, quantite, quantiteStock;
            switch (menuIndex) {
                case 1:
                    System.out.println("entrer l'identifiant du velo");
                    idProduit = scanner.nextInt();
                    boolean bool = false;
                    do {
                        System.out.println("entrer la quantite");
                        quantite = scanner.nextInt();
                        for (Velo velo : list) {
                            if (velo.getId() == idProduit) {
                                if (velo.getQtEnStock() > quantite) {
                                    quantiteStock = velo.getQtEnStock();
                                    bool = true;
                                }
                            }
                        }
                        if (bool == false) {
                            System.out.println("la quantite doit etre inferieures a celle dans le stock");
                        }

                    } while (bool == false);
                    lignePaniers.add(new LignePanier(quantite, 0, idProduit));
                    System.out.println("Produit ajouté");
                    break;
                case 2:
                    lignePaniers.stream().forEach(s -> System.out.println(s.toString()));
                    System.out.println("1-modifier la quantite d'un produit");
                    System.out.println("2-Supprimer un produit du panier");
                    menuIndex=scanner.nextInt();
                    menu3(menuIndex,scanner,lignePaniers,list);
                    break;
                default:
                    menu2(menuIndex, scanner, list);
            }

    }

    public static void menu3(int menuIndex, Scanner scanner, List<LignePanier> lignePaniers,List<Velo>Velos) {
        int idProduit, quantite;
        switch (menuIndex) {
            case 1:
                System.out.println("entrer l'identifiant du velo");
                idProduit = scanner.nextInt();
                boolean bool = false;
                do {
                    System.out.println("entrer la nouvelle quantite");
                    quantite = scanner.nextInt();
                    for (Velo v : Velos) {
                        if (v.getId() == idProduit && v.getQtEnStock()>quantite) {
                            bool=true;
                        }
                    }
                    if (bool == false) {
                        System.out.println("la quantite doit etre inferieures a celle dans le stock");
                    }

                } while (bool == false);
                lignePaniers.add(new LignePanier(quantite, 0, idProduit));
                System.out.println("produit modifié dans le panier");
                break;
            case 2:
                   System.out.println("entrer l'identifiant du velo");
                idProduit = scanner.nextInt();
                for (LignePanier l : lignePaniers) {
                    if (l.get$idProduit() == idProduit) {
                        lignePaniers.remove(l);
                    }
                }
                System.out.println("Produit supprimé du panier");
                break;
            default:
               
        }

    }

    public static void main(String[] args) throws SQLException {
        int menuIndex;
        Scanner scanner = new Scanner(System.in);
        System.out.println("#BIENVENUE CHEZ CYCLEPRO#");
        System.out.println("Choisissez une action");
        System.out.println("Connectz vous svp?");
        System.out.println("1-Admin");
        System.out.println("2-Client");
        menuIndex = scanner.nextInt();
        menu(menuIndex, scanner);

    }
}
