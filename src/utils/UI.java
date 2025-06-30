package utils;

import model.Jogo;

public class UI {

    public static void start() {
        System.out.println("======================== SUDOKU GAME ========================\n");
        System.out.println("Regras:");
        System.out.println("* Complete as posições '-' com números válidos");
        System.out.println("* Cada linha e coluna deve ter somente um número de 1 a 9");
        System.out.println("* Cada quadrado 3 x 3 deve ter somente um número de 1 a 9.");
        System.out.println("\nPara começar, inicie um novo jogo. Boa sorte!");
    }

    public static void mostrarMenu() {
        System.out.println("1. Iniciar um novo jogo");
        System.out.println("2. Colocar numero");
        System.out.println("3. Remover numero");
        System.out.println("4. Ver jogo");
        System.out.println("5. Verificar status do jogo");
        System.out.println("6. Limpar tabuleiro");
        System.out.println("7. Finalizar jogo");
    }

    public static void mostrarJogo(Jogo jogoAtual) {
        Integer[][] jogo = jogoAtual.getPositions();
        int separador = 0;

        for(int i = 0; i < jogoAtual.getTamanho(); i++) {
            for(int j = 0; j < jogoAtual.getTamanho(); j++) {
                String charPrint = "-  ";
                String num = String.format("%d  ", jogo[i][j]);
                if(separador > 2 || j == 0) {
                    System.out.print("|");
                    separador = 0;
                }
                if(separador == 2) {
                    charPrint = "-";
                    num = String.format("%d", jogo[i][j]);

                }
                System.out.print(jogo[i][j] == null ? charPrint : num);
                separador++;
            }
            System.out.println("|");
        }
    }

    public static void limpaTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
