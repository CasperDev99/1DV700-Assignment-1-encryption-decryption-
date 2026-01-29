package encryption.decryption;

import java.util.Scanner;

public class UserInterface {
    
 private Scanner scanner;
    private InputValidator validator;
    private EncryptionController controller;
    
    public UserInterface() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
        this.controller = new EncryptionController();
    }
    
    
      void run() {
        try {
            EncryptionRequest request = getUserRequest();
            controller.process(request);
            showSuccessMessage(request);
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private EncryptionRequest getUserRequest() {
        EncryptionMode mode = getEncryptionMode();
        EncryptionMethod method = getEncryptionMethod();
        String key = getSecretKey();
        String filename = getFilename();
        
        return new EncryptionRequest(mode, method, key, filename);
    }
    
    private EncryptionMode getEncryptionMode() {
        while (true) {
            print("Do you want to encrypt (E) or decrypt (D)? ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (validator.isValidMode(input)) {
                return EncryptionMode.fromString(input);
            }
            
            showErrorMessage("Invalid choice. Please enter E or D.");
        }
    }
    
    private EncryptionMethod getEncryptionMethod() {
        while (true) {
            print("Do you want to use substitution (S) or transposition (T)? ");
            String input = scanner.nextLine().trim().toUpperCase();
            
            if (validator.isValidMethod(input)) {
                return EncryptionMethod.fromString(input);
            }
            
            showErrorMessage("Invalid choice. Please enter S or T.");
        }
    }
    
    private String getSecretKey() {
        print("Input the secret key: ");
        return scanner.nextLine().trim();
    }
    
    private String getFilename() {
        while (true) {
            print("Input the name of the file you want to process: ");
            String filename = scanner.nextLine().trim();
            
            if (validator.isValidFilename(filename)) {
                return filename;
            }
            
            showErrorMessage("Invalid filename.");
        }
    }
    
    private void showSuccessMessage(EncryptionRequest request) {
        String action = request.getMode() == EncryptionMode.ENCRYPT ? "encrypted" : "decrypted";
        String outputFile = generateOutputFilename(request.getFilename(), request.getMode());
        println("The file has been " + action + " and the results have been saved in the file " + outputFile);
    }

    private String generateOutputFilename(String inputFilename, EncryptionMode mode) {
        return new FilenameGenerator(inputFilename, mode).generate();
    }

    private void showErrorMessage(String message) {
        System.err.println("Error: " + message);
    }

    private void print(String text) {
        System.out.print(text);
    }
    
    private void println(String text) {
        System.out.println(text);
    }
}
