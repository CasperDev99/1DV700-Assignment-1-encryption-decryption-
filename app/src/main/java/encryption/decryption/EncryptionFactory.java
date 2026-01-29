package encryption.decryption;

public class EncryptionFactory {
    
    public Cipher createCipher(EncryptionMethod method) {
        switch (method) {
            case SUBSTITUTION:
                return new Substitutioncipher();
            case TRANSPOSITION:
                return new TranspositionCipher();
            default:
                throw new IllegalArgumentException("Unknown encryption method: " + method);
        }
    }
}