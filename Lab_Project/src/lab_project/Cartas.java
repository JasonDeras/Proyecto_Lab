package lab_project;

public class Cartas {

    protected int Numero;
    protected String Color;
    protected String Nombre;

    private final static int amarillo = 0, azul = 1, rojo = 2, verde = 3, negro = 4;
//Color negro para las cartas especiales

    public Cartas(int color) {
        switch (color) {
            case amarillo:
                Color = "Amarillo";
                break;
            case azul:
                Color = "Azul";
                break;
            case rojo:
                Color = "Rojo";
                break;
            case verde:
                Color = "Verde";
                break;
            case negro:
                Color = "Negro";
                break;

        }
    }

    public Cartas[] BarajarCartas(Cartas[] arregloCartas) {
        for (int i = arregloCartas.length; i >= 0; i--) {
            int ale = (int) (Math.random() * (i + 1));
            Cartas temp = arregloCartas[i];
            arregloCartas[i] = arregloCartas[ale];
            arregloCartas[ale] = temp;
        }
        return arregloCartas;
    }
}
