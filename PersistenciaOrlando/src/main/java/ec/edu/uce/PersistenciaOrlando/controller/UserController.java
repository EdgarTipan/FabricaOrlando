package ec.edu.uce.PersistenciaOrlando.controller;

import ec.edu.uce.PersistenciaOrlando.model.Material;
import ec.edu.uce.PersistenciaOrlando.model.User;
import ec.edu.uce.PersistenciaOrlando.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/name/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @GetMapping("/{username}/id")
    public ResponseEntity<Long> getUserIdByUsername(@PathVariable String username) {
        User user = userService.findByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user.getId());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            return ResponseEntity.badRequest()
                    .body("Llene todos los campos primero");
        }

        User savedUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Registro exitoso. ¡Bienvenido!");
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllMaterials() {
        List<User> materials = userService.findAll();
        return ResponseEntity.ok(materials);
    }
}
