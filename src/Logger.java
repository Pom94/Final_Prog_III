import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Logger {
    private PrintStream salidaOriginal = System.out;
    private PrintStream archivoSalida;

    public void comienzoLog() {

        String carpeta = "Partidas";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String fechaHora = sdf.format(new Date());
        String nombre = carpeta + File.separator + "partida_" + fechaHora + ".txt";
        try {
            archivoSalida = new PrintStream(nombre);
            System.setOut(new PrintStream(new DualOutputStream(System.out, archivoSalida)));
        } catch (Exception e) {
            System.err.println("Error al iniciar el registro: " + e.getMessage());
        }
    }

    public void finLog() {
        System.setOut(salidaOriginal);
        if (archivoSalida != null) {
            archivoSalida.close();
        }
    }

    public void listarPartidasYVer() {
        File carpetaPartidas = new File("Partidas");
        File[] archivos = carpetaPartidas.listFiles();

        if (archivos != null && archivos.length > 0) {
            System.out.println("Partidas guardadas:");
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(i + 1 + ". " + archivos[i].getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de la partida que desea ver (o 0 para cancelar): ");
            int opcion = scanner.nextInt();

            if (opcion > 0 && opcion <= archivos.length) {
                File archivoSeleccionado = archivos[opcion - 1];
                try {
                    Scanner lector = new Scanner(archivoSeleccionado);
                    while (lector.hasNextLine()) {
                        System.out.println(" ");
                        System.out.println(lector.nextLine());
                        System.out.println(" ");
                    }
                    lector.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Error al abrir el archivo: " + e.getMessage());
                }
            } else if (opcion != 0) {
                System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("No se encontraron partidas guardadas.");
        }
    }

    public void listarPartidasYBorrar() {
        File carpetaPartidas = new File("Partidas");
        File[] archivos = carpetaPartidas.listFiles();

        if (archivos != null && archivos.length > 0) {
            System.out.println("Partidas guardadas:");
            for (int i = 0; i < archivos.length; i++) {
                System.out.println(i + 1 + ". " + archivos[i].getName());
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de la partida que desea borrar (o 0 para cancelar): ");
            int opcion = scanner.nextInt();

            if (opcion > 0 && opcion <= archivos.length) {
                File archivoABorrar = archivos[opcion - 1];
                if (archivoABorrar.delete()) {
                    System.out.println("Partida borrada exitosamente.");
                } else {
                    System.out.println("Error al borrar la partida.");
                }
            } else if (opcion != 0) {
                System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("No se encontraron partidas guardadas.");
        }
    }

    private static class DualOutputStream extends OutputStream {
        private PrintStream salida1;
        private PrintStream salida2;

        public DualOutputStream(PrintStream salida1, PrintStream salida2) {
            this.salida1 = salida1;
            this.salida2 = salida2;
        }

        public void write(int b) {
            salida1.write(b);
            salida2.write(b);
        }

    }
}