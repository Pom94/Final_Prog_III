import miJuego.Personaje;

import java.util.Scanner;

public class Menu {

    // Métodos
    public void mostrarMenu() {
        System.out.println("--------Menú del juego--------");
        System.out.println("-------------------------------");
        System.out.println("1. Iniciar partida rápida");
        System.out.println("2. Iniciar partida manual");
        System.out.println("3. Ver partidas pasadas");
        System.out.println("4. Borrar partidas pasadas");
        System.out.println("5. Salir");
        System.out.println(" ");
        System.out.println(" ");

    }

    public void procesarOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {

                case 1:
                    Jugador jugador1 = new Jugador();
                    Jugador jugador2 = new Jugador();

                    PersonajesAleatorios generador = new PersonajesAleatorios();
                    jugador1.getEquipo().addAll(generador.generarEquipoAleatorio());
                    jugador2.getEquipo().addAll(generador.generarEquipoAleatorio());
                    System.out.println("---------------------------------------------------");
                    System.out.println("Equipo 1:");
                    System.out.println(" ");
                    for (Personaje personaje : jugador1.getEquipo()) {
                        System.out.println(personaje.getNombre());
                        System.out.println("Raza: " + personaje.getRaza() + ".  Edad: " + personaje.getEdad() + ".  Salud: " + personaje.getSalud());
                        System.out.println("Nivel: " + personaje.getNivel());
                        System.out.println("Velocidad: " + personaje.getVelocidad() + ".  Destreza: " + personaje.getDestreza());
                        System.out.println("Fuerza: " + personaje.getFuerza() + ".  Armadura:" + personaje.getArmadura());
                        System.out.println(" ");
                    }
                    System.out.println(" ");
                    Scanner seguir1 = new Scanner(System.in);
                    System.out.println("Presione cualquier tecla para continuar...");
                    seguir1.nextLine();

                    System.out.println("---------------------------------------------------");
                    System.out.println("Equipo 2:");
                    System.out.println(" ");
                    for (Personaje personaje : jugador2.getEquipo()) {
                        System.out.println(personaje.getNombre());
                        System.out.println("Raza: " + personaje.getRaza() + ".  Edad: " + personaje.getEdad() + ".  Salud: " + personaje.getSalud());
                        System.out.println("Nivel: " + personaje.getNivel());
                        System.out.println("Velocidad: " + personaje.getVelocidad() + ".  Destreza: " + personaje.getDestreza());
                        System.out.println("Fuerza: " + personaje.getFuerza() + ".  Armadura:" + personaje.getArmadura());
                        System.out.println(" ");
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.println(" ");

                    Scanner seguir2 = new Scanner(System.in);
                    System.out.println("Presione cualquier tecla para continuar...");
                    seguir2.nextLine();

                    //iniciar partida
                    Combate combate = new Combate(jugador1.getEquipo(), jugador2.getEquipo());
                    combate.iniciarCombate();

                    System.out.println("Guardando partida...");
                    Scanner seguir3 = new Scanner(System.in);
                    System.out.println("Presione cualquier tecla para continuar...");
                    seguir3.nextLine();
                    System.out.println(" ");


                    //guardar partida



                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
}