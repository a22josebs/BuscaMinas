package principal;

import java.util.Scanner;
import java.util.Random;

import buscaminas.BuscaMinas;

public class InterfaceConsola {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BuscaMinas bm = new BuscaMinas();
        InterfaceConsola ic = new InterfaceConsola();
        int x;
        int y;
        boolean seguir = true;

        while(seguir==true){
            ic.muestraTablero(bm);
            System.out.println("\nTeclea la fila (1-10)");
            x= sc.nextInt();
            System.out.println("Teclea la columna (1-10)");
            y= sc.nextInt();
            seguir=bm.buscaAlrededor(x-1,y-1);
        }

        if(!bm.getResultado()){System.out.println("\t\tPERDISTE");}
        if(bm.getResultado()){System.out.println("\t\tGANASTE");}
        ic.muestraVerdadero(bm.getTablero());
    }


    public void muestraTablero(BuscaMinas bm){
        for(int i=0;i<(bm.getTamanio()*2+3);i++){
            if(i==0){
                System.out.print("\t_");
            }else{
                System.out.print("_");
            }
            
        }
        System.out.println();
        for(int i=0;i<bm.getTamanio();i++){
            System.out.print("\t| ");
            for(int j=0;j<bm.getTamanio();j++){
                if(bm.getCelda(i, j)==bm.getMina()){System.out.print(bm.getVacia()+" ");}else{System.out.print(bm.getCelda(i, j)+" ");
                }
            }
            System.out.println("|");
        }
        for(int i=0;i<(bm.getTamanio()*2+3);i++){
            if(i==0){
                System.out.print("\t¯");
            }else{
                System.out.print("¯");//alt+238
            }
            
        }
        
    }

    public void muestraVerdadero(char[][] t){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println();
        }

    }

    
}
