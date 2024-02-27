package buscaminas;

import java.util.Random;

public class BuscaMinas{
    private final int TAMANIO = 10;
    private int MINAS = 15;
    private boolean hayMina;
    private char[][] tableroVerdadero = new char[TAMANIO][TAMANIO] ;
    private char MINA = '*';
    private char VACIA = '.';

    /**
     * constructor 
     * creamos tablero 10*10 y colocamos 15 minas aleatoriamente '*' y donde no hay '·'
     */
    public BuscaMinas(){
        for(int i=0;i<TAMANIO;i++){
            for(int j=0;j<TAMANIO;j++){
                tableroVerdadero[i][j]=VACIA;
            }
        }

        int cont =0;
        Random r =new Random();
        while(cont<MINAS){  
            int f=r.nextInt(0,10);
            int c=r.nextInt(0,10);

            if(tableroVerdadero[f][c] !=MINA){
                tableroVerdadero[f][c]=MINA;
                cont++;
            }
            
        }        

    }

    /**
     * devuelve el caracter de esa celda
     * @param i fila
     * @param j columna
     * @return char de esa celda
     */
    public char getCelda(int i, int j){
        return this.tableroVerdadero[i][j];
    }

    /**
     * comprobamos si la celda adyacente está vacia alrededor de la celda
     * @param i fila
     * @param j columna
     * @return 
     */
    public boolean buscaAlrededor(int i, int j){
        if(tableroVerdadero[i][j]==MINA){return false;}
        else if(tableroVerdadero[i][j]!=VACIA){return true;}
        int x=0;
        {
            if(i>0){if (tableroVerdadero[i-1][j]==MINA){x++;}}
            if(j>0){if (tableroVerdadero[i][j-1]==MINA){x++;}}
            if(i>0 && j>0){if (tableroVerdadero[i-1][j-1]==MINA){x++;}}
            if(i<TAMANIO-1){if (tableroVerdadero[i+1][j]==MINA){x++;}}
            if(j<TAMANIO-1){if (tableroVerdadero[i][j+1]==MINA){x++;}}
            if(i<TAMANIO-1 && j<TAMANIO-1){if (tableroVerdadero[i+1][j+1]==MINA){x++;}}
            if(i>0 && j<TAMANIO-1){if (tableroVerdadero[i-1][j+1]==MINA){x++;}}
            if(i<TAMANIO-1 && j>0){if (tableroVerdadero[i+1][j-1]==MINA){x++;}}
        }
        tableroVerdadero[i][j]=Character.forDigit(x,10);
        {
            if(i>0){if (tableroVerdadero[i-1][j]!=MINA && x==0) {tableroVerdadero[i-1][j]=busca(i-1,j,0);}}
            if(j>0){if (tableroVerdadero[i][j-1]!=MINA && x==0) {tableroVerdadero[i][j-1]=busca(i,j-1,0);}}
            if(i>0 && j>0){if (tableroVerdadero[i-1][j-1]!=MINA && x==0) {tableroVerdadero[i-1][j-1]=busca(i-1,j-1,0);}}
            if(i<TAMANIO-1){if (tableroVerdadero[i+1][j]!=MINA && x==0) {tableroVerdadero[i+1][j]=busca(i+1,j,0);}}
            if(j<TAMANIO-1){if (tableroVerdadero[i][j+1]!=MINA && x==0) {tableroVerdadero[i][j+1]=busca(i,j+1,0);}}
            if(i<TAMANIO-1 && j<TAMANIO-1){if (tableroVerdadero[i+1][j+1]!=MINA && x==0){ {tableroVerdadero[i+1][j+1]=busca(i+1,j+1,0);}}}
            if(i>0 && j<TAMANIO-1){if (tableroVerdadero[i-1][j+1]!=MINA && x==0) {tableroVerdadero[i-1][j+1]=busca(i-1,j+1,0);}}
            if(i<TAMANIO-1 && j>0){if (tableroVerdadero[i+1][j-1]!=MINA && x==0) {tableroVerdadero[i+1][j-1]=busca(i+1,j-1,0);}}
        }
        return true;
    }

