package br.com.delios.grafo.core;

import java.util.ArrayList;
import java.util.List;

public class MatrizAdjacencia {
    private  int[][] matriz;
    private List<Vertice> vertices;

    private int qtdVertices;
    public MatrizAdjacencia(List<Vertice> vertices) {
        this.vertices = vertices;
        this.qtdVertices = vertices.size();
        this.matriz = new int[qtdVertices][qtdVertices];
        iniciarlizarMatriz();
    }
    void adicionarAresta(int indeceVerticeInicial, int indiceVerticeFinal) {
        Vertice verticeInicial =vertices.get(indeceVerticeInicial);
        Vertice verticeFinal= vertices.get(indiceVerticeFinal);
        if (indeceVerticeInicial == indiceVerticeFinal) {
            matriz[indeceVerticeInicial][indeceVerticeInicial]=1;
            verticeInicial.addGrau();
        }else {
            matriz [indeceVerticeInicial][indiceVerticeFinal]=1;
            verticeInicial.addGrau();
            matriz [indiceVerticeFinal][indeceVerticeInicial]=1;
            verticeFinal.addGrau();

        }

    }
    public List<Vertice> getAdjacencias(int indiceVertice){
       int linha=indiceVertice;
       List<Vertice> adjacencias= new ArrayList<>();
       for (int j=0; j<vertices.size();j++){
           if(matriz[linha][j]==1){
               Vertice vertice=vertices.get(j);
               adjacencias.add(vertice);
           }
       }
       return adjacencias;
    }


    private void iniciarlizarMatriz() {
        for(int i=0; i< matriz.length;i++){
            for(int j=0; j < matriz[i].length;j++){
                matriz[i][j]=0;
            }

        }
    }


}
