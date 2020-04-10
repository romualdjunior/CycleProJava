/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Commande;

import Entitie.Commande.LignePanier;
import Entitie.Commande.Panier;
import Entitie.User.User;
import GUI.Stock.ShopController2;
import animatefx.animation.FadeInDown;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author toshiba
 */
public class PanierController implements Initializable {

    @FXML
    private TableColumn<Panier, Spinner<Integer>> quantite;

    @FXML
    private TableColumn<Panier, ImageView> image;

    @FXML
    private TableColumn<Panier, String> nom;

    @FXML
    private TableColumn<Panier, Integer> prix;

    @FXML
    private TableColumn<Panier, Button> remove;

    @FXML
    private TableView<Panier> panierView;
    AnchorPane centerContent;
    ObservableList<Panier> panier = FXCollections.observableArrayList();
    @FXML
    private Label subTotal;

    @FXML
    private Label total;
 User user;
 int Total;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void redirection(AnchorPane c, ObservableList<Panier> pa,User u) {
        centerContent = c;
        if (panier.isEmpty()) {
            panier.addAll(pa);
        } else {
            panier.clear();
            panier.addAll(pa);
        }
  user=u;
        nom.setCellValueFactory(new PropertyValueFactory<Panier, String>("nomProduit"));
        image.setCellValueFactory(new PropertyValueFactory<Panier, ImageView>("imageView"));
        quantite.setCellValueFactory(new PropertyValueFactory<Panier, Spinner<Integer>>("spinner"));
        prix.setCellValueFactory(new PropertyValueFactory<Panier, Integer>("prix"));
        remove.setCellValueFactory(new PropertyValueFactory<Panier, Button>("remove"));
        panierView.setItems(panier);
        this.prixTotal();
    }

    @FXML
    void displaySelected(MouseEvent event) {
        Panier selected = panierView.getSelectionModel().getSelectedItem();
        System.out.println(selected);
        selected.setQuantite(selected.getSpinner().getValue());
        selected.getRemove().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Iterator<Panier> it = panier.iterator();
                while (it.hasNext()) {
                    Panier p = it.next();
                    if (p.getIdProduit() == selected.getIdProduit()) {
                        it.remove();
                        panierView.refresh();
                        prixTotal();

                    }
                }
            }
        });

    }

    @FXML
    void displayCatalogue(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Stock/Shop2.fxml"));
        Parent fxml = Loader.load();
        ShopController2 e = Loader.getController();
        e.redirectionFromPanier(centerContent, panier,user);
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);
    }
     @FXML
    void displayAdresse(ActionEvent event) throws IOException {
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/GUI/Commande/Adresse.fxml"));
        Parent fxml = Loader.load();
        AdresseController e = Loader.getController();
        e.redirection(centerContent, panier,user,Total);
        centerContent.getChildren().removeAll();
        new FadeInDown(fxml).play();
        centerContent.getChildren().setAll(fxml);
    }
    

    public void prixTotal() {
        int subtotal = 0, total2 = 850;
        for (Panier panier1 : panier) {
            subtotal += panier1.getQuantite() * panier1.getPrix();
        }
        total2 = total2 + subtotal;
        Total=total2;
        total.setText("$"+Integer.toString(total2));
        subTotal.setText("$"+Integer.toString(subtotal));
    }

}
