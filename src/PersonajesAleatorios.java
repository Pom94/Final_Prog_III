import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import miJuego.Personaje;
import miJuego.Personaje.Raza;



public class PersonajesAleatorios {
    private Random random = new Random();

    public List<Personaje> generarEquipoAleatorio() {
        List<Personaje> equipo = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Raza raza = elegirRazaAleatoria();
            String nombre = generarNombreAleatorio(raza);
            int edad = generarAtributoAleatorio(1, 300);
            float salud = 300;
            int velocidad = generarAtributoAleatorio(1, 10);
            int destreza = generarAtributoAleatorio(1, 5);
            int fuerza = generarAtributoAleatorio(1, 10);
            int armadura = generarAtributoAleatorio(1, 10);
            int nivel = 1;

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

    private Raza elegirRazaAleatoria() {
        Raza[] razas = Raza.values();
        return razas[random.nextInt(razas.length)];
    }

    private String generarNombreAleatorio(Raza raza) {
        List<String> nombresHumanos = List.of("Aragorn", "Legolas", "Gandalf", "Galia", "Ruffo", "Rebord", "Aquino", "Araña", "Elisa", "Zeta", "Canelon", "Electrochongo", "Juan", "Jorge");
        List<String> nombresOrcos = List.of("Grug", "Thorg", "Morg", "Ruocco", "Ruffo", "Rebord", "Fd", "Jove", "Tano", "Jane", "Uno", "Dos", "Tres", "Tortu", "Marini");
        List<String> nombresElfos = List.of("Luthien", "Galadriel", "Celeborn", "Iacono", "Navaja", "Groissman", "Cacho", "Arwen", "Tauriel", "Ñoqui", "Raviol");

        switch (raza) {
            case HUMANO:
                return nombresHumanos.get(random.nextInt(nombresHumanos.size()));
            case ORCO:
                return nombresOrcos.get(random.nextInt(nombresOrcos.size()));
            case ELFO:
                return nombresElfos.get(random.nextInt(nombresElfos.size()));
            default:
                return "NN";
        }
    }

    private int generarAtributoAleatorio(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}