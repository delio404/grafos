package br.com.delios.grafo.search;

import br.com.delios.grafo.core.Grafo;
import br.com.delios.grafo.core.Vertice;

import java.util.*;

public class BuscaEmLargura {
    private static BuscaEmLargura instance;
//    private BuscaEmLargura(){}
//    public  static BuscaEmLargura getInstance(){
//        if (instance==null){
//            return new BuscaEmLargura();
//        }
//        return instance;
//    }
public List<String> buscar(Grafo grafo, String origem , String destino){
    Queue<String> roloDeBarbante = new LinkedList<String>();
    LinkedHashSet<String> verticesVisitados = new LinkedHashSet<String>();
    Caminho caminho= new Caminho();

    roloDeBarbante.add(origem);

    while (!roloDeBarbante.isEmpty()){
        String v = roloDeBarbante.poll();
        if(v.equals(destino)){
            break;
        }
        for (Vertice u : grafo.getAdjacencias(v)){
            String rotulo = u.getRotulo();
            if(!verticesVisitados.contains(rotulo)){
                verticesVisitados.add(rotulo);
                caminho.ligar(rotulo, v);
                roloDeBarbante.add(rotulo);
            }
        }
    }

    return caminho.gerar(origem,destino);
}
}
