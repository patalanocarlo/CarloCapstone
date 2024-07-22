package Controllers;


import Entities.Utente;
import Payloads.UtentePayload;
import Services.UtenteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/utenti")
@Validated
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    @PostMapping
    public Utente createUser(@Valid @RequestBody UtentePayload utentePayload) {

        Utente utente = new Utente(
                null,
                utentePayload.firstName(),
                utentePayload.lastName(),
                utentePayload.email(),
                utentePayload.password(),
                utentePayload.username()
        );

        return utenteService.createUser(utente);
    }

    @GetMapping
    public List<Utente> getAllUsers() {
        return utenteService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Utente getUserById(@PathVariable Long id) {
        Optional<Utente> utente = utenteService.getUserById(id);
        return utente.orElse(null);
    }

    @PutMapping("/{id}")
    public Utente updateUser(@PathVariable Long id, @Valid @RequestBody UtentePayload utentePayload) {
        // Creare un'istanza di Utente basata sul payload
        Utente utente = new Utente(
                id,
                utentePayload.firstName(),
                utentePayload.lastName(),
                utentePayload.email(),
                utentePayload.password(),
                utentePayload.username()
        );

        return utenteService.updateUser(id, utente);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        utenteService.deleteUser(id);
    }
}
