package com.repuestos.app.service;
import com.repuestos.app.model.User;
import com.repuestos.app.repository.UsersRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    private final UsersRepository UsersRepository;

    public UserService(UsersRepository UsersRepository) {
        this.UsersRepository = UsersRepository;
    }

    public Optional<User> findByUsername(String username) {
        return UsersRepository.findByUsername(username);
    }

    public User saveUser(User user) {
        // Encripta la contraseña usando PasswordUtil
        user.setPassword(PasswordUtil.hashPassword(user.getPassword()));
        return UsersRepository.save(user);
    }

    public boolean verifyPassword(String plainPassword, String hashedPassword) {
        return PasswordUtil.verifyPassword(plainPassword, hashedPassword);
    }
}
