
package pi;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author matheus.jmaia
 */
public class PI {
static int subs = 5;
static int subsaliado = 5;
static int [][][] criatabuleiro (){
    int tabuleiro [][][] = new int [5][5][2];
    return tabuleiro;
}
static int [][][] inicializatabuleiro (int[][][] tabuleiro){
    for(int i= 0;i<tabuleiro.length;i++){
        for(int j = 0;j<tabuleiro[i].length;j++){
            for (int k = 0;k<tabuleiro[i][j].length;k++){
            tabuleiro[i][j][k] = 0;
            }

        }
    }
return tabuleiro;
} 
static int [][][] sorteiaPosicao (int [][][] tabuleiro){
    Random consoleR = new Random();
    for (int i =0;i < 5;i++){
        int posicaoLinha = consoleR.nextInt(5);
        int posicaoColuna = consoleR.nextInt(5);
        tabuleiro[posicaoLinha][posicaoColuna][1] = 1;
    }
return tabuleiro;
}
static int [][][] pedirPosicaoInicial (int [][][] tabuleiro){
    Scanner console = new Scanner (System.in);    
    for (int i = 1;i <= 5;i++){
    System.out.print("Insira a linha: ");
    int linha = console.nextInt();    
    System.out.print("Insira a coluna: ");
    int coluna = console.nextInt();
    tabuleiro[linha][coluna][0] = 1;
    //colocar a funcão imprime tabuleiro aqui
    System.out.println((5-i)+" submarinos restantes...");
}
return tabuleiro;
}
static int [][][] jogada (int [][][] tabuleiroMaquina){
    Scanner console = new Scanner (System.in);
    System.out.println("Qual posição?");
    System.out.print("Linha: ");
    int linha = console.nextInt();
    System.out.print("Coluna: ");
    int coluna = console.nextInt();
    if (tabuleiroMaquina[linha][coluna][1] == 1){
        tabuleiroMaquina[linha][coluna][1] = 6;
        System.out.print("Submarino inimigo atingindo! ");
        informaSub();
    } else if (tabuleiroMaquina[linha][coluna][1] == 0){
        tabuleiroMaquina[linha][coluna][1] = 9;
    }
   return tabuleiroMaquina; 
}
static int [][][] jogadaMaquina(int[][][] tabuleiroJogador){
    Random consoleR = new Random();
    int linha = consoleR.nextInt(5);
    int coluna = consoleR.nextInt(5);
    if (tabuleiroJogador[linha][coluna][0] == 1){
        tabuleiroJogador[linha][coluna][0] = 6;
        System.out.println("Submarino aliado atingido!");
        informaSubAliado();
    } else if (tabuleiroJogador[linha][coluna][0] == 0){
        tabuleiroJogador[linha][coluna][0] = 9;
    }
return tabuleiroJogador;
}
static void informaSub (){
    subs = subs - 1;
    System.out.println(subs+" submarinos restantes para ser atingidos!");

}
static void informaSubAliado (){
    subsaliado = subsaliado - 1;
    System.out.println(subs+" submarinos aliados restanstes");
}
public static void main(String[] args) {
        int [][][] tabuleiroMaquina = criatabuleiro();
        tabuleiroMaquina = inicializatabuleiro(tabuleiroMaquina);
        tabuleiroMaquina = sorteiaPosicao(tabuleiroMaquina);
        int [][][] tabuleiroJogador = criatabuleiro();
        tabuleiroJogador = inicializatabuleiro(tabuleiroJogador);
        tabuleiroJogador = pedirPosicaoInicial(tabuleiroJogador);
        
        
        tabuleiroMaquina = jogada(tabuleiroMaquina);
        tabuleiroJogador = jogadaMaquina(tabuleiroJogador);
    }
    
}
