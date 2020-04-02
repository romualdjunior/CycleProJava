/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitie.Evenement;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Participants {
    private int id;
    private int user;
    private Date daePart;
    private int event;

    @Override
    public String toString() {
        return "Participants{" + "id=" + id + ", user=" + user + ", daePart=" + daePart + ", event=" + event + '}';
    }

    public Participants(int id, int user, int event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public Participants(int user, int event) {
        this.user = user;
        this.event = event;
    }

    public Participants(int user, Date daePart, int event) {
        this.user = user;
        this.daePart = daePart;
        this.event = event;
    }

    public Participants(int id, int user, Date daePart, int event) {
        this.id = id;
        this.user = user;
        this.daePart = daePart;
        this.event = event;
    }

    public Participants(int id) {
        this.id = id;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public Date getDaePart() {
        return daePart;
    }

    public void setDaePart(Date daePart) {
        this.daePart = daePart;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }
    
    
    
}
