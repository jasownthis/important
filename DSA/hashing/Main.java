package hashing;

public class Main {
    public static void main(String[] args) {
        karpRabin_algorithm algo = new karpRabin_algorithm();
        if(algo.krapRabinChecker("helloMakkaleVanakam", "Makkale")) System.out.println("Pattern found");
        else System.out.println("Pattern not found");
    }
}
