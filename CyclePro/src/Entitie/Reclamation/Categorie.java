/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Reclamation;

import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

/**
 *
 * @author Wiem
 */
@Getter @Setter
@Builder
public class Categorie {
    private int id;
    private String label;
    private String description;
}
