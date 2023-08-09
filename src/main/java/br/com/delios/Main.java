package br.com.delios;

import br.com.delios.grafo.core.Grafo;
import br.com.delios.grafo.core.Vertice;
import br.com.delios.grafo.search.BuscaEmLargura;
import br.com.delios.grafo.search.BuscaEmProfunidade;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Grafo grafo= new Grafo();
        grafo.adiconarVertice("A");
        grafo.adiconarVertice("B");
        grafo.adiconarVertice("C");
        grafo.adiconarVertice("D");
        grafo.adiconarVertice("E");
        grafo.adiconarVertice("F");
        grafo.adiconarVertice("G");
        grafo.adiconarVertice("H");
        grafo.adiconarVertice("I");
        grafo.adiconarVertice("J");
        grafo.adiconarVertice("K");

        grafo.conectarVertices("A","B");
        grafo.conectarVertices("A","C");
        grafo.conectarVertices("A","D");
        grafo.conectarVertices("B","F");
        grafo.conectarVertices("B","I");
        grafo.conectarVertices("D","G");
        grafo.conectarVertices("D","A");
        grafo.conectarVertices("D","D");
        grafo.conectarVertices("I","J");
        grafo.conectarVertices("I","K");
        grafo.conectarVertices("J","K");
        grafo.conectarVertices("E","A");

        List<String> caminho= BuscaEmProfunidade.getInstance().buscar(grafo,"D","K");
        System.out.println("Caminho feito pela busca em profundidade ");

        for(String passo:caminho) {
            System.out.println(" \t\t "+passo + " ");
        }
        caminho= BuscaEmLargura.getInstance().buscar(grafo,"B","G");
        System.out.println();
        System.out.println("Caminho feito por uma busca em largura");
        for (String passo: caminho){
            System.out.println(" \t\t "+passo + " ");
        }

        Grafo arvore = grafo.arvoreGeradoraPorProfundidade();
        System.out.println("\n");
        System.out.println("\t\t------ Arvore Geradora ----\n");
        System.out.println("\t\t\t\t----- Vertices ----");
        for (Vertice v: arvore.getVertices()){
            System.out.println("\t\t\t\t\t\t  "+v.getRotulo());
        }

        System.out.println("\n\t\t \t\t ----- Arestas ----");
        for (Vertice v: arvore.getVertices()){
            for (Vertice adj: arvore.getAdjacencias(v.getRotulo())){
                System.out.println("\t\t\t\t \t\t  "+v.getRotulo()+adj.getRotulo());
            }
        }



        //        Grafo grafo= new Grafo();
//        grafo.adiconarVertice("A");
//        grafo.adiconarVertice("B");
//        grafo.adiconarVertice("C");
//        grafo.adiconarVertice("D");
//
//        grafo.conectarVertices("A","B");
//
//        grafo.conectarVertices("A","D");
//
//        grafo.conectarVertices("A","C");
//
//        System.out.println("\t\t\t\t  Grau do vertice A : " + grafo.getVertice("A").getGrau());
//
//        System.out.println("\t\t\t\t  Grau do vertice D : " + grafo.getVertice("D").getGrau());
//
//        System.out.println("\t\t\t\t  Grau do vertice C : " + grafo.getVertice("C").getGrau());
//
//        System.out.println(" \n");
//
//        System.out.println("\t\t\t\t  O  Vertice A possui as seguintes adjacencias: ");
//        List<Vertice> adjacentes=grafo.getAdjacencias("A");
//        for(Vertice vertice: adjacentes){
//            System.out.println("\t\t\t\t \t\t\t\t __  "+vertice.getRotulo()+" ");
//        }
//
//        System.out.println("\n");
//
//        System.out.println("\t\t\t\t O  Vertice C possui as seguintes adjacencias: ");
//        adjacentes=grafo.getAdjacencias("C");
//        for(Vertice vertice: adjacentes){
//            System.out.println("\t\t\t\t \t\t\t\t __  "+vertice.getRotulo()+" ");
//        }
//
//        System.out.println("\n");
//        System.out.println("\t\t\t\t O  Vertice D possui as seguintes adjacencias: ");
//        adjacentes=grafo.getAdjacencias("D");
//        for(Vertice vertice: adjacentes){
//            System.out.println("\t\t\t\t \t\t\t\t __  "+vertice.getRotulo()+" ");






//        grafo.adiconarVertice("RJ");
//        grafo.adiconarVertice("SB");
//        grafo.adiconarVertice("BH");
//        grafo.adiconarVertice("PT");
//        grafo.adiconarVertice("OS");
//        grafo.adiconarVertice("SV");
//        grafo.adiconarVertice("CR");
//        grafo.adiconarVertice("PA");
//
//        System.out.println("O grafo G possoui os seguintes verices \n");
//        for(Vertice vertice: grafo.getVertices()){
//            System.out.println("\t\t  " +"__Vertice ->   "+ vertice.getRotulo()+"\n");
//        }


    }
}