/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Reclamation;

import Entitie.User.User;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

/**
 *
 * @author Wiem
 */
@Getter @Setter
@Builder
public class Reclamation {
    private int id;
    private User user;
    private Categorie categorie;
    private String sujet;
    private String description;
    public String getUserName() {
        if (user == null) return "";
        return user.getUsername();
    }
    public String getCategorieName() {
        if (user == null) return "";
        return user.getUsername();
    }
}
