package Payloads;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UtentePayload(
        @NotBlank(message = "First name is mandatory") String firstName,
        @NotBlank(message = "Last name is mandatory") String lastName,
        @Email(message = "Email should be valid") @NotBlank(message = "Email is mandatory") String email,
        @Size(min = 6, message = "Password should be at least 6 characters long") String password,
        @NotBlank(message = "Username is mandatory") String username
) {
}
