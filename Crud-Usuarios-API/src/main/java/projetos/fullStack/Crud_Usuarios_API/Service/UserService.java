package projetos.fullStack.Crud_Usuarios_API.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import projetos.fullStack.Crud_Usuarios_API.mappers.UserMappers;
import projetos.fullStack.Crud_Usuarios_API.model.Users;
import projetos.fullStack.Crud_Usuarios_API.model.UsersDTO;
import projetos.fullStack.Crud_Usuarios_API.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

private final UserRepository repository;
private final UserMappers mappers;

public UsersDTO userRegister(UsersDTO usersDTO){
    Users user = new Users();
    user.setFirstName(usersDTO.firstname());
    user.setLastName(usersDTO.lastName());
    user.setBirthDate(usersDTO.birthDate());
    user.setEmail(usersDTO.email());
    user.setPassword(usersDTO.password());
    Users savedUser = repository.save(user);
    return mappers.convertToDto(savedUser);
}

public UsersDTO findById(String id){
Users user = repository.findById(id).orElseThrow(() -> new RuntimeException("Ocorreu um erro"));
return mappers.convertToDto(user);
}

public UsersDTO findByEmail(String email){
    Users user = repository.findByEmail(email);
    if(user.getEmail() == null){
        throw new RuntimeException("Erro ao encontrar email");
    }
    return mappers.convertToDto(user);
}


public UsersDTO update(String id, UsersDTO userDTO){
    Users user = repository.findById(id).orElseThrow(() -> new RuntimeException("Ocorreu um erro"));
    user.setFirstName(userDTO.firstname());
    user.setLastName(userDTO.lastName());
    user.setBirthDate(userDTO.birthDate());
    user.setEmail(userDTO.email());
    user.setPassword(userDTO.password());

    Users updateUser = repository.save(user);

    return mappers.convertToDto(updateUser);
}

public void deleteUser(String id){
    repository.deleteById(id);
}

}
