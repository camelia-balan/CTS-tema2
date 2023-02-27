package ro.ase.cts.s02.src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    /**
     * Aceasta metoda calculeaza suma dintre x ridicat la puterea a-5a si y ridicat la putearea a-7a.
     * @return Returneaza rezultatul calculat.
     * @throws IOException Arunca exceptie daca datele introduse nu au formatul corect.
     */

    public double power(double base, int exponent) {
        double result = base;
        for(int i=1; i<exponent; i++) {
            result *= base;
        }
        return result;
    }

    // Tema: in cazul valorilor non numerice => reia procesul de citire
    public double calculateXPower5PlusYPower7() throws IOException, NumberFormatException {
        double result = 0.0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean success = false;
        System.out.println("Tastati valoarea pentru X:");
        double x = 0.0;
        while(!success) {
            try {
                x = Double.parseDouble(reader.readLine());
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Retestati valoarea pentru X:");
            }
        }

        success = false;
        System.out.println("Tastati valoarea pentru Y:");
        double y = 0.0;
        while(!success) {
            try {
                y = Double.parseDouble(reader.readLine());
                success = true;
            } catch (NumberFormatException e) {
                System.out.println("Retestati valoarea pentru Y:");
            }
        }

        double x5 = power(x, 5);
        double y7 = power(y, 7);

        result = x5 + y7;
        return result;
    }
}