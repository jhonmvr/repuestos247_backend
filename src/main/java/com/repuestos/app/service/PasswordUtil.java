package com.repuestos.app.service;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {

    // Generar hash de contraseña
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Verificar contraseña
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
