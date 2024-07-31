import java.util.Scanner;

public class Consola {
    private static Scanner sc = new Scanner(System.in);
    public int leerInt(int min, int max) {
        int numero;
        while (true) {
            try {
                numero = sc.nextInt();
                if (numero >= min && numero <= max) {
                    return numero;
                } else {
                    System.out.println("El número ingresado está fuera de rango.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                sc.nextLine();
            }
        }
    }

    public static void saltoLinea() {
        sc.nextLine();
    }

}
