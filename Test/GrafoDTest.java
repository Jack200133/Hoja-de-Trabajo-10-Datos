import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GrafoDTest {

    @Test
    void existeArista() {
        GrafoD g = new GrafoD(6);
        g.insertarArista(1, 2, 3);
        g.insertarArista(1, 5, 8);
        g.insertarArista(2, 5, 9);
        g.insertarArista(3, 6, 5);
        System.out.println("El grafo es: "+g.toString());
        System.out.println("existeArista(3,1) = " + g.existeArista(3,1));
        ListaConPI<Adyacente> l = g.adyacentesDe(1);
        System.out.println("Los adyacentes al vértice 1 son: ");
        for (l.inicio(); !l.esFin(); l.siguiente()) {
            System.out.println("(1, " + l.recuperar().destino + ")");
        }
        assertFalse(g.existeArista(3,1));
    }

    @Test
    void insertarArista() {
        GrafoD g = new GrafoD(6);
        g.insertarArista(1, 2, 3);
        g.insertarArista(1, 5, 8);
        g.insertarArista(2, 5, 9);
        g.insertarArista(3, 6, 5);

        assertTrue(g.existeArista(1,2));
    }

    @Test
    void borrarValores() {
        GrafoD g = new GrafoD(6);
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        Integer[][] matriz  = new Integer[list.size()][list.size()];


        g.insertarArista(1, 2, 3);
        g.insertarArista(1, 5, 8);
        g.insertarArista(2, 5, 9);
        g.insertarArista(3, 6, 5);

        for (int x = 0; x < list.size(); x++) {
            for (int y = 0; y < list.size(); y++) {
                if(x==y){
                    matriz[x][y] = 0;
                }
                else if(g.existeArista(x+1,y+1)){
                    matriz[x][y] = g.pesoArista(x+1,y+1);
                }
                else{
                    matriz[x][y] = 1000000;
                }
            }
        }

        g.BorrarValores(matriz);
        assertTrue(g.existeArista(1,2));
    }

    @Test
    void cambiarValores() {
        GrafoD g = new GrafoD(6);
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);
        Integer[][] matriz  = new Integer[list.size()][list.size()];


        g.insertarArista(1, 2, 3);
        g.insertarArista(1, 5, 8);
        g.insertarArista(2, 5, 9);
        g.insertarArista(3, 6, 5);

        for (int x = 0; x < list.size(); x++) {
            for (int y = 0; y < list.size(); y++) {
                if(x==y){
                    matriz[x][y] = 0;
                }
                else if(g.existeArista(x+1,y+1)){
                    matriz[x][y] = g.pesoArista(x+1,y+1);
                }
                else{
                    matriz[x][y] = 1000000;
                }
            }
        }
        System.out.println(g);
        g.CambiarValores(matriz);
        System.out.println(g);
        assertNotEquals(9,g.pesoArista(1,2));
    }
}