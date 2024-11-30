package Mathematic_in_DSA;
import java.math.BigInteger;
public class catalan_Number {
    // Method to compute the nth Catalan number
    public static BigInteger catalan(int n) {
        // Using BigInteger to handle large numbers
        BigInteger numerator = factorial(2 * n);
        BigInteger denominator = factorial(n + 1).multiply(factorial(n));
        return numerator.divide(denominator);
    }

    // Method to compute factorial of a number
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        // Display first 30 Catalan numbers
        for (int i = 0; i < 30; i++) {
            System.out.println("C(" + i + ") = " + catalan(i));
        }
    }
}
