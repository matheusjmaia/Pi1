
package pi;

import java.util.Random;
import java.util.Scanner;
/*
                            

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
static String cor = "verde", cor1 = "magenta",cor2 = "vermelho";
static boolean negrito = false;
static String [][][] criatabuleiro (){
    String tabuleiro [][][] = new String [5][5][2];
    return tabuleiro;
}
static String [][][] inicializatabuleiro (String[][][] tabuleiro){
    for(int i= 0;i<tabuleiro.length;i++){
        for(int j = 0;j<tabuleiro[i].length;j++){
            for (int k = 0;k<tabuleiro[i][j].length;k++){
            tabuleiro[i][j][k] = "~";
            }

        }
    }
return tabuleiro;
} 
static void monstraTabuleiro (String [][][] tabuleiro, int n ,int f){
    System.out.println();
    if (f == 0){
        System.out.println(jogador);
    }else if (f==1){
        System.out.println(computador);
    }   
    cor = "vermelho";
    cor(cor);
    System.out.println("  +---+---+---+---+---+");
    int l = -1;    
    for (int i = 0; i < tabuleiro.length; i++) {
            cor = "vermelho";
            cor(cor);
        System.out.print("  |");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                cor = "vermelho";
                cor(cor);
                System.out.print(" " + tabuleiro[i][j][n] + " |");
            
            }
            System.out.println();
            l = l + 1;
            cor = "azul";
            cor(cor);
            System.out.println(l+" +---+---+---+---+---+");
    
    }
        cor = "vermelho";
        cor(cor);
        System.out.println("    0 | 1 | 2 | 3 | 4 ");
        cor = "azul";
        cor(cor);
        System.out.println("        COLUNA        ");
}
static String [][][] sorteiaPosicao (String [][][] tabuleiro){
    Random consoleR = new Random();
    for (int i =0;i < 5;i++){
        int posicaoLinha = consoleR.nextInt(5);
        int posicaoColuna = consoleR.nextInt(5);
        tabuleiro[posicaoLinha][posicaoColuna][1] = "■";
    }
return tabuleiro;
}
static String [][][] pedirPosicaoInicial (String [][][] tabuleiro){
    Scanner console = new Scanner (System.in);    
    System.out.println("Posicione os seus submarinos");
    for (int i = 1;i <= 5;i++){
    System.out.print("Insira a linha: ");
    int linha = console.nextInt();    
    System.out.print("Insira a coluna: ");
    int coluna = console.nextInt();
     while (linha >=5 || coluna >= 5){
        System.out.println("Número de colunas ou linhas inválidos");
        System.out.println("Tente denovo");
        System.out.println("Qual posição?");
        System.out.print("Linha: ");
        linha = console.nextInt();
        System.out.print("Coluna: ");
        coluna = console.nextInt();
    }
    if (tabuleiro[linha][coluna][0]== "■"){
        System.out.println("Submarino já posicionado nesse local, escolha um novo ");
        System.out.print("Insira a linha: ");
        linha = console.nextInt();    
        System.out.print("Insira a coluna: ");
        coluna = console.nextInt();
    }
    tabuleiro[linha][coluna][0] = "■";
//    monstraTabuleiro(tabuleiroJogador, n);
    System.out.println((5-i)+" submarinos restantes...");
}
return tabuleiro;
}
static String [][][] jogada (String [][][] tabuleiroMaquina){
    Scanner console = new Scanner (System.in);
    System.out.println("Qual posição?");
    System.out.print("Linha: ");
    int linha = console.nextInt();
    System.out.print("Coluna: ");
    int coluna = console.nextInt();
    while (linha >=5 || coluna >= 5){
        System.out.println("Número de colunas ou linhas inválidos");
        System.out.println("Tente denovo");
        System.out.println("Qual posição?");
        System.out.print("Linha: ");
        linha = console.nextInt();
        System.out.print("Coluna: ");
        coluna = console.nextInt();
    }
    
    if (tabuleiroMaquina[linha][coluna][1] == "¤" || tabuleiroMaquina[linha][coluna][1] == "×"){
        System.out.println("Local já atingido! tente denovo");
        System.out.println("Qual posição?");
        System.out.print("Linha: ");
        linha = console.nextInt();
        System.out.print("Coluna: ");
        coluna = console.nextInt();
    }
    if (tabuleiroMaquina[linha][coluna][1] == "■"){
        tabuleiroMaquina[linha][coluna][1] = "¤";
        System.out.print("Submarino inimigo atingindo! ");
        tabuleiroMaquina[linha][coluna][0] = "¤";
        informaSub();
    } else if (tabuleiroMaquina[linha][coluna][1] == "~"){
        
        tabuleiroMaquina[linha][coluna][1] = "×";
        tabuleiroMaquina[linha][coluna][0] = "×";
    }
  
   
   return tabuleiroMaquina; 
}
static String [][][] jogadaMaquina(String[][][] tabuleiroJogador){
    Random consoleR = new Random();
    int linha = consoleR.nextInt(5);
    int coluna = consoleR.nextInt(5);
    while ((tabuleiroJogador[linha][coluna][0] == "¤") || (tabuleiroJogador[linha][coluna][0] == "×")){
    linha = consoleR.nextInt(5);
    coluna = consoleR.nextInt(5);   
    }
    if (tabuleiroJogador[linha][coluna][0] == "■"){
        tabuleiroJogador[linha][coluna][0] = "¤";
        System.out.println("Submarino aliado atingido!");
        informaSubAliado();
    } else if (tabuleiroJogador[linha][coluna][0] == "~"){
        tabuleiroJogador[linha][coluna][0] = "×";
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
public static void cor(String cor) {
        int valor = 0;

        switch (cor.toLowerCase()) {
            case "preto":
            case "preta":
                valor = 30;
                break;
            case "vermelho":
            case "vermelha":
                valor = 31;
                break;
            case "verde":
                valor = 32;
                break;
            case "amarelo":
            case "amarela":
                valor = 33;
                break;
            case "azul":
                valor = 34;
                break;
            case "magenta":
                valor = 35;
                break;
            case "ciano":
                valor = 36;
                break;
            case "branco":
            case "branca":
                valor = 37;
                break;
        }

        System.out.printf("\u001b[%dm", valor);
    }
static void intro (){
    Scanner console = new Scanner (System.in);
    System.out.println("Bem vindo ao (!NOTguerraFria)");
    cor = "vermelho";
    cor(cor);
    System.out.println("                               o o");
    cor(cor);
    System.out.println("                               o ooo");
    cor(cor);
    System.out.println("                                 o oo");
    cor(cor);
    System.out.println("                                    o o      |   #)");
    cor(cor);
    System.out.println("                                     oo     _|_|_#_");
    cor(cor);
    System.out.println("                                       o   | URSS  |");
    cor(cor);
    System.out.println("  __                    ___________________|       |_________________");
    cor(cor);
    System.out.println(" |   -_______-----------                                              \\");
    cor(cor);
    System.out.println(">|    _____                                                   --->     )");
    cor(cor);
    System.out.println(" |__ -     ---------_________________________________________________ /");
    cor(cor);
    System.out.println("");
    cor = "azul";
    cor(cor);
    System.out.println("                                          o o");
    cor(cor);
    System.out.println("                                            o ooo");
    cor(cor);
    System.out.println("                                                o oo");
    cor(cor);
    System.out.println("                                                    o o      |    ");
    cor(cor);
    System.out.println("                                                   oo     _|_|_#_");
    cor(cor);
    System.out.println("                                                     o   | USA   |");
    cor(cor);
    System.out.println("                __                    ___________________|       |_________________");
    cor(cor);
    System.out.println("               |   -_______-----------                                              \\");
    cor(cor);
    System.out.println("              >|    _____                                                   --->     )");
    cor(cor);
    System.out.println("               |__ -     ---------_________________________________________________ /");
    cor(cor);
    System.out.println("");
    System.out.print("Deseja ler as regras? ");
    System.out.println("");
    String condicao = console.next();
    condicao = condicao.toLowerCase();
    System.out.println("");
    if (condicao.equalsIgnoreCase("sim") || condicao.equalsIgnoreCase("ss") || condicao.equalsIgnoreCase("s")){
        cor = "verde";
        cor(cor);
        System.out.println("(!NOTguerraFria) é um jogo de tabuleiro, no qual você têm de adivinhar em que localização estão os submarinos do oponente.");
        cor(cor);
        System.out.println("Os submarinos ocupam uma posição do tabuleiro. No total são *5* submarinos para cada tabuleiro");
        cor(cor);
        System.out.println("Ganha quem destruir todos os submarinos primeiro!");
    }
    System.out.println("");
    System.out.println("selecione uma nação: ");
    System.out.println("Digite 1 para a URSS ou");
    System.out.println("");
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
    String cor = "ciano";
//    fundo(cor);
    boolean condicao1 = false;
    
    do {
        
        intro();
        System.out.println("");
        cor = "vermelho";
        cor(cor);
        System.out.println("Objetivo: Destrua todos os submarinos nucleares da" +computador);
        String [][][] tabuleiroMaquina = criatabuleiro();
        tabuleiroMaquina = inicializatabuleiro(tabuleiroMaquina);
        tabuleiroMaquina = sorteiaPosicao(tabuleiroMaquina);
        String [][][] tabuleiroJogador = criatabuleiro();
        tabuleiroJogador = inicializatabuleiro(tabuleiroJogador);

        monstraTabuleiro(tabuleiroJogador, n, n);
        tabuleiroJogador = pedirPosicaoInicial(tabuleiroJogador);
        
        while(!(subs == 0 || subsaliado == 0)){
        monstraTabuleiro(tabuleiroJogador, n, n);
        monstraTabuleiro(tabuleiroMaquina, n, n1);
        tabuleiroMaquina = jogada(tabuleiroMaquina);
        tabuleiroJogador = jogadaMaquina(tabuleiroJogador);

        if( subs == 0){
           
            cor = "verde";
            cor(cor);
            System.out.println("Parabéns!!!!!");
            cor(cor);
            System.out.println("__    __  _____   _   _        _          __  _____   __   _  ");  
            cor(cor);
            System.out.println("\\ \\  / / /  _  \\ | | | |      | |        / / /  _  \\ |  \\ | | ");
            cor(cor);
            System.out.println(" \\ \\/ /  | | | | | | | |      | |  __   / /  | | | | |   \\| | ");
            cor(cor);
            System.out.println("  \\  /   | | | | | | | |      | | /  | / /   | | | | | |\\   | ");
            cor(cor);
            System.out.println("  / /    | |_| | | |_| |      | |/   |/ /    | |_| | | | \\  | ");
            cor(cor);
            System.out.println(" /_/     \\_____/ \\_____/      |___/|___/     \\_____/ |_|  \\_| ");
            break;
        }
        if (subsaliado == 0){
            cor = "vermelho";
            cor(cor);
            System.err.println("Seus submarinos foram todos afundados...");
            cor(cor);
            System.err.println(" _____       ___       ___  ___   _____        _____   _     _   _____   _____   ");
            cor(cor);
            System.err.println("/  ___|     /   |     /   |/   | | ____|      /  _  \\ | |   / / | ____| |  _  \\  ");
            cor(cor);
            System.err.println("| |        / /| |    / /|   /| | | |__        | | | | | |  / /  | |__   | |_| |  ");
            cor(cor);
            System.err.println("| |  _    / / | |   / / |__/ | | |  __|       | | | | | | / /   |  __|  |  _  /  ");
            cor(cor);
            System.err.println("| |_| |  / /  | |  / /       | | | |___       | |_| | | |/ /    | |___  | | \\ \\  ");
            cor(cor);
            System.err.println("\\_____/ /_/   |_| /_/        |_| |_____|      \\_____/ |___/     |_____| |_|  \\_\\ ");
            break;
        }
        
    }
        condicao1 = jogarNovamente(condicao1);
} while (condicao1 == true);
        
 }
}