package Test;

import Entitie.Commande.Adresse;
import Entitie.Commande.Commande;
import Entitie.Commande.LignePanier;
import Entitie.Commande.Payment;
import Entitie.Produit.Velo;
import Service.Commande.ServiceAdresse;
import Service.Commande.ServiceCommande;
import Service.Commande.ServiceLignePanier;
import Service.Commande.ServicePayment;
import Service.Produit.ServiceProduit;
import Service.User.UserService;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Test.SendEmail;

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

    public static void menu(int menuIndex, Scanner scanner, List<LignePanier> lignePaniers) throws SQLException {
        String login;
        String password;
        UserService userService = new UserService();
        switch (menuIndex) {
            case 1:
                System.out.println("Entrez votre login");
                login = scanner.next();
                System.out.println("Entrez votre mot de passe");
                password = scanner.next();
                if (userService.connexion(login, password) != -1) {
                    System.out.println("BIENVENUE ADMINISTRATEUR " + login);
                    ServiceCommande sc = new ServiceCommande();
                    sc.readAll();
                    System.out.println("entrer l'idee de la commande que vous voulez annuler");
                    int id = scanner.nextInt();
                    sc.delete(id);
                    sc.readAll();
                    System.out.println("entrer un champ pour la recherche trie");
                    String champ=scanner.next();
                    sc.readAll2(champ);

                } else {
                    System.out.println("identifiants invalides");
                }
                break;
            case 2:
                do {
                    System.out.println("ci-joint la liste des produits");
                    ServiceProduit serviceProduit = new ServiceProduit();
                    serviceProduit.readAll().stream().forEach(s -> System.out.println(s.toString()));
                    System.out.println("1-ajouter un produit au panier");
                    System.out.println("2-consutler le panier");
                    System.out.println("0-quitter");
                    menuIndex = scanner.nextInt();
                    menu2(menuIndex, scanner, serviceProduit.readAll(), lignePaniers);
                } while (menuIndex != 0);
                break;
            default:
                menu(menuIndex, scanner, lignePaniers);
                break;
        }

    }

    public static void menu2(int menuIndex, Scanner scanner, List<Velo> list, List<LignePanier> lignePaniers) throws SQLException {
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
                System.out.println("Produit ajouté au panier");
                break;
            case 2:
                do {
                    lignePaniers.stream().forEach(s -> System.out.println(s.toString()));
                    System.out.println("1-modifier la quantite d'un produit");
                    System.out.println("2-Supprimer un produit du panier");
                    System.out.println("3-Procéder à la commande");
                    System.out.println("0-Precedent");
                    menuIndex = scanner.nextInt();
                    menu3(menuIndex, scanner, lignePaniers, list);
                } while (menuIndex != 0);

                break;
            default:
        }

    }

    public static void menu3(int menuIndex, Scanner scanner, List<LignePanier> lignePaniers, List<Velo> Velos) throws SQLException {
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
                        if (v.getId() == idProduit && v.getQtEnStock() > quantite) {
                            for (LignePanier l : lignePaniers) {
                                if (l.get$idProduit() == idProduit) {
                                    l.set$quantite(quantite);
                                    System.out.println("produit modifié dans le panier");
                                    bool = true;

                                }
                            }
                        }
                    }
                    if (bool == false) {
                        System.out.println("la quantite doit etre inferieures a celle dans le stock");
                    }

                } while (bool == false);

                break;
            case 2:
                System.out.println("entrer l'identifiant du velo");
                idProduit = scanner.nextInt();
                Iterator<LignePanier> it = lignePaniers.iterator();

                while (it.hasNext()) {
                    LignePanier l = it.next();
                    if (l.get$idProduit() == idProduit) {
                        it.remove();
                    }
                }
                System.out.println("Produit supprimé du panier");
                break;
            case 3:
                UserService userService = new UserService();
                String login,
                 password;
                int idUser;
                do {
                    System.out.println("Entrez votre login");
                    login = scanner.next();
                    System.out.println("Entrez votre mot de passe");
                    password = scanner.next();
                    idUser = userService.connexion(login, password);

                    if (idUser != -1) {
                        System.out.println("Utilisateur connecté");
                        System.out.println("Remplissage de l'adresse");
                        System.out.println("entrer votre nom");
                        String nom = scanner.next();
                        System.out.println("entrer votre prenom");
                        String prenom = scanner.next();
                        System.out.println("entrer votre numero de telephone");
                        int tel = scanner.nextInt();
                        System.out.println("entrer votre email");
                        String email = scanner.next();
                        System.out.println("entrer votre pays");
                        String pays = scanner.next();
                        System.out.println("entrer votre ville");
                        String ville = scanner.next();
                        System.out.println("entrer votre etat");
                        String etat = scanner.next();
                        System.out.println("entrer votre pincode");
                        int pincode = scanner.nextInt();
                        System.out.println("entrer votre adresseLivraison");
                        String addresseLivraison = scanner.next();
                        Adresse a = new Adresse(nom, prenom, tel, email, pays, ville, etat, pincode, addresseLivraison);
                        ServiceAdresse s = new ServiceAdresse();
                        s.ajouter(a);
                        System.out.println("adresse de livraison ajoutée");
                        System.out.println("/n");
                        int total = 0;
                        for (LignePanier l : lignePaniers) {
                            for (Velo Velo1 : Velos) {
                                if (l.get$idProduit() == Velo1.getId()) {
                                    total += l.get$quantite() * Velo1.getPrixAchat();
                                }
                            }
                        }
                        Date date = Calendar.getInstance().getTime();
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        String dateString = dateFormat.format(date);
                        Commande c = new Commande(total, "non paye", dateString, idUser, s.getLastAdresse());
                        ServiceCommande sc = new ServiceCommande();
                        sc.ajouter(c);
                        ServiceLignePanier sl = new ServiceLignePanier();
                        for (LignePanier l : lignePaniers) {
                            l.setIdCommande(sc.getLastCommande());
                            sl.ajouter(l);
                        }
                        SendEmail sm;
                        sm = new SendEmail("romuald.motchehokamguia@esprit.tn", "validation de commande", "votre commande chez cyclepro a été validée avec "
                + "success");
                        System.out.println("1-Proceder au paiement ");
                        System.out.println("2-Payer à la livraison");
                        menuIndex = scanner.nextInt();
                        menu5(menuIndex, scanner);
                    } else {
                        System.out.println("identifiants invalides");
                    }
                } while (idUser == -1);

                break;
            default:

                break;

        }

    }

    public static void menu4(int menuIndex, Scanner scanner, List<LignePanier> lignePaniers, List<Velo> Velos) {
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
                        if (v.getId() == idProduit && v.getQtEnStock() > quantite) {
                            for (LignePanier l : lignePaniers) {
                                if (l.get$idProduit() == idProduit) {
                                    l.set$quantite(quantite);
                                    System.out.println("produit modifié dans le panier");
                                    bool = true;

                                }
                            }
                        }
                    }
                    if (bool == false) {
                        System.out.println("la quantite doit etre inferieures a celle dans le stock");
                    }

                } while (bool == false);

                break;
            case 2:
                System.out.println("entrer l'identifiant du velo");
                idProduit = scanner.nextInt();
                Iterator<LignePanier> it = lignePaniers.iterator();

                while (it.hasNext()) {
                    LignePanier l = it.next();
                    if (l.get$idProduit() == idProduit) {
                        it.remove();
                    }
                }
                System.out.println("Produit supprimé du panier");
                break;
            default:

        }

    }

    public static void menu6(int menuIndex, Scanner scanner) throws SQLException {
        switch (menuIndex) {
            case 1:
                System.out.println("Entrer l'id du produit panier");
                int id = scanner.nextInt();
                ServiceLignePanier sl = new ServiceLignePanier();
                sl.delete(id);
                ServiceCommande sc = new ServiceCommande();
                sc.historique();
                break;
            case 0:

                break;
            default:

        }

    }

    public static void menu5(int menuIndex, Scanner scanner) throws SQLException {
        switch (menuIndex) {
            case 1:
                System.out.println("Entrer votre nom de carte");
                String cardHolderName = scanner.next();
                System.out.println("Entrer votre numero de carte");
                int cardNumber = scanner.nextInt();
                System.out.println("Entrer votre numero de securité");
                int securityCode = scanner.nextInt();
                System.out.println("Entrer votre moi d'Expiration");
                int moiExpiration = scanner.nextInt();
                System.out.println("Entrer votre annee d'Expiration");
                int anneeExpiration = scanner.nextInt();

                ServiceCommande s = new ServiceCommande();
                Payment paiement = new Payment(cardHolderName, cardNumber, securityCode, moiExpiration, anneeExpiration, s.getLastCommande());
                ServicePayment sp = new ServicePayment();
                sp.ajouter(paiement);
                s.update(s.getLastCommande());
                System.out.println("Votre historique des commandes ");
                s.historique();
                System.out.println("1-Supprimer un produit de la commande?");
                System.out.println("0-non");
                System.out.println("Entrer l'id du produitdans la commande ");
                int idLignePanier=scanner.nextInt();
                ServiceLignePanier sl=new ServiceLignePanier();
                sl.delete(idLignePanier);
                System.out.println("produit supprimee");
                s.historique();
                break;
            case 2:
                System.out.println("Votre historique des commandes ");
                ServiceCommande s2 = new ServiceCommande();
                s2.historique();
                System.out.println("1-Supprimer un produit de la commande?");
                System.out.println("0-non");

                break;
            default:
                break;
        }
    }

    public static void main(String[] args) throws SQLException {
        int menuIndex;
        Scanner scanner = new Scanner(System.in);
        List<LignePanier> lignePaniers = new ArrayList();
        System.out.println("#BIENVENUE CHEZ CYCLEPRO#");
        System.out.println("Choisissez une action");
        System.out.println("Connectez vous svp?");
        System.out.println("1-Admin");
        System.out.println("2-Client");
        menuIndex = scanner.nextInt();
        menu(menuIndex, scanner, lignePaniers);

    }
}
