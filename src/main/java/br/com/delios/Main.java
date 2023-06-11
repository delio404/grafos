package br.com.delios;

import br.com.delios.grafo.core.Grafo;
import br.com.delios.grafo.core.Vertice;

public class Main {
    public static void main(String[] args) throws Exception {
        Grafo grafo= new Grafo();
        grafo.adiconarVertice("RJ");
        grafo.adiconarVertice("SB");
        grafo.adiconarVertice("BH");
        grafo.adiconarVertice("PT");
        grafo.adiconarVertice("OS");
        grafo.adiconarVertice("SV");
        grafo.adiconarVertice("CR");
        grafo.adiconarVertice("PA");

        System.out.println("O grafo G possoui os seguintes verices \n");

        for(Vertice vertice: grafo.getVertices()){
            System.out.println("\t\t  " +"__Vertice ->   "+ vertice.getRotulo()+"\n");
        }

        System.out.println("Hello world  !");
    }
}