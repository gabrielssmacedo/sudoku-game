package app;

import model.Jogo;
import utils.UI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UI.start();

        Jogo sudoku = new Jogo();
        UI.mostrarJogo(sudoku);
    }
}