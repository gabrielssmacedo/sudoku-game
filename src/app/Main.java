package app;

import model.Jogo;
import model.enums.StatusJogo;
import utils.UI;
import utils.ValidadorJogo;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Jogo sudoku = new Jogo();
        ValidadorJogo validador = new ValidadorJogo();
        UI.start();

        boolean jogoFinalizado = false;
        do {
            UI.mostrarMenu();
            int respostaMenu = recebeResposta();
            switch (respostaMenu) {
                case 1 -> {
                    if(!validador.jogoFoiIniciado(sudoku)) {
                        sudoku.iniciarNovoJogo(args);
                        System.out.println("\nNovo jogo iniciado!\n");
                        sudoku.setStatusJogo(StatusJogo.INCOMPLETO);
                    }
                    else {
                        System.out.println("\nTermine seu jogo atual para iniciar um novo!");
                    }

                }
                case 2 -> {
                    if(!validador.jogoFoiIniciado(sudoku)) {
                        System.out.println("\nInicie um novo jogo!\n");
                        break;
                    }
                    System.out.print("\nLinha: ");
                    int linha = sc.nextInt();
                    System.out.print("Coluna: ");
                    int coluna = sc.nextInt();
                    System.out.print("Numero: ");
                    int numero = sc.nextInt();
                    System.out.println();
                    sudoku.colocarNumero(linha, coluna, numero);
                }
                case 3 -> {
                    if(!validador.jogoFoiIniciado(sudoku)) {
                        System.out.println("\nInicie um novo jogo!\n");
                        break;
                    }
                    System.out.print("\nLinha: ");
                    int linha = sc.nextInt();
                    System.out.print("Coluna: ");
                    System.out.println();
                    int coluna = sc.nextInt();
                    sudoku.removerNumero(linha, coluna);
                }
                case 4 -> {
                    System.out.println();
                    UI.mostrarJogo(sudoku);
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("\nStatus do jogo: ");
                    switch (sudoku.getStatusJogo()) {
                        case NAO_INICIADO -> System.out.println("não iniciado");
                        case INCOMPLETO -> System.out.println("incompleto");
                        case COMPLETO -> System.out.println("completo");
                    }
                    System.out.printf("Status de erro: %s\n\n", sudoku.isStatusErro() ? "com erro" : "sem erro");
                }
                case 6 -> {
                    if(!validador.jogoFoiIniciado(sudoku)) {
                        System.out.println("\nInicie um novo jogo!\n");
                        break;
                    }
                    System.out.print("\nTem certeza que deseja limpar seu jogo (s/n)? ");
                    char respLimpar = sc.next().charAt(0);
                    if(respLimpar == 's' || respLimpar == 'S') {
                        sudoku.limparTabuleiro();
                        System.out.println("\nSeu tabuleiro foi limpo");
                    }
                }
                case 7 -> {
                    if(!validador.jogoFoiIniciado(sudoku)) {
                        System.out.println("\nInicie um novo jogo!\n");
                        break;
                    }
                    if(sudoku.finalizarJogo()) {
                        System.out.println("\nFIM DE JOGO\nVOCÊ RESOLVEU O SUDOKU!");
                        jogoFinalizado = true;
                    }
                    else {
                        System.out.println("\nJogo inválido! Numeros nas posições erradas ou jogo incompleto\n");
                    }
                }

            }
            UI.limpaTela();
        } while(!jogoFinalizado);

        sc.close();
    }

    public static int recebeResposta() {
        System.out.print(">> ");
        int resposta = sc.nextInt();

        while(resposta < 1 || resposta > 7) {
            System.out.println("\nResposta Inválida!");
            System.out.print(">> ");
            resposta = sc.nextInt();
        }

        return resposta;
    }

    public static void executaOpcao(int resposta, Jogo sudoku) {
        switch (resposta) {

        }
    }
}