    /**
     * comprobamos si la celda adyacente limita con mina
     * @param i fila
     * @param j columna
     * @param siNoLimitaConMina si cero= celda no tiene mina adyacente
     * @return char de la celda adyacente para connocer lo que contiene
     */
    public char busca(int i, int j, int siNoLimitaConMina){
        if(tableroVerdadero[i][j]!=VACIA){return tableroVerdadero[i][j];}
        int x=0;
        if(i>0){if (tableroVerdadero[i-1][j]==MINA){x++;}}
        if(j>0){if (tableroVerdadero[i][j-1]==MINA){x++;}}
        if(i>0 && j>0){if (tableroVerdadero[i-1][j-1]==MINA){x++;}}
        if(i<TAMANIO-1){if (tableroVerdadero[i+1][j]==MINA){x++;}}
        if(j<TAMANIO-1){if (tableroVerdadero[i][j+1]==MINA){x++;}}
        if(i<TAMANIO-1 && j<TAMANIO-1){if (tableroVerdadero[i+1][j+1]==MINA){x++;}}
        if(i>0 && j<TAMANIO-1){if (tableroVerdadero[i-1][j+1]==MINA){x++;}}
        if(i<TAMANIO-1 && j>0){if (tableroVerdadero[i+1][j-1]==MINA){x++;}}
        tableroVerdadero[i][j]='%';
        if(i>0){if (tableroVerdadero[i-1][j]!=MINA && x==0) {tableroVerdadero[i-1][j]=busca(i-1,j,0);}}
        if(j>0){if (tableroVerdadero[i][j-1]!=MINA && x==0) {tableroVerdadero[i][j-1]=busca(i,j-1,0);}}
        if(i>0 && j>0){if (tableroVerdadero[i-1][j-1]!=MINA && x==0) {tableroVerdadero[i-1][j-1]=busca(i-1,j-1,0);}}
        if(i<TAMANIO-1){if (tableroVerdadero[i+1][j]!=MINA && x==0) {tableroVerdadero[i+1][j]=busca(i+1,j,0);}}
        if(j<TAMANIO-1){if (tableroVerdadero[i][j+1]!=MINA && x==0) {tableroVerdadero[i][j+1]=busca(i,j+1,0);}}
        if(i<TAMANIO-1 && j<TAMANIO-1){if (tableroVerdadero[i+1][j+1]!=MINA && x==0){ {tableroVerdadero[i+1][j+1]=busca(i+1,j+1,0);}}}
        if(i>0 && j<TAMANIO-1){if (tableroVerdadero[i-1][j+1]!=MINA && x==0) {tableroVerdadero[i-1][j+1]=busca(i-1,j+1,0);}}
        if(i<TAMANIO-1 && j>0){if (tableroVerdadero[i+1][j-1]!=MINA && x==0) {tableroVerdadero[i+1][j-1]=busca(i+1,j-1,0);}}
        return Character.forDigit(x,10);
    }

    /**
     * metodo que dice si se eligió una celda con mina
     * @return booleano si/no hay mina
     */
    public boolean getResultado(){
        return hayMina;
    }

    /**
     * metodo que devuelve una COPIA de la matriz donde seencuentran las minas
     * @return char[TAMANIO][TAMANIO] 
     */
    public char[][] getTablero(){
        char[][] t = new char[TAMANIO][TAMANIO];
        for(int i=0;i<TAMANIO;i++){
            for(int j=0;j<TAMANIO;j++){
                t[i][j]=tableroVerdadero[i][j];
            }
        }
        return t;
    }

    /**
     * metodo para devolver el tamanio de la matriz cuadrada
     */
    public int getTamanio(){
        return TAMANIO;
    }

    /**
     * metodo para contar el numero de minas alrededor de una celda
     * @return int MINAS
     */
    public int getNumMinas(){
        return MINAS;
    }

    /**
     * metodo para devolver que se ha encontrado una MINA
     * @return char MINA
     */
    public char getMina(){
        return MINA;
    }

    /**
     * metodo para devolver que se ha encontrado celda vacia
     * @return char VACIA
     */
    public char getVacia(){
        return VACIA;
    }

}