package br.com.delios.grafo.core;

import java.util.List;

public class MatrizAdjacencia {
    private  int[][] matriz;
    private List<Vertice> vertices;

    private int qtdVertices;
    private void iniciarlizarMatriz( int indeceVerticeInicial, int indiceVerticeFinal) {
        Vertice verticeInicial =vertices.get(indeceVerticeInicial);
        Vertice verticeFinal= vertices.get(indiceVerticeFinal);
        if (indeceVerticeInicial == indiceVerticeFinal) {
            matriz[indeceVerticeInicial][indeceVerticeInicial]=1;
        }
    }
    public MatrizAdjacencia(List<Vertice> vertices) {
        this.vertices = vertices;
        this.qtdVertices = vertices.size();
        this.matriz = new int[qtdVertices][qtdVertices];
        iniciarlizarMatriz();
    }


}
