package com.example.utils;

import java.util.UUID;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for common operations
 * This file contains NO secrets - only helper methods
 */
public class Utils {
    
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * Generate a random UUID
     * @return UUID string
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * Calculate SHA-256 hash of a string
     * @param input The string to hash
     * @return Hex representation of the hash
     */
    public static String calculateSHA256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();
            
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }
    
    /**
     * Get current timestamp in formatted string
     * @return Formatted timestamp
     */
    public static String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        return now.format(formatter);
    }
    
    /**
     * Validate email format
     * @param email Email address to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
    
    /**
     * Sanitize user input to prevent injection attacks
     * @param input User input string
     * @return Sanitized string
     */
    public static String sanitizeInput(String input) {
        if (input == null) {
            return "";
        }
        
        return input
            .replaceAll("<", "&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\"", "&quot;")
            .replaceAll("'", "&#x27;")
            .replaceAll("/", "&#x2F;");
    }
    
    /**
     * Generate a random hex string (for testing purposes)
     * @param length Length of the hex string
     * @return Random hex string
     */
    public static String generateRandomHex(int length) {
        StringBuilder hex = new StringBuilder();
        String characters = "0123456789abcdef";
        
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            hex.append(characters.charAt(index));
        }
        
        return hex.toString();
    }
    
    /**
     * Check if a string is a valid UUID format
     * @param uuid String to check
     * @return true if valid UUID format
     */
    public static boolean isValidUUID(String uuid) {
        if (uuid == null) {
            return false;
        }
        
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
    
    /**
     * Truncate string to specified length
     * @param str String to truncate
     * @param maxLength Maximum length
     * @return Truncated string
     */
    public static String truncate(String str, int maxLength) {
        if (str == null || str.length() <= maxLength) {
            return str;
        }
        
        return str.substring(0, maxLength) + "...";
    }
    
    /**
     * Convert string to title case
     * @param input String to convert
     * @return Title case string
     */
    public static String toTitleCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        
        StringBuilder titleCase = new StringBuilder();
        boolean nextTitleCase = true;
        
        for (char c : input.toCharArray()) {
            if (Character.isSpaceChar(c)) {
                nextTitleCase = true;
            } else if (nextTitleCase) {
                c = Character.toTitleCase(c);
                nextTitleCase = false;
            } else {
                c = Character.toLowerCase(c);
            }
            
            titleCase.append(c);
        }
        
        return titleCase.toString();
    }
    
    /**
     * Check if string contains only alphanumeric characters
     * @param str String to check
     * @return true if alphanumeric only
     */
    public static boolean isAlphanumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        return str.matches("[a-zA-Z0-9]+");
    }
    
    /**
     * Main method for testing utilities
     */
    public static void main(String[] args) {
        System.out.println("Utils Test Suite");
        System.out.println("================");
        
        // Test UUID generation
        String uuid = generateUUID();
        System.out.println("Generated UUID: " + uuid);
        System.out.println("Is valid UUID: " + isValidUUID(uuid));
        
        // Test SHA-256
        String testString = "Hello, World!";
        String hash = calculateSHA256(testString);
        System.out.println("SHA-256 of '" + testString + "': " + hash);
        
        // Test timestamp
        System.out.println("Current timestamp: " + getCurrentTimestamp());
        
        // Test email validation
        System.out.println("Valid email (test@example.com): " + isValidEmail("test@example.com"));
        System.out.println("Invalid email (notanemail): " + isValidEmail("notanemail"));
        
        // Test random hex generation
        System.out.println("Random hex (32 chars): " + generateRandomHex(32));
        
        // Test sanitization
        String maliciousInput = "<script>alert('XSS')</script>";
        System.out.println("Sanitized: " + sanitizeInput(maliciousInput));
        
        // Test title case
        System.out.println("Title case: " + toTitleCase("hello world from java"));
    }
}
