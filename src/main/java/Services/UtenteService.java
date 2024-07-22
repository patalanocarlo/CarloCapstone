package Services;


import Entities.Utente;
import UtenteRepository.UtenteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente createUser(@Valid Utente utente) {
        return utenteRepository.save(utente);
    }

    public List<Utente> getAllUsers() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> getUserById(Long id) {
        return utenteRepository.findById(id);
    }

    public Utente updateUser(Long id, @Valid Utente utente) {
        if (utenteRepository.existsById(id)) {
            utente.setId(id);
            return utenteRepository.save(utente);
        }
        return null;
    }

    public void deleteUser(Long id) {
        utenteRepository.deleteById(id);
    }
}

