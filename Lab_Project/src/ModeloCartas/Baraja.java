package ModeloCartas;

import java.awt.Color;
import java.util.LinkedList;

import Interfaces.ConstantesJuego;
import Controlador.CartasListener;
import Vista.CartaUno;

public class Baraja implements ConstantesJuego {

    private final LinkedList<CartasNumericas> numberCards;
    private final LinkedList<ActionCarta> actionCards;
    private final LinkedList<CartasEspeciales> wildCards;
    private LinkedList<CartaUno> UNOcards;

    public Baraja() {
        numberCards = new LinkedList<CartasNumericas>();
        actionCards = new LinkedList<ActionCarta>();
        wildCards = new LinkedList<CartasEspeciales>();
        UNOcards = new LinkedList<CartaUno>();
        addCards();
        addCardListener(CARDLISTENER);
    }

    private void addCards() {
        for (Color color : colores_uno) {
            for (int num : cartas_numericas) {
                int i = 0;
                do {
                    UNOcards.add(new CartasNumericas(color, Integer.toString(num)));
                    i++;
                } while (num != 0 && i < 2);
            }
            for (String type : tipos_acciones) {
                for (int i = 0; i < 2; i++) {
                    UNOcards.add(new ActionCarta(color, type));
                }
            }
        }
        for (String type : tipos_expeciales) {
            for (int i = 0; i < 4; i++) {
                UNOcards.add(new CartasEspeciales(type));
            }
        }

    }

    public void addCardListener(CartasListener listener) {
        for (CartaUno card : UNOcards) {
            card.addMouseListener(listener);
        }
    }

    public LinkedList<CartaUno> getCards() {
        return UNOcards;
    }
}
