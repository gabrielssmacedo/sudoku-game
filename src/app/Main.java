package app;

import model.Jogo;
import utils.UI;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UI.start();

        Jogo sudoku = new Jogo(args);
        UI.mostrarJogo(sudoku);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku.posicoesDisponiveis()[i][j] + " ");
            }
            System.out.println();
        }

    }
}