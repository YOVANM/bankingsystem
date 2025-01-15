package com.example.bankingsystem.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Slf4j
public class BankingSystemUtil {

    /**
     * Hashes a password using PBKDF2 with HMAC-SHA256.
     *
     * @param password The password to hash.
     * @param salt     The salt to use for hashing.
     * @return The hashed password in Base64 format.
     */
    public static String hashPassword(String password, String salt) {
        log.info("Starting to hash password using PBKDF2");
        try {
            // Define the PBKDF2 parameters
            int iterations = 65536; // Number of iterations
            int keyLength = 256;    // Length of the hash in bits

            // Create a PBEKeySpec with the provided password and salt
            PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt.getBytes(), iterations, keyLength);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            byte[] hashedBytes = factory.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            log.error("Error while hashing password: {}", password, e);
            throw new RuntimeException("Error while processing password hash");
        }
    }

    /**
     * Generates a random salt for password hashing.
     *
     * @return A random salt value.
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

}
