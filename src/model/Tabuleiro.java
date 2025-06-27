package model;

public abstract class Tabuleiro {

    Integer[][] positions;
    Integer[][] numerosFixos;


    public Tabuleiro() {
        positions = new Integer[9][9];
    }

    public void inserirNumeroFixos(String[] fixos) {
       numerosFixos = new Integer[9][9];
    }


}
