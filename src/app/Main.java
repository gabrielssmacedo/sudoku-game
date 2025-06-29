package app;

import model.Jogo;
import utils.UI;
import utils.ValidadorJogo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UI.start();

        Jogo sudoku = new Jogo(args);
        sudoku.retirarNumero(0,0);
        sudoku.colocarNumero(0, 0, 9);
        sudoku.colocarNumero(0, 1, 7);
        UI.mostrarJogo(sudoku);

        ValidadorJogo validador = new ValidadorJogo();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku.getPosicoesVazias()[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(validador.validarNumeroNaPosicao(3, 8, sudoku.getPositions()));

    }
}