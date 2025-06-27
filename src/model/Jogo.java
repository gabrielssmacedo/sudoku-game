package model;

public class Jogo extends Tabuleiro{

    public Jogo(String[] args) {
        super();
        for(String a : args) {
            int linha = Integer.parseInt(String.valueOf(a.charAt(2)));
            int coluna = Integer.parseInt(String.valueOf(a.charAt(0)));
            int numero = Integer.parseInt(String.valueOf(a.charAt(4)));
            positions[linha][coluna] = numero;
            Integer[] indexes = new Integer[2];
            indexes[0] = linha;
            indexes[1] = coluna;
            numerosFixos.add(indexes);
        }

    }

    public boolean[][] posicoesDisponiveis() {
        boolean[][] positionsDisponiveis = new boolean[TAMANHO][TAMANHO];

        for(int i = 0; i < getPositions().length; i++) {
            for(int j = 0; j < getPositions().length; j++) {
                positionsDisponiveis[i][j] = getPositions()[i][j] == null;
            }
        }

        return positionsDisponiveis;
    }
}
