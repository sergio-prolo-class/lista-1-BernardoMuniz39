/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.util.Random;

public class App {

    /* A função posicaoValida verifica se o numero e a direção sorteada seram válidos dentro da matriz 10x10. Vale ressaltar que aqui se verifica os casos aonde a quantidade de navios a serem printados iriam "sobrar"
     * para fora da matriz, tanto no caso da horizontal quanto da vertical. Além disso, é feito o tratamento de colisões, onde a cadeia de posições linha x coluna é verificada por completo, para que haja espeaço suficiente
     * para colocar as Strings de identificação dos navios (P, N, E, S e C). A função só irá retornar verdadeiro caso passe por todos os casos de colisão e inválidade de posição. Uma posição válida para a alocação de strings
     * é " .".
    */
    static boolean posicaoValida(int linha, int coluna, boolean  direcao, int qtdNavio, String [][] tabuleiro){

        //A direcao, passada como parâmetro, é sorteada por um gerador booleano, onde: 1=horizontal, 0=vertical

            if(direcao){ //proximo navio a ser colocado é na horizontal
                if(coluna + qtdNavio > 10){ //validando para se caso na horizontal for insuficiente para alocar os navios (sobrando navios para fora)
                    return false;
                }

                //verificando se a linha com n posições a frente está vazia para ser alocado os navios
                for(int i = 0; i < qtdNavio; i++){
                    if(!tabuleiro[linha][coluna ++].equals(" .")){
                        return false; 
                    }
                }
            }else{ //proximo navio a ser colocado é na vertical
                if(linha + qtdNavio > 10){ //validando para se caso na vertical for insuficiente para alocar os navios (sobrando navios para fora)
                    return false;
                }
                //verificando se a coluna com n posições a frente está vazia para ser alocado os navios
                for(int i = 0; i < qtdNavio; i++){
                    if(!tabuleiro[linha++][coluna].equals(" .")){
                        return false;
                    }
                }
            }
            return true; //se não caiu em nenhum if, então a posição é valida.
    }

    /* A função insereNavio tem a função de substituir as previas strings " ." inicalizadas na Main com os caracteres que representam cada navio. É interessante verificar que a próxima linha/coluna a receber o caractere
        tem a expressão coluna + 1, para o caso da direção sorteada ser na horizontal, e linha + 1 para no caso em que a direção é na vertical. A lógica se baseia na premissa de que não se pode ter caracteres impressos
        de maneira aleatória no tabuleiro, e sim de maneira sequencial.  
    
    */
    static void insereNavio(int qtdNavio, int linha, int coluna, String [] [] tabuleiro, String caracter, boolean direcao){

        if(direcao){ //inserir na horizontal
            for(int i = 0; i < qtdNavio; i++){
                tabuleiro[linha][coluna++] = caracter;
            }
        }else{ //inserir na vertical
            for(int k = 0; k < qtdNavio; k++){
                tabuleiro[linha++][coluna] = caracter;
            }
        }
    }

    /* Por fim, a função solve junta as funcionalidades outras das 2 anteriores, onde temos uma variável qtdalocada que é igualada ao numero de navios a serem impressos caso a posição sorteada dentro do loop for válida e 
       e susbtituição das Strings forem feitas com sucesso. Na main cada navio chama essa função passando como parâmetro o seu caracter de identificação, a quantidade a ser impressa e em qual tabuleiro pertence. 
        Vale ressaltar que os caracteres são substituidos de maneira direta na matriz, ou seja, não são feitos um por vez 
     */
    static void solve(int qtdNavio, String [] [] tabuleiro, String caracter){
        int qtdcolocada = 0, colunas, linhas;
        boolean VH;
        Random r = new Random(); //sorteador


        while(qtdcolocada < qtdNavio){
            colunas = r.nextInt(10); //sorteia um numero de 0 até 10 para as colunas
            linhas = r.nextInt(10); //sortei um numero de 0 até 10 para as linhas
            VH = r.nextBoolean(); //sortei se a proxíma posição a ser colocada vai ser na horizontal ou vertical (0 = horizontal, 1= vertical)
            
            if(posicaoValida(linhas, colunas, VH, qtdNavio, tabuleiro)){
                insereNavio(qtdNavio, linhas, colunas, tabuleiro, caracter, VH);
                qtdcolocada = qtdNavio;
            }
            
        }
    
    }

    public static void main(String[] args) {

        String [] [] tabuleiro = new String[10][10];

        //Inicio a matriz inteira com a string " ."
        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10 ; j++){
               tabuleiro[i][j] = " .";
            }
        }

        //Insere os navios no tabuleiro de acordo com cada sigla
        solve(5, tabuleiro, " P");
        solve(4, tabuleiro, " E");
        solve(3, tabuleiro, " C");
        solve(3, tabuleiro, " S");
        solve(2, tabuleiro, " N");
    
        //Printar a matriz 
        for(int i = 0; i < 10 ; i++){
            for(int j = 0; j < 10 ; j++){
              System.out.print(tabuleiro[i][j]);
            }
            System.out.println("");
        } 
    }
}