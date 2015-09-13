package apollo.datastore;

import java.security.MessageDigest;

public class MiscFunctions {

    private MiscFunctions() { }

    public enum HashAlgorithm {
        SHA_256("SHA-256"),
        MD5("MD5");

        private final String name;

        HashAlgorithm(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /**
     * Encrypts a String using the specified HashAlgorithm
     * @param str String to be encrypted, null is converted to empty string ""
     * @param hashAlgorithm hash algorithm to be used for the encryption
     * @return String containing encrypted hash
     */
    public static String getEncryptedHash(String str, HashAlgorithm hashAlgorithm) {
        MessageDigest md;
        StringBuilder sb = new StringBuilder();
        str = (str != null) ? str : "";
        try {
            md = MessageDigest.getInstance(hashAlgorithm.toString());
            md.update(str.getBytes());
            byte byteData[] = md.digest();
            for(Byte byteDatum : byteData)
                sb.append(Integer.toString((byteDatum & 0xff) + 0x100, 16).substring(1));
        }
        catch(Exception e) { // NoSuchAlgorithmException
            return str;
        }
        return sb.toString();
    }
}
