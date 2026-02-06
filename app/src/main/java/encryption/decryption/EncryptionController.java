package encryption.decryption;

public class EncryptionController {
    
    private FileHandler fileHandler;
    private EncryptionFactory encryptionFactory;
    
    public EncryptionController() {
        this.fileHandler = new FileHandler();
        this.encryptionFactory = new EncryptionFactory();
    }
    
    /**
     * Executes the full encryption/decryption process.
     */
    public void process(EncryptionRequest request) throws Exception {
        String content = fileHandler.readFile(request.getFilename());
        String result = encryptOrDecrypt(content, request);
        String outputFilename = generateOutputFilename(request.getFilename(), request.getMode());
        fileHandler.writeFile(outputFilename, result);
    }

    /**
     * Performs encryption or decryption depending on the request mode.
     */
    private String encryptOrDecrypt(String content, EncryptionRequest request) {
        Cipher cipher = encryptionFactory.createCipher(request.getMethod());
        
        if (request.getMode() == EncryptionMode.ENCRYPT) {
            return cipher.encrypt(content, request.getKey());
        } else {
            return cipher.decrypt(content, request.getKey());
        }
    }
    
    /**
     * Generates the output filename based on the input filename
     * and selected encryption mode.
     */
    private String generateOutputFilename(String inputFilename, EncryptionMode mode) {
        return new FilenameGenerator(inputFilename, mode).generate();
    }
}
