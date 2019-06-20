package lab_project;

public class CartasEspeciales extends Cartas {

    protected String tipoCarta;
    private final static int toma_dos = 0, reversa = 1, salta = 2, comodin_color = 3, toma_cuatro = 4;

    public CartasEspeciales(int color, int tipo) {
        super(color);
        switch (tipo) {
            case toma_dos:
                tipoCarta = "T";
                break;
            case reversa:
                tipoCarta = "R";
                break;
            case salta:
                tipoCarta = "S";
                break;
            case comodin_color:
                tipoCarta = "C";
                break;
            case toma_cuatro:
                tipoCarta = "M";
                break;
        }
        Nombre = Color + tipoCarta;
    }

}
