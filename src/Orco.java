public class Orco extends Personaje{
    public Orco(Raza raza, String nombre, int edad, int salud, int velocidad, int destreza, int fuerza, int armadura, int nivel) {
        super(raza, nombre, edad, salud, velocidad, destreza, fuerza, armadura, nivel);
    }

    public float danioProvocado(Personaje atacante) {
        int VA = atacante.poderDisparo() * atacante.efectividadDisparo();
        int PDEF = poderDefensa();
        return (float) (((VA - PDEF) / 500.0) * 100 * 1.1);
    }
}