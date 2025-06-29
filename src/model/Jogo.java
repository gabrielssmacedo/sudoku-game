package model;

import model.enums.StatusJogo;
import utils.ValidadorJogo;

import java.util.List;

public class Jogo extends Tabuleiro{

    private StatusJogo statusJogo;
    private boolean statusErro;

    public Jogo(String[] args) {
        super();
        for(String a : args) {
            int linha = Integer.parseInt(String.valueOf(a.charAt(2)));
            int coluna = Integer.parseInt(String.valueOf(a.charAt(0)));
            int numero = Integer.parseInt(String.valueOf(a.charAt(4)));
            positions[linha][coluna] = numero;
            Integer[] indexes = new Integer[3];
            indexes[0] = linha;
            indexes[1] = coluna;
            indexes[2] = numero;
            numerosFixos.add(indexes);
        }
        this.statusJogo = StatusJogo.NAO_INICIADO;
    }

    public StatusJogo getStatusJogo() {
        return statusJogo;
    }

    public void setStatusJogo(StatusJogo statusJogo) {
        this.statusJogo = statusJogo;
    }

    public boolean isStatusErro() {
        return statusErro;
    }

    public void setStatusErro(boolean statusErro) {
        this.statusErro = statusErro;
    }

    public boolean[][] getPosicoesVazias() {
        boolean[][] posicoesVazias = new boolean[TAMANHO][TAMANHO];

        for(int i = 0; i < getPositions().length; i++) {
            for(int j = 0; j < getPositions().length; j++) {
                posicoesVazias[i][j] = getPositions()[i][j] == null;
            }
        }

        return posicoesVazias;
    }

    public void colocarNumero(int linha, int coluna, int numero) {
        if(!ehPosicaoValida(linha, coluna)) return;
        if(!ehNumeroValido(numero)) return;
        boolean[][] posicoesDisponiveis = getPosicoesVazias();
        if(!posicoesDisponiveis[linha][coluna]) {
            System.out.println("Posição já ocupada!");
            return;
        }
        getPositions()[linha][coluna] = numero;
    }

    public void removerNumero(int linha, int coluna) {
        if(!ehPosicaoValida(linha, coluna)) return;
        boolean[][] posicoesDisponiveis = getPosicoesVazias();
        if(posicoesDisponiveis[linha][coluna]) {
            System.out.println("Nenhum número nessa posição!");
            return;
        }
        if(ehNumeroFixo(linha, coluna)) {
            System.out.println("Número fixo não pode ser removido!");
            return;
        }

        getPositions()[linha][coluna] = null;
    }

    public void limparTabuleiro(){
        int len = getPositions().length;

        Integer[][] positions = getPositions();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                positions[i][j] = null;
            }
        }

        for(Integer[] i : getNumerosFixos()) {
            int linha = i[0];
            int coluna = i[1];
            int numeroFixo = i[2];
            positions[linha][coluna] = numeroFixo;
        }

    }

    public boolean finalizarJogo() {
        ValidadorJogo validador = new ValidadorJogo();
        int len = getPositions().length;
        if(!getStatusJogo().equals(StatusJogo.COMPLETO)) return false;
        if(isStatusErro()) return false;

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(!validador.validarNumeroNaPosicao(i, j, getPositions()))
                    return false;
            }
        }

        return true;
    }

    private boolean ehPosicaoValida(int linha, int coluna) {
        if(linha < 0 || linha > TAMANHO-1 || coluna < 0 || coluna > TAMANHO-1){
            System.out.println("Posição inválida!");
            return false;
        }
        return true;
    }

    private boolean ehNumeroValido(int numero) {
        if(numero < 0 || numero > 9) {
            System.out.println("Número inválido!");
            return false;
        }
        return true;
    }

    private boolean ehNumeroFixo(int linha, int coluna) {
        for(Integer[] position : getNumerosFixos()) {
            if(position[0] == linha && position[1] == coluna)
                return true;
        }
        return false;
    }


}
