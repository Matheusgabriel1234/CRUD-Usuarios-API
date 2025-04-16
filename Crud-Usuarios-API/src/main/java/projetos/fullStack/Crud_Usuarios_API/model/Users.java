package projetos.fullStack.Crud_Usuarios_API.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@RequiredArgsConstructor
@Getter
@Setter
@Document(collection = "Users")
public class Users {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;

}
