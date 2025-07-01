package utils;

import model.Jogo;
import model.enums.StatusJogo;

import java.util.Arrays;
import java.util.List;

public class ValidadorJogo {

    public boolean validarNumeroNaPosicao(int linha, int coluna, Integer[][] positions) {
        Integer numero = positions[linha][coluna];
        if(numero == null) return true;

        for(int i = 0; i < positions[linha].length; i++) {
            if(i == coluna) continue;
            if(numero.equals(positions[linha][i])) return false;
        }

        for(int i = 0; i < positions.length; i++) {
            if(i == linha) continue;
            if(numero.equals(positions[i][coluna])) return false;
        }

        return true;
    }

    public boolean jogoFoiIniciado(Jogo jogo) {
        return !jogo.getStatusJogo().equals(StatusJogo.NAO_INICIADO);
    }

    public boolean jogoEstaCompleto(Jogo jogo) {
        boolean[][] posicoesVazias = jogo.getPosicoesVazias();

        for(boolean[] linha : posicoesVazias) {
            for(boolean coluna : linha) {
                if(coluna) return false;
            }
        }

        return true;
    }

    public void atualizaStatusJogo(Jogo jogo) {
        if(!jogoEstaCompleto(jogo)) jogo.setStatusJogo(StatusJogo.INCOMPLETO);
        else jogo.setStatusJogo(StatusJogo.COMPLETO);

        jogo.setStatusErro(!validaTodasPosicoes(jogo));
    }

    public boolean validaTodasPosicoes(Jogo jogo) {
        for(int i = 0; i < jogo.getPositions().length; i++) {
            for(int j = 0; j < jogo.getPositions().length; j++) {
                if(!validarNumeroNaPosicao(i, j, jogo.getPositions()))
                    return false;
            }
        }
        return true;
    }

    public boolean ehPosicaoValida(int linha, int coluna, final int tamanho) {
        if(linha < 0 || linha > tamanho-1 || coluna < 0 || coluna > tamanho-1){
            System.out.println("\nPosição inválida!\n");
            return false;
        }
        return true;
    }

    public boolean ehNumeroValido(int numero) {
        if(numero < 0 || numero > 9) {
            System.out.println("\nNúmero inválido!\n");
            return false;
        }
        return true;
    }

    public boolean ehNumeroFixo(int linha, int coluna, List<Integer[]> numerosFixos) {
        for(Integer[] position : numerosFixos) {
            if(position[0] == linha && position[1] == coluna)
                return true;
        }
        return false;
    }
}
