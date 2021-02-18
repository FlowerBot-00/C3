package it.arrp.c3.Service;

import it.arrp.c3.Model.Box;
import it.arrp.c3.Model.Cliente;
import it.arrp.c3.Model.Enum.GenereNegozio;
import it.arrp.c3.Model.Locker;
import it.arrp.c3.Model.Repository.BoxRepository;
import it.arrp.c3.Model.Repository.ClienteRepository;
import it.arrp.c3.Model.Repository.LockerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe che si occupa di effettuare le operazioni riguardanti la classe Cliente.
 */
@Service
public class ServiceCliente {

    @Autowired
    ClienteRepository repoCliente;
    @Autowired
    BoxRepository repoBox;
    @Autowired
    LockerRepository repoLocker;
    @Autowired
    ServiceLocker serviceLocker;

    public boolean setCheckpoint(Long idCliente, Long idLocker){
        Locker locker = repoLocker.findOneById(idLocker);
        if(locker == null)
            return false;
        Cliente cliente = repoCliente.findOneById(idCliente);
        cliente.setCheckpoint(locker);
        return true;
    }

    /**
     * Inserisce nella lista Box di un cliente il Box assegnato per una corsa.
     * @param boxAssegnato Box da inserire.
     */
    public void assegnamentoBox(Long idCliente, Box boxAssegnato){
        Cliente c = repoCliente.findOneById(idCliente);
        if(!(c == null)){
            c.addBox(boxAssegnato);
        }
    }

    public List<Box> getBoxCliente(Long uuidCliente) {
        return repoCliente.getOne(uuidCliente).getBoxAssegnati();
    }

    public Cliente getCliente(Long id) {
        return repoCliente.findOneById(id);
    }

    /**
     * Apre il box che appartiene al cliente dato.
     * @param idCliente .
     * @param idBox .
     * @return NULL se il cliente o box non esiste, o il box non è presente nella sua lista.
     */
    public Box apriBox(Long idCliente, Long idBox){
        Cliente c = getCliente(idCliente);
        if(c == null)
            return null;
        Box b = repoBox.findOneById(idBox);
        if(b == null)
            return null;
        if(c.getBoxAssegnati().contains(b)){
            for (Box box : c.getBoxAssegnati()) {
                b = box;
                if (b.getId().equals(idBox)) {
                    b.unlock();
                    return b;
                }
            }
        }
        return null;
    }

    public boolean registrazione(String nome, String email, String pass, String citta) {
        //TODO
        return false;
    }

    public void aggiungiRuoloCorriere(Long idCliente, String mdt) {
        //TODO
    }

    public void aggiungiRuoloNegozio(Long idCliente, String cittaNegozio, GenereNegozio genere) {
        //TODO
    }

    public boolean creaTicket(Long idCliente, String testo) {
        //TODO
        return false;
    }
}