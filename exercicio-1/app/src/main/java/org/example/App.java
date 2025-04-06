package org.example;

public class App {
 
    static void triangulo(int n){
        int i, j; 

        for( i = 1; i <= n; i++){
            for(j = n - i; j >= 1; j--){
                System.out.print(" ");
            }
            for( j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void retangulo (int linhas, int colunas){
        int i, j; 

        for(i = 1; i <= linhas; i++ ){
            for(j=1;j<=linhas; j++){
                if(j == 1 || j == linhas || i ==1|| i == linhas){
                    System.out.print("*");
            }else{
                System.out.print(" ");
            }
        }
        System.out.println("");
    }

    }

    static void losango(int tamanho){
        int i, j, espacos, meio = tamanho / 2;

        for (i = 0; i <= meio; i++) {
            espacos = meio - i;
            for (j = 0; j < espacos; j++) {
                System.out.print(" ");
            }
            for (j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    

        for (i = meio - 1; i >= 0; i--) {
            espacos = meio - i;
            for (j = 0; j < espacos; j++) {
                System.out.print(" ");
            }
            for (j = 0; j < (2 * i + 1); j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        }
    

    public static void main(String[] args) {
        String forma;
        int linhas, colunas, tamanho;

        if(args.length < 2){
            System.out.println("Argumentos insuficientes!");
        }
        if(args.length == 2){
            forma = args[0];
            tamanho = Integer.parseInt(args[1]);

            // Se caso for fornecido um triangulo sem colunas
            if(forma.equals("retangulo")){
                System.out.println("Informe a coluna do retângulo!");
            }
            if(forma.equals("triangulo")){
                triangulo(tamanho);
            }else if(forma.equals("losango")){
                losango(tamanho);
            }
        }else{
            forma = args[0];
            linhas = Integer.parseInt(args[1]);
            colunas = Integer.parseInt(args[2]);
            if(forma.equals("retangulo")){
                retangulo(linhas, colunas);
            }
        }
    }
}
