package lab_project;

public class CartasNumericas extends Cartas {

    public CartasNumericas(int color, int num) {
        super(color);
        Numero = num;
        Nombre = Color + Numero;
    }

//    public CartasNumericas[] arregloCartasNumericas(){
//        int x=0;
//        CartasNumericas arreglo[]=new CartasNumericas[76];
//        for(int color=0;color<4;color++){
//            for(int num=0;num<10;num++){
//                arregloCartasNumericas[x]=new Cartas();
//            }
//        }
//    }
}
