import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FloydTest {

    @Test
    void recacl() {
        Floyd fl = new Floyd();
        GrafoD g = new GrafoD(6);
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("3");
        list.add("6");
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
        fl.recacl(matriz);
        int x = matriz[0][4];
        assertEquals(8,x);
    }

    @Test
    void centro() {
        Floyd fl = new Floyd();
        GrafoD g = new GrafoD(6);
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("5");
        list.add("3");
        list.add("6");
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

        assertEquals("6",fl.centro(matriz,list));
    }
}