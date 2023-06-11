package br.com.delios.grafo.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Grafo {
    private int qtdMaximaVertices;

    private boolean isQtdMaximaDefinida;
    private  int qtdAtualVertices=0;
    private  Map <String , Integer> rotulosEmIndices= new HashMap<String, Integer>();
    private List<Vertice> vertices= new ArrayList<Vertice>();

    public Grafo(){
        qtdMaximaVertices=10;
    }
    public Grafo(int qtdMaximaVertices) {
        if(qtdMaximaVertices <=0){
            throw new IllegalArgumentException(" A quantidade maxima de vertices deve ser maior ou igual a 1 .");
        }
        qtdMaximaVertices= qtdMaximaVertices;
        isQtdMaximaDefinida=true;
    }
}
