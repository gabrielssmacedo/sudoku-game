package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Tabuleiro {

    protected static final int TAMANHO = 9;

    protected Integer[][] positions;
    protected List<Integer[]> numerosFixos;

    public Tabuleiro() {
        positions = new Integer[TAMANHO][TAMANHO];
        numerosFixos = new ArrayList<>();
    }

    public Integer[] getLinha(int linha) {
        return positions[linha];
    }

    public Integer[] getColuna(int coluna) {
        Integer[] numeros = new Integer[TAMANHO];

        for(int linha = 0; linha < TAMANHO; linha++) {
            numeros[linha] = positions[linha][coluna];
        }

        return numeros;
    }

    public int getTamanho() {
        return TAMANHO;
    }

    public Integer[][] getPositions() {
        return positions;
    }

    public List<Integer[]> getNumerosFixos() {
        return numerosFixos;
    }
}
