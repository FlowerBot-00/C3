package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereNegozio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta il ruolo di un utente, ovvero un Negozio.
 * Questo ruolo consente di gestire un negozio, con le varie funzionalità che ne
 * derivano, come creare delle corse, assumere un corriere e pubblicizzare un
 * prodotto che si ha in negozio.
 */
@Entity(name = "Negozio")
@Table(name = "negozio")
@DiscriminatorValue("1")
public class Negozio extends Ruolo {

    @Column(name="nomeNegozio")
    private String nomeNegozio;
    @Column(name="cittaNegozio")
    private String cittaNegozio;
    @Column(name="genereNegozio")
    @Enumerated(EnumType.STRING)
    private GenereNegozio genereNegozio;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Prodotto> listaProdottiInEvidenza;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Corriere> listaCorrieriAssunti;

    private static final int max_prodotti = 10;

    public Negozio() {
        super(null);
    }

    /*
    public Negozio(Long idCliente) {
        super(idCliente);
    }
     */

    public Negozio(Long idCliente, String nomeNegozio, String cittaNegozio, GenereNegozio genereNegozio) {
        super(idCliente);
        this.nomeNegozio = nomeNegozio;
        this.cittaNegozio = cittaNegozio;
        this.genereNegozio = genereNegozio;
        this.listaCorrieriAssunti = new ArrayList<>();
        this.listaProdottiInEvidenza = new ArrayList<>();
    }

    //non puo essere null, lo controlla service negozio
    public boolean aggiungiProdotto(Prodotto p){
        if(this.listaProdottiInEvidenza.size() <= max_prodotti && !this.listaProdottiInEvidenza.contains(p)) {
            this.listaProdottiInEvidenza.add(p);
            return true;
        }
        return false;
    }

    //non puo essere null, lo controlla service negozio
    public boolean rimuoviProdotto(Prodotto p){
        return this.listaProdottiInEvidenza.remove(p);
    }

    public List<Corriere> getListaCorrieriAssunti() {
        return listaCorrieriAssunti;
    }

    public void setListaCorrieriAssunti(ArrayList<Corriere> listaCorrieriAssunti) {
        this.listaCorrieriAssunti = listaCorrieriAssunti;
    }

    public void addCorriere(Corriere corriere){
        listaCorrieriAssunti.add(corriere);
    }

    public boolean rimuoviCorriere(Corriere corriere){
        return this.listaCorrieriAssunti.remove(corriere);
    }

    public GenereNegozio getGenereNegozio() {
        return genereNegozio;
    }

    public void setGenereNegozio(GenereNegozio genereNegozio) {
        this.genereNegozio = genereNegozio;
    }

    public String getCittaNegozio() {
        return cittaNegozio;
    }

    public void setCittaNegozio(String cittaNegozio) {
        this.cittaNegozio = cittaNegozio;
    }

    public List<Prodotto> getListaProdottiInEvidenza() {
        return listaProdottiInEvidenza;
    }

    public String getNomeNegozio() {
        return nomeNegozio;
    }

    public void setNomeNegozio(String nomeNegozio) {
        this.nomeNegozio = nomeNegozio;
    }

    @Override
    public String toString() {
        return "Negozio{" +
                "nomeNegozio='" + nomeNegozio + '\'' +
                ", cittaNegozio='" + cittaNegozio + '\'' +
                ", genereNegozio=" + genereNegozio +
                ", idCLiente=" + idCliente +
                '}';
    }

}
