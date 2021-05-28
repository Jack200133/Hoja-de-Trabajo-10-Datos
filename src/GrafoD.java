import java.util.ArrayList;

public class GrafoD extends Grafo {
    protected int numV, numA;
    protected ListaConPI[] elArray;

    public GrafoD(int numVertices){
        numV = numVertices;
        numA=0;
        elArray = new ListaConPI[numVertices+1];
        for (int i=1; i<=numV; i++)elArray[i]= new LEGListaConPI<Adyacente>();
    }
    public int numVertices()
    {
        return numV;
    }
    public int numAristas()
    {
        return numA;
    }
    public boolean existeArista(int i, int j)
    {
        ListaConPI<Adyacente> l = elArray[i];
        boolean esta=false;
        for (l.inicio(); !l.esFin()&& !esta; l.siguiente())
            if (l.recuperar().destino==j) esta =true;
        return esta;
    }
    public int pesoArista(int i, int j)
    {
        ListaConPI<Adyacente> l = elArray[i];
        for (l.inicio(); !l.esFin(); l.siguiente())
            if (l.recuperar().destino==j) return l.recuperar().peso;
        return 0;
    }public void insertarArista(int i, int j) {
        insertarArista(i,j,1);
    }
    public void insertarArista(int i, int j, double p) {
        if ( !existeArista(i,j) ) { elArray[i].insertar(new Adyacente(j,p)); numA++; }
    }
    public ListaConPI<Adyacente> adyacentesDe(int i) {return elArray[i];}

    public String toString(ArrayList lug){
        StringBuilder res = new StringBuilder();
        for (int i = 1 ; i <= lug.size() ; i++) {

            res.append("Vértice: ").append(lug.get(i - 1));
            ListaConPI<Adyacente> l = adyacentesDe(i);
            res.append((l.esVacia()) ? " sin Adyacentes " : " con Adyacentes: ");
            for (l.inicio(); !l.esFin() ; l.siguiente()) res.append(l.recuperar().toString(lug)).append(" ");
            res.append("\n");
        } return res.toString();
    }
}