public class VigenereCipher {
    private String key;
    private String alphabet;
    private char shiftLetter(char letter, int shifts) {
        char newLetter;

        if ((letter <= 90 && letter >= 65)) {
            int temp = (char) (((int) letter - 65 + shifts + (26 * 10)) % 26);
            newLetter = (char) (temp + 'a');
        } else if ((letter <= 122 && letter >= 97)) {
            int temp = (((int) letter - 97 + shifts + (26 * 10)) % 26);
            newLetter = (char) (temp + 'a');
        } else {
            newLetter = letter;
        }
        return newLetter;
    }
    public VigenereCipher(String key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }
    public String getKey() {
        return key;
    }
    public String getAlphabet() {
        return alphabet;
    }
    public String encode(String txt) {
        int keyIndex = 0;
        String encodedStr = "";
        for (int i = 0; i < txt.length(); ++i) {
            encodedStr += shiftLetter(txt.charAt(i), key.charAt(keyIndex % key.length()) - 97);
            keyIndex++;
        }
        return encodedStr.toLowerCase();
    }
    public String decode(String txt) {
        int keyIndex = 0;
        String decodedStr = "";
        for (int i = 0; i < txt.length(); ++i) {
            decodedStr += shiftLetter(txt.charAt(i), -1 * (key.charAt(keyIndex % key.length()) - 97));
            keyIndex++;
        }
        return decodedStr.toLowerCase();
    }
}
