package it.arrp.c3.Model;

import java.util.List;
import java.util.UUID;

public class UtenteRegistrato {
    public UUID uuid;
    public String nome;
    public String email;
    public String password;
    public String citta;
    //public List<Notifica> notifiche;
    public void setPassword(String password) {
        this.password = password;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public UUID getID (){
        return this.uuid;
    }
    public String getNome(){
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }
    public boolean setUuid(UUID i) {
        return false;
    }
    public boolean setNome(String n) {
        return false;
    }
    public boolean setEmail(String s) {
        return false;
    }
    public String getPassword() {
        return this.password;
    }
    public String getCitta() {
        return this.citta;
    }
}
