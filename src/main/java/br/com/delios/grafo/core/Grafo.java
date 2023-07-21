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
    private MatrizAdjacencia matrizAdjacencia;

    public Vertice getVertice(String rotulo){
        this.existeVerticeOrThrow(rotulo);
        int indice= this.rotulosEmIndices.get(rotulo);

        return this.vertices.get(indice);
    }

    public void conectarVertices(String rotuloVerticeInicial, String rotuloVerticeFinal) throws Exception{
        if(!this.existeVertice(rotuloVerticeInicial)|| !this.existeVertice(rotuloVerticeFinal)){
            throw new Exception("Para adicionar uma aresta ambos os vertices devem existir");
        }
        criarMatrizAdjacencia();
        int indiceVerticeFinal= this.rotulosEmIndices.get(rotuloVerticeInicial);
        int indiceVerticeInicial=this.rotulosEmIndices.get(rotuloVerticeFinal);
        this.matrizAdjacencia.adicionarAresta(indiceVerticeInicial, indiceVerticeFinal);
    }

    public List<Vertice> getAdjacencias(String vertice){
        this.existeVerticeOrThrow(vertice);
        int indiceVertice= this.rotulosEmIndices.get(vertice);
        return this.matrizAdjacencia.getAdjacencias(indiceVertice);
    }
    private boolean existeVerticeOrThrow(String vertice) {
        if(!existeVertice(vertice)){
            throw new IllegalArgumentException("O vertice nao existe");
        }
        return true;
    }
    private boolean existeVertice(String rotuloVertice) {
        int indice= this.rotulosEmIndices.get(rotuloVertice);
        return this.vertices.get(indice) != null ? true : false;
    }

    private void criarMatrizAdjacencia(){
       if(this.matrizAdjacencia == null){
           this.matrizAdjacencia= new MatrizAdjacencia(new ArrayList<>(this.vertices));
       }
    }
//    private void existeVerticeOrThrow(String rotulo) {
//        //if(!existeVertice(vertice))
//    }

    public Grafo(){
        qtdMaximaVertices=15;
    }
    public Grafo(int qtdMaximaVertices) {
        if(qtdMaximaVertices <=0){
            throw new IllegalArgumentException(" A quantidade maxima de vertices deve ser maior ou igual a 1 .");
        }
        qtdMaximaVertices= qtdMaximaVertices;
        isQtdMaximaDefinida=true;
    }

    public void adiconarVertice(String rotulo) throws Exception{
        if(qtdAtualVertices <= qtdMaximaVertices -1){
            Vertice novoVertice= new Vertice(rotulo);
            this.vertices.add(novoVertice);
            this.rotulosEmIndices.put(rotulo, qtdAtualVertices);
            qtdAtualVertices++;
        }else {
            throw new Exception(" A quantidade de vertices permitidas ( "+ qtdMaximaVertices +" ) foi execidida. ");
        }
    }

    public List<Vertice>getVertices(){
        return this.vertices;
    }



}
