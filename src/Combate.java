import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import miJuego.Personaje;

public class Combate {
    private List<Personaje> equipo1;
    private List<Personaje> equipo2;
    private Random random = new Random();

    public Combate(List<Personaje> equipo1, List<Personaje> equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public void iniciarCombate() {
        boolean turnoEquipo1 = random.nextBoolean(); //sortear cual empieza
        int ronda = 1;
        while (!equipo1.isEmpty() && !equipo2.isEmpty()) {

            System.out.println("Ronda nro: " + ronda);
            System.out.println("---------------------------------------------------");

            Personaje personaje1 = seleccionarPersonajeAleatorio(equipo1);
            Personaje personaje2 = seleccionarPersonajeAleatorio(equipo2);

            if (turnoEquipo1 = true){
                System.out.println(personaje1.getNombre() + " vs " + personaje2.getNombre());

                System.out.println("Empieza Equipo 1.");
                Scanner seguir1 = new Scanner(System.in);
                System.out.println("Presione cualquier tecla para continuar...");
                seguir1.nextLine();
            }
            else {
                System.out.println("Empieza Equipo 2.");
                System.out.println(personaje2.getNombre() + " vs " + personaje1.getNombre());
                Scanner seguir1 = new Scanner(System.in);
                System.out.println("Presione cualquier tecla para continuar...");
                seguir1.nextLine();
            }
            System.out.println(" ");
            System.out.println(" ");

            while (!equipo1.isEmpty() && !equipo2.isEmpty()) {
                Personaje atacante, defensor;
                if (turnoEquipo1) {
                    atacante = personaje1;
                    defensor = personaje2;
                } else {
                    atacante = personaje2;
                    defensor = personaje1;
                }

                realizarAtaque(atacante, defensor);

                // si un personaje muere, eliminamos y terminamos la ronda
                if (!defensor.estaVivo()) {
                    if (turnoEquipo1) {
                        equipo2.remove(defensor);
                    } else {
                        equipo1.remove(defensor);
                    }
                    break; // terminamos la ronda actual
                }
                turnoEquipo1 = !turnoEquipo1; // cambiamos de turno para el próximo enfrentamiento

            }

            System.out.println("---------------------------------------------------");
            turnoEquipo1 = !turnoEquipo1; // cambiamos de turno para la siguiente ronda
            ronda++;
        }

        if (equipo1.isEmpty()) {
            System.out.println("¡El equipo 2 ha ganado!");
            System.out.println(" ");
        } else {
            System.out.println("¡El equipo 1 ha ganado!");
        }
    }

    private Personaje seleccionarPersonajeAleatorio(List<Personaje> equipo) {
        return equipo.get(random.nextInt(equipo.size()));
    }

    private void realizarAtaque(Personaje atacante, Personaje defensor) {
        Scanner sc = new Scanner(System.in);
        float danio = atacante.danioProvocado(defensor);
        defensor.recibirDanio(danio);
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " y le inflige " + danio + " de daño. Le queda " + defensor.getSalud() + " de salud.");
        System.out.println(" ");
        if (!defensor.estaVivo()) {
            System.out.println(defensor.getNombre() + " ha muerto.");
            System.out.println(" ");
            atacante.bonificacion();
            System.out.println(atacante.getNombre() + " recibe bonificación de  30 puntos de salud y sube un nivel.");
            System.out.println("Salud: " + atacante.getSalud());
            System.out.println("Nivel: " + atacante.getNivel());
            System.out.println("");
            System.out.println("Presione cualquier tecla para continuar...");
            sc.nextLine();

            return;
        }
    }
}