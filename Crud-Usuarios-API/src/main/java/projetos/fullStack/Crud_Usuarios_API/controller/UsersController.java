package projetos.fullStack.Crud_Usuarios_API.controller;


import jakarta.validation.constraints.Past;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projetos.fullStack.Crud_Usuarios_API.Service.UserService;
import projetos.fullStack.Crud_Usuarios_API.model.UsersDTO;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
public class UsersController {


    private static UserService service;



    @PostMapping
    public ResponseEntity<UsersDTO> createUser(@RequestBody UsersDTO user){
        UsersDTO userDto = service.userRegister(user);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersDTO> findByID(@PathVariable String id){
        UsersDTO dto = service.findById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UsersDTO> findByEmail(@RequestParam String email){
        UsersDTO dto = service.findByEmail(email);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersDTO> updateUser(@RequestBody UsersDTO user,@PathVariable String id){
        UsersDTO dto = service.update(id,user);
        return new ResponseEntity<>(dto,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id){
       service.deleteUser(id);
       return ResponseEntity.noContent().build();
    }


}
