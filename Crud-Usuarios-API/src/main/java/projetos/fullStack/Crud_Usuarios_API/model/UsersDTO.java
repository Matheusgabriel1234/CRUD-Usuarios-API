package projetos.fullStack.Crud_Usuarios_API.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record UsersDTO(
        @NotBlank(message = "O seu nome deve estar preenchido") String firstname,
        @NotBlank(message = "O sobrenome deve estar preenchido") String lastName,
        @Past(message = "A data deve estar no passado") @NotBlank(message = "A data de nascimento deve estar com um valor válido")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate birthDate,
        @NotBlank(message = "O email deve estar preenchido") @Email String email,
        @NotBlank(message = "A senha deve estar preenchida") @Size(min = 8,message = "A senha deve ter no minimo 8 valores")
        String password


)

{
}
