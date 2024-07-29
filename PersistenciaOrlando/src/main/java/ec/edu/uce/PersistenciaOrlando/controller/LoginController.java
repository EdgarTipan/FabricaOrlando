package ec.edu.uce.PersistenciaOrlando.controller;

import ec.edu.uce.PersistenciaOrlando.model.User;
import ec.edu.uce.PersistenciaOrlando.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User userRequest) {
        if (userRequest == null || userRequest.getUsername() == null || userRequest.getPassword() == null) {
            return ResponseEntity.badRequest().body("Credenciales invalidas");
        }

        User user = userService.findByUsername(userRequest.getUsername());
        if (user != null && user.getPassword().equals(userRequest.getPassword())) {
            return ResponseEntity.ok("Inicio de sesion exitoso. ¡Bienvenido!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nombre de usuario y/o contraseña incorrectos");
        }
    }
}
