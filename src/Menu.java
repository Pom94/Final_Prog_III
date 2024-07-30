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
    }

    public void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
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
    }
}