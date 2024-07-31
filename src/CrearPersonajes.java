import miJuego.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import miJuego.Personaje.Raza;

public class CrearPersonajes {
    private Consola consola = new Consola();

    public List<Personaje> crearEquipo(){
        List<Personaje> equipo = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++){
            System.out.println("Elegir raza (Humano, Orco o Elfo):");
            Raza raza;
            while (true) {
                try {
                    raza = Raza.valueOf(sc.nextLine().toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Raza inválida. Por favor, ingresa una raza válida (Humano, Orco o Elfo):");
                }
            }

            System.out.println("Nombre?: ");
            String nombre = sc.nextLine();

            System.out.println("Edad?: ");
            int edad = consola.leerInt(1, 300);
            sc.nextLine();

            float salud = 300;

            System.out.println("Velocidad?: ");
            int velocidad = consola.leerInt(1, 10);
            sc.nextLine();

            System.out.println("Destreza?: ");
            int destreza = consola.leerInt(1, 5);
            sc.nextLine();

            System.out.println("Fuerza?: ");
            int fuerza = sc.nextInt();
            sc.nextLine();

            System.out.println("Armadura?: ");
            int armadura = consola.leerInt(1, 10);
            sc.nextLine();

            System.out.println("Nivel?: ");
            int nivel = consola.leerInt(1, 10);
            sc.nextLine();

            Personaje personaje;
            switch (raza) {
                case HUMANO:
                    personaje = new Humano(raza, nombre, edad, salud, velocidad, destreza, fuerza, armadura, nivel);
                    break;
                case ORCO:
                    personaje = new Orco(raza, nombre, edad, salud, velocidad, destreza, fuerza, armadura, nivel);
                    break;
                case ELFO:
                    personaje = new Elfo(raza, nombre, edad, salud, velocidad, destreza, fuerza, armadura, nivel);
                    break;
                default:
                    throw new IllegalArgumentException("Raza no válida");
            }

            equipo.add(personaje);

        }

        return equipo;
    }
}
