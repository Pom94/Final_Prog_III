import miJuego.Personaje;

import java.util.Scanner;

public class Menu {
    private Consola consola = new Consola();

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

        int opcion;
        do{
            mostrarMenu();
            opcion = consola.leerInt(1, 5);
            switch (opcion) {

                case 1:
                    Jugador jugador1 = new Jugador();
                    Jugador jugador2 = new Jugador();

                    PersonajesAleatorios generador = new PersonajesAleatorios();
                    jugador1.getEquipo().addAll(generador.generarEquipoAleatorio());
                    jugador2.getEquipo().addAll(generador.generarEquipoAleatorio());
                    Logger logger = new Logger();
                    //el Logger empieza a grabar la partida
                    logger.comienzoLog();
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
                    //Scanner seguir1 = new Scanner(System.in);
                    System.out.println("Presione enter para continuar...");
                    consola.saltoLinea();

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

                    //Scanner seguir2 = new Scanner(System.in);
                    System.out.println("Presione enter para continuar...");
                    consola.saltoLinea();

                    //iniciar partida
                    Combate combate = new Combate(jugador1.getEquipo(), jugador2.getEquipo());
                    combate.iniciarCombate();

                    //guardar partida
                    logger.finLog();

                    System.out.println("Partida guardada.");


                    //Scanner seguir3 = new Scanner(System.in);
                    System.out.println("Presione enter para continuar...");
                    consola.saltoLinea();
                    System.out.println(" ");






                    break;
                case 2:

                    Jugador jugador1b = new Jugador();

                    Jugador jugador2b = new Jugador();

                    CrearPersonajes crear = new CrearPersonajes();
                    System.out.println("\nEquipo 1: ");
                    jugador1b.getEquipo().addAll(crear.crearEquipo());
                    System.out.println("\nEquipo 2: ");
                    jugador2b.getEquipo().addAll(crear.crearEquipo());

                    Logger logger2 = new Logger();
                    //el Logger empieza a grabar la partida
                    logger2.comienzoLog();
                    System.out.println("---------------------------------------------------");
                    System.out.println("Equipo 1:");
                    System.out.println(" ");
                    for (Personaje personaje : jugador1b.getEquipo()) {
                        System.out.println(personaje.getNombre());
                        System.out.println("Raza: " + personaje.getRaza() + ".  Edad: " + personaje.getEdad() + ".  Salud: " + personaje.getSalud());
                        System.out.println("Nivel: " + personaje.getNivel());
                        System.out.println("Velocidad: " + personaje.getVelocidad() + ".  Destreza: " + personaje.getDestreza());
                        System.out.println("Fuerza: " + personaje.getFuerza() + ".  Armadura:" + personaje.getArmadura());
                        System.out.println(" ");
                    }
                    System.out.println(" ");
                    //Scanner seguir4 = new Scanner(System.in);
                    System.out.println("Presione enter para continuar...");
                    consola.saltoLinea();

                    System.out.println("---------------------------------------------------");
                    System.out.println("Equipo 2:");
                    System.out.println(" ");
                    for (Personaje personaje : jugador2b.getEquipo()) {
                        System.out.println(personaje.getNombre());
                        System.out.println("Raza: " + personaje.getRaza() + ".  Edad: " + personaje.getEdad() + ".  Salud: " + personaje.getSalud());
                        System.out.println("Nivel: " + personaje.getNivel());
                        System.out.println("Velocidad: " + personaje.getVelocidad() + ".  Destreza: " + personaje.getDestreza());
                        System.out.println("Fuerza: " + personaje.getFuerza() + ".  Armadura:" + personaje.getArmadura());
                        System.out.println(" ");
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.println(" ");

                    //Scanner seguir5 = new Scanner(System.in);
                    System.out.println("Presione enter para continuar...");
                    consola.saltoLinea();

                    Combate combate2 = new Combate(jugador1b.getEquipo(), jugador2b.getEquipo());
                    combate2.iniciarCombate();

                    //guardas partida
                    logger2.finLog();

                    System.out.println("Partida guardada.");
                    //Scanner seguir6 = new Scanner(System.in);
                    System.out.println("Presione enter para continuar...");
                    consola.saltoLinea();
                    System.out.println(" ");



                    break;

                case 3:
                    Logger logger3 = new Logger();
                    logger3.listarPartidasYVer();
                    break;

                case 4:
                    Logger logger4 = new Logger();
                    logger4.listarPartidasYBorrar();
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