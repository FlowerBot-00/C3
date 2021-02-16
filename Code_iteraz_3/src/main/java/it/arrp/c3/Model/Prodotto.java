package it.arrp.c3.Model;

import it.arrp.c3.Model.Enum.GenereProdotto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Prodotto é una classe che gestisce oggetti venduti e promossi dai vari Negozi.
 */
@Entity
public class Prodotto {

    @Id
    @GeneratedValue
    private Long idProdotto;
    private String nome,descrizione;
    private GenereProdotto genereProdotto;

    public Prodotto() {
    }

    public Prodotto(Long idProdotto, String nome, String descrizione, GenereProdotto genereProdotto) {
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.descrizione = descrizione;
        this.genereProdotto = genereProdotto;
    }

    public Long getIdProdotto() {
        return idProdotto;
    }
    public void setIdProdotto(Long idProdotto) {
        this.idProdotto = idProdotto;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public GenereProdotto getGenereProdotto() {
        return genereProdotto;
    }
    public void setGenereProdotto(GenereProdotto genereProdotto) {
        this.genereProdotto = genereProdotto;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "idProdotto=" + idProdotto +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", genereProdotto=" + genereProdotto +
                '}';
    }
}
