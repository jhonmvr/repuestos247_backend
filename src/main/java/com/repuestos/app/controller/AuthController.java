package com.repuestos.app.controller;

import com.repuestos.app.model.User;
import com.repuestos.app.service.UserService;
import com.repuestos.app.service.dto.AuthRequest;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        // Buscar el usuario por nombre de usuario
        Optional<User> optionalUser = userService.findByUsername(authRequest.getUsername());

        // Si el usuario no existe, retornar UNAUTHORIZED
        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no encontrado");
        }

        User user = optionalUser.get();

        // Verificar la contraseña usando PasswordUtil
        if (!userService.verifyPassword(authRequest.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Contraseña incorrecta");
        }

        // Respuesta exitosa
        return ResponseEntity.ok("Inicio de sesión exitoso");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
        // Verificar si el nombre de usuario ya existe
        if (userService.findByUsername(authRequest.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El nombre de usuario ya está en uso");
        }

        // Verificar si el correo electrónico ya existe
        if (userService.findByUsername(authRequest.getUsername()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("El correo electrónico ya está en uso");
        }

        // Crear un nuevo usuario
        User newUser = new User();
        newUser.setUsername(authRequest.getUsername());
        newUser.setPassword(authRequest.getPassword());
        newUser.setEmail(authRequest.getUsername());
        newUser.setRole("user"); // Rol por defecto

        // Guardar el usuario en la base de datos
        userService.saveUser(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }

}
