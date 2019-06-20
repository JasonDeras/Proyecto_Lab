package Elementos;

public class Carta {

    private String color;
    private int numero;
    private String especialidad;
    public static final String NO_ESPECIAL = "SIN_ESPECIALIDAD";
    public static final String NO_COLOR = "SIN_COLOR";
    public static final int NO_NUMERICA = -1;

    public Carta(String color, int numero) {
        this.color = color;
        this.numero = numero;
        this.especialidad = NO_ESPECIAL;
    }

    public Carta(String color, String especialidad) {
        this.color = color;
        this.numero = NO_NUMERICA;
        this.especialidad = especialidad;

    }

    public Carta(String especialidad) {
        this.color = NO_COLOR;
        this.numero = NO_NUMERICA;
        this.especialidad = especialidad;

    }

    @Override
    public String toString() {
        String datosDeCarta;

        if (this.numero == this.NO_NUMERICA) {

            if (this.color == NO_COLOR) {
                datosDeCarta = especialidad;
            } else {
                datosDeCarta = especialidad + " de " + color;
            }

        } else {
            datosDeCarta = numero + " de " + color;
        }

        return datosDeCarta;

    }

    public String getColor() {
        return color;
    }

    public int getNumero() {
        return numero;
    }

    public String getEspecialidad() {
        return especialidad;
    }

}
