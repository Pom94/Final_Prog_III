public abstract class Personaje {
    private Raza raza;
    private String nombre;
    private int edad;
    private int salud;
    private int velocidad;
    private int destreza;
    private int fuerza;
    private int armadura;
    private int nivel;

    public Integer poderDisparo() {
        return destreza * fuerza * nivel;
    }

    public Integer efectividadDisparo() {
        return (int) (Math.random() * 100) + 1;
    }

    public Integer poderDefensa() {
        return armadura * velocidad;
    }

    public abstract float danioProvocado(Personaje atacante);

    public boolean estaVivo() {
        return salud > 0;
    }

    public void bonificacion() {
        nivel++;
        salud++;
    }

    public void recibirDanio(float danio) {
        salud -= danio;
        if (salud < 0) {
            salud = 0;
        }
    }

    public Personaje(Raza raza, String nombre, int edad, int salud, int velocidad, int destreza, int fuerza, int armadura, int nivel) {
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
        this.salud = salud;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.nivel = nivel;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public enum Raza {
        HUMANO, ORCO, ELFO
    }
}