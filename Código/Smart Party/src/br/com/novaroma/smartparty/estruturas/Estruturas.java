
package br.com.novaroma.smartparty.estruturas;

import java.util.Random;

public class Estruturas {
   
    private static Arvore arvore = new Arvore();
    private static List list = new List();
    private static Fila fila = new Fila();
    private static Pilha pilha = new Pilha();

    public static Arvore getArvore() {
        return arvore;
    }

    public static void setArvore(Arvore arvore) {
        Estruturas.arvore = arvore;
    }

    public static List getList() {
        return list;
    }

    public static void setList(List list) {
        Estruturas.list = list;
    }

    public static Fila getFila() {
        return fila;
    }

    public static void setFila(Fila fila) {
        Estruturas.fila = fila;
    }

    public static Pilha getPilha() {
        return pilha;
    }

    public static void setPilha(Pilha pilha) {
        Estruturas.pilha = pilha;
    }
    
    public static int gerarCodigoPilha() {
        
        Random random = new Random();

        int codeRandom;
        boolean boo = true;

        do {
            codeRandom = random.nextInt(10000) + 1;
            boo = verificarCodigoPilha(codeRandom, pilha);
        } while (boo);

        return codeRandom;
    }
    
    private static boolean verificarCodigoPilha(int code, Pilha stack) {
        return stack.contains(String.valueOf(code));
    }
    
    public static int gerarCodigoLista() {
        
        Random random = new Random();

        int codeRandom;
        boolean boo = true;

        do {
            codeRandom = random.nextInt(10000) + 1;
            boo = verificarCodigoLista(codeRandom, list);
        } while (boo);

        return codeRandom;
    }
    
    private static boolean verificarCodigoLista(int code, List list) {
        return list.contains(String.valueOf(code));
    }
    /*
    public static int generateCodeOnHash() {
        
        Random random = new Random();

        int codeRandom;
        boolean boo = true;

        do {
            codeRandom = random.nextInt(99999) + 1;
            boo = verifyCodeOnHash(codeRandom, hash);
        } while (boo);

        return codeRandom;
    }
    
    private static boolean verifyCodeOnHash(int code, Hash hash) {
        return hash.contains(String.valueOf(code));
    }*/
}
