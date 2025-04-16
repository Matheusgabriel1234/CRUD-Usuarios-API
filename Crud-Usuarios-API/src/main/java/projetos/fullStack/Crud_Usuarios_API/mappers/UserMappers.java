package projetos.fullStack.Crud_Usuarios_API.mappers;

import org.apache.catalina.User;
import projetos.fullStack.Crud_Usuarios_API.model.Users;
import projetos.fullStack.Crud_Usuarios_API.model.UsersDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserMappers {


public UsersDTO convertToDto(Users user){
    return new UsersDTO(
       user.getFirstName(),
       user.getLastName(),
       user.getBirthDate(),
       user.getEmail(),
       user.getPassword()
    );
}

public Users convertToEntity(UsersDTO dto){
    Users user = new Users();
    user.setFirstName(dto.firstname());
    user.setLastName(dto.lastName());
    user.setBirthDate(dto.birthDate());
    user.setEmail(dto.email());
    user.setPassword(dto.password());
    return user;
}
}
