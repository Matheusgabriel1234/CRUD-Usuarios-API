package projetos.fullStack.Crud_Usuarios_API.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import projetos.fullStack.Crud_Usuarios_API.model.Users;

public interface UserRepository extends MongoRepository<Users, String> {
    boolean existsByEmail(String email);
    Users findByEmail(String email);

}
