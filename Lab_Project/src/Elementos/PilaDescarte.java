package Elementos;

import java.util.Stack;

public class PilaDescarte {

    private Stack<Carta> pilaDeDescarte = new Stack<Carta>();

    public PilaDescarte(Carta primeraCarta) {
        pilaDeDescarte.push(primeraCarta);
    }

    public Carta getCartaDeDescarte() {
        return pilaDeDescarte.peek();
    }

}
