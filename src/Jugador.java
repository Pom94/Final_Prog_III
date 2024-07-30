import java.util.ArrayList;
import java.util.List;
import miJuego.Personaje;

public class Jugador {
    private List<Personaje> equipo;

    public Jugador(){
        equipo = new ArrayList<>();
    }

    public void agregarPersonaje(Personaje personaje) {
        equipo.add(personaje);
    }

    public List<Personaje> getEquipo() {
        return equipo;
    }


}