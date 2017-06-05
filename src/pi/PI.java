
package pi;

import java.util.Random;
import java.util.Scanner;
/****************falta:     |VALIDADR AS POSIÇÕES    |
                            |FAZER TRATAMENTO DE ERRO|
                            |PERFUMARIA              |
 ****************           |INTERFACE GRÁFICA       | 
/**
 *
 * @author matheus.jmaia
 */
public class PI {
static int subs = 5;
static int subsaliado = 5;
static String jogador = "";
static String computador = "";
static int n = 0, n1 = 1;

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
static void monstraTabuleiro (int [][][] tabuleiro, int n ,int f){
    System.out.println();
    if (f == 0){
        System.out.println(jogador);
    }else if (f==1){
        System.out.println(computador);
    }   
    System.out.println("1+---+---+---+---+---+");
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(" |");
            for (int j = 0; j < tabuleiro[i].length; j++) {

                System.out.print(" " + tabuleiro[i][j][n] + " |");
            }
            System.out.println();
            System.out.println(" +---+---+---+---+---+");
        }
        System.out.println("   0 | 1 | 2 | 3 | 4 ");
        System.out.println("       COLUNA        ");
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
    System.out.println("Posicione os seus submarinos");
    for (int i = 1;i <= 5;i++){
    System.out.print("Insira a linha: ");
    int linha = console.nextInt();    
    System.out.print("Insira a coluna: ");
    int coluna = console.nextInt();
    tabuleiro[linha][coluna][0] = 1;
//    monstraTabuleiro(tabuleiroJogador, n);
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
        tabuleiroMaquina[linha][coluna][0] = 6;
        informaSub();
    } else if (tabuleiroMaquina[linha][coluna][1] == 0){
        tabuleiroMaquina[linha][coluna][1] = 9;
        tabuleiroMaquina[linha][coluna][0] = 9;
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
    System.out.println(subsaliado+" submarinos aliados restanstes");

}
static boolean jogarNovamente (boolean condicao1){
    Scanner console = new Scanner (System.in);
    System.out.println("Deseja jogar novamente? ");
    String condicao = console.next();
    condicao = condicao.toLowerCase();
    if (condicao.equalsIgnoreCase("sim") || condicao.equalsIgnoreCase("ss") || condicao.equalsIgnoreCase("s")){
                condicao1 = true;
            }
return condicao1;
}
static void intro (){
    Scanner console = new Scanner (System.in);
    System.out.println("Bem vindo ao (!NOTguerraFria)");
    System.out.print("Deseja ler as regras? ");
    String condicao = console.next();
    condicao = condicao.toLowerCase();
    if (condicao.equalsIgnoreCase("sim") || condicao.equalsIgnoreCase("ss") || condicao.equalsIgnoreCase("s")){
        System.out.println("(!NOTguerraFria) é um jogo de tabuleiro, no qual você têm de adivinhar em que localização estão os submarinos do oponente.");
        System.out.println("Os submarinos ocupam uma posição do tabuleiro. No total são *5* submarinos para cada tabuleiro");
        System.out.println("Ganha quem destruir todos os submarinos primeiro!");
    }
    System.out.println("selecione uma nação: ");
    System.out.println("Digite 1 para a URSS ou");
    System.out.println("Digite 2 para o U.S.A.");
    int opcao = console.nextInt();
    if (opcao==1){
        computador = " U.S.A. ";
        jogador = " URSS ";
    }else if (opcao==2){
        computador = " URSS ";
        jogador = " U.S.A. ";
    }
}
public static void main(String[] args) {
    boolean condicao1 = false;
    
    do {
        intro();
        
        System.out.println("Objetivo: Destrua todos os submarinos nucleares da" +computador);
        int [][][] tabuleiroMaquina = criatabuleiro();
        tabuleiroMaquina = inicializatabuleiro(tabuleiroMaquina);
        tabuleiroMaquina = sorteiaPosicao(tabuleiroMaquina);
        int [][][] tabuleiroJogador = criatabuleiro();
        tabuleiroJogador = inicializatabuleiro(tabuleiroJogador);
        monstraTabuleiro(tabuleiroJogador, n, n);
        tabuleiroJogador = pedirPosicaoInicial(tabuleiroJogador);
        
        for(int i = 0; i<25;i++){
        monstraTabuleiro(tabuleiroJogador, n, n);
        monstraTabuleiro(tabuleiroMaquina, n, n1);
        tabuleiroMaquina = jogada(tabuleiroMaquina);
        tabuleiroJogador = jogadaMaquina(tabuleiroJogador);


        if( subs == 0){
            System.out.println("Parabéns! Você ganhou!");
            break;
        }
        if (subsaliado == 0){
            System.out.println("Seus submarinos foram todos afundados...");
            System.out.println("GAME OVER!");
            break;
        }
        
    }
        condicao1 = jogarNovamente(condicao1);
} while (condicao1 == true);
        
 }
}