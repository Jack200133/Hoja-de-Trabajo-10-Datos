import java.util.ArrayList;

class Adyacente{
    int destino;
    int peso;
    Adyacente(int codAdy, double p){ destino=codAdy; peso = (int) p; }
    public String toString(ArrayList lug)
    {
        return lug.get(destino-1) + "("+ peso + ")";
    }
    public String toString()
    {
        return destino + "("+ peso + ")";
    }
}