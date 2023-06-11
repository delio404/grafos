package br.com.delios.grafo.core;

public class Vertice {
    private String rotulo;
    private int grau;

    public Vertice(String rotulo) throws Exception{
        boolean isRotuloNullOrBlanck = rotulo == null || rotulo !=null && "".equals(rotulo.trim());
        if (isRotuloNullOrBlanck) {
            throw new Exception("nao e permitida a inclusao de vertice com rotulos em branco");
        }
        this.rotulo=rotulo;
        }

    public String getRotulo() {
        return rotulo;
    }
}
