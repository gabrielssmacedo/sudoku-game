package utils;

import model.Jogo;
import model.enums.StatusJogo;

import java.util.Arrays;

public class ValidadorJogo {

    public boolean validarNumeroNaPosicao(int linha, int coluna, Integer[][] positions) {
        int numero = positions[linha][coluna];

        for(int i = 0; i < positions[linha].length; i++) {
            if(i == coluna) continue;
            if(numero == positions[linha][i]) return false;
        }

        for(int i = 0; i < positions.length; i++) {
            if(i == linha) continue;
            if(numero == positions[i][coluna]) return false;
        }

        return true;
    }

    public boolean jogoFoiIniciado(Jogo jogo) {
        return !jogo.getStatusJogo().equals(StatusJogo.NAO_INICIADO);
    }

}
