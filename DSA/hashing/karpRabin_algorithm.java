package hashing;

public class karpRabin_algorithm {
    // algorithm is useful in finding the target string is the substring of given string
    // works by comparing the hashcode of target and substring
    private final int primeNum = 101;
    public double calculateHashCode(String stringToFindHash){
        double hash = 0;
        for(int i = 0; i<stringToFindHash.length(); i++){
            hash += stringToFindHash.charAt(i) * Math.pow(primeNum, i);
        }
        return hash;
    }

    public double updateHashCode(double prevHash, char prevChar, char nextChar, int patternLength){
        double newHash = (prevHash - prevChar) / primeNum;
        newHash += nextChar * Math.pow(primeNum , patternLength -1);
        return newHash;
    }

    public boolean krapRabinChecker(String text, String pattern){
        int patternLength = pattern.length();
        double patternHash = calculateHashCode(pattern);
        double textHash= calculateHashCode(text.substring(0, patternLength));

        for(int i = 0 ; i <= text.length() - patternLength ; i++) {
            if (patternHash == textHash) {
                if (text.substring(i, patternLength + i).equals(pattern)) return true;
            }

            if(i < text.length() - patternLength) {
                textHash = updateHashCode(textHash, text.charAt(i), text.charAt(i+patternLength), patternLength);
            }
        }
        return false;
    }
}
