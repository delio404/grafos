package br.com.delios.grafo.search;

import br.com.delios.grafo.core.Grafo;
import br.com.delios.grafo.core.Vertice;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

public class BuscaEmProfunidade {
    private static BuscaEmProfunidade instance;
    private BuscaEmProfunidade(){}
    public  static BuscaEmProfunidade getInstance(){
        if (instance==null){
            return new BuscaEmProfunidade();
        }
        return instance;
    }

    public List<String> buscar(Grafo grafo, String origem ,String destino){
        Stack<String> roloDeBarbante = new Stack<String>();
        LinkedHashSet<String> verticesVisitados = new LinkedHashSet<String>();
        Caminho caminho= new Caminho();

        roloDeBarbante.push(origem);

        while (!roloDeBarbante.empty()){
            String v = roloDeBarbante.pop();
            if(v.equals(destino)){
                break;
            }
            for (Vertice u : grafo.getAdjacencias(v)){
                String rotulo = u.getRotulo();
                if(!verticesVisitados.contains(rotulo)){
                    verticesVisitados.add(rotulo);
                    caminho.ligar(rotulo, v);
                    roloDeBarbante.push(rotulo);
                }
            }
        }

        return caminho.gerar(origem,destino);
    }
}
