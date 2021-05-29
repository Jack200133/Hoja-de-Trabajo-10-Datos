import java.util.ArrayList;
import java.util.Scanner;

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

    public void BorrarValores(Integer[][] matriz,ArrayList lugares){
        Scanner scan = new Scanner(System.in);
        String origen ="";
        String destino="";
        boolean existe = false;
        while (!existe) {
            System.out.println("Lugares Disponibles:" + lugares);
            System.out.println("Ingrese el lugar de Origen");
            origen = scan.nextLine();

            if (lugares.contains(origen)) {
                existe = true;
            } else {
                System.out.println("Ingrese un lugar Valido");
            }
        }
        existe = false;
        while (!existe) {
            System.out.println("Lugares Disponibles:" + lugares);
            System.out.println("Ingrese el lugar de Destino");
            destino = scan.nextLine();

            if (lugares.contains(destino)) {
                existe = true;
            } else {
                System.out.println("Ingrese un lugar Valido");
            }
        }
        int q = lugares.indexOf(origen);
        int r = lugares.indexOf(destino);

        matriz[q][r] = 1000000;
    }

    public void CambiarValores(Integer[][] matriz, ArrayList lugares){
        Scanner scan = new Scanner(System.in);
        boolean existe = false;
        String origen ="";
        String destino="";
        while (!existe) {
            System.out.println("Lugares Disponibles:" + lugares);
            System.out.println("Ingrese el lugar de Origen");
            origen = scan.nextLine();

            if (lugares.contains(origen)) {
                existe = true;
            } else {
                System.out.println("Ingrese un lugar Valido");
            }
        }
        existe = false;
        while (!existe) {
            System.out.println("Lugares Disponibles:" + lugares);
            System.out.println("Ingrese el lugar de Destino");
            destino = scan.nextLine();

            if (lugares.contains(destino)) {
                existe = true;
            } else {
                System.out.println("Ingrese un lugar Valido");
            }
        }
        System.out.println("Ingrese el valor del arco");
        int valor = scan.nextInt();

        int q = lugares.indexOf(origen);
        int r = lugares.indexOf(destino);
        matriz[q][r] = valor;
    }

    public void BorrarValores(Integer[][] matriz){
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("3");
        list.add("2");
        list.add("5");
        list.add("6");
        String origen ="";
        String destino="";

        origen = "1";
        destino = "2";

        int q = list.indexOf(origen);
        int r = list.indexOf(destino);


        matriz[q][r] = 1000000;
    }

    public void CambiarValores(Integer[][] matriz){
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("3");
        list.add("2");
        list.add("5");
        list.add("6");
        String origen ="";
        String destino="";

        origen = "1";
        destino = "2";
        int valor = 9;

        int q = list.indexOf(origen);
        int r = list.indexOf(destino);

        matriz[q][r] = valor;
    }

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