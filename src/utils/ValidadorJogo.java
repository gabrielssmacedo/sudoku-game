package utils;

import model.Jogo;
import model.enums.StatusJogo;

import java.util.Arrays;

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

}
