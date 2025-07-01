package model;

import model.enums.StatusJogo;
import utils.UI;
import utils.ValidadorJogo;

public class Jogo extends Tabuleiro{

    private StatusJogo statusJogo;
    private boolean statusErro;

    public Jogo() {
        super();
        this.statusJogo = StatusJogo.NAO_INICIADO;
    }

    public void iniciarNovoJogo(String[] args) {
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
        ValidadorJogo validador = new ValidadorJogo();

        if(!validador.ehPosicaoValida(linha, coluna, TAMANHO)) return;
        if(!validador.ehNumeroValido(numero)) return;
        boolean[][] posicoesDisponiveis = getPosicoesVazias();
        if(!posicoesDisponiveis[linha][coluna]) {
            System.out.println("\nPosição já ocupada!\n");
            return;
        }
        getPositions()[linha][coluna] = numero;

        validador.atualizaStatusJogo(this);
    }

    public void removerNumero(int linha, int coluna) {
        ValidadorJogo validador = new ValidadorJogo();

        if(!validador.ehPosicaoValida(linha, coluna, TAMANHO)) return;
        boolean[][] posicoesDisponiveis = getPosicoesVazias();
        if(posicoesDisponiveis[linha][coluna]) {
            System.out.println("\nNenhum número nessa posição!\n");
            return;
        }
        if(validador.ehNumeroFixo(linha, coluna, getNumerosFixos())) {
            System.out.println("\nNúmero fixo não pode ser removido!\n");
            return;
        }

        getPositions()[linha][coluna] = null;

        validador.atualizaStatusJogo(this);
    }

    public void limparTabuleiro(){
        int len = getPositions().length;
        ValidadorJogo validador = new ValidadorJogo();

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

        validador.atualizaStatusJogo(this);

    }

    public boolean finalizarJogo() {
        ValidadorJogo validador = new ValidadorJogo();
        if(!getStatusJogo().equals(StatusJogo.COMPLETO)) return false;
        if(isStatusErro()) return false;

        return validador.validaTodasPosicoes(this);
    }
}
