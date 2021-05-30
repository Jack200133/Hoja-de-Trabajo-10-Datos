import java.util.ArrayList;
import java.util.HashMap;

public class Floyd {

    private Integer[][] P;
    private Integer[][] M;
    public void recacl(Integer[][] Matrix){
        P = new Integer[Matrix.length][Matrix.length];
        M = Matrix;
        for (int x = 0; x < P.length; x++) {
            for (int y = 0; y < P.length; y++) {
                P[x][y]= 0;
            }
        }
        for (int k = 0; k < M.length; k++) {
            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < M.length; j++) {
                    int cambio = M[i][j];
                    int a = M[i][k];
                    int b = M[k][j];

                    if(cambio>a+b){
                        M[i][j]=(a+b);
                        P[i][j] = k;
                    }
                }
            }
        }

    }


    public void path(int q, int r, ArrayList lug){

        if(P[q][r]!=0){
            path(q,P[q][r],lug);
            System.out.println("Pasa por -" + lug.get(P[q][r]));
            path(P[q][r],r,lug);
        }
    }

    public String centro(Integer [][] M2,ArrayList lug)
    {
        HashMap<Integer,Integer> posiciones = new HashMap<>();
        int x=0,y=0;
        int [] menor= new int[M2.length];
        for (int i=1;i< M2.length;i++)
        {
            for (int j=1; j<M2.length;j++)
            {
                if((M2[i][j])>menor[i]) {
                    menor[i]=(M2[i][j]);
                    x=i;

                }
            }
            posiciones.put(menor[i],x);

        }
        int menor2=0;
        for (int i =0;i<menor.length-1;i++)
        {
            menor2 = Math.min(menor[i], menor[i + 1]);
        }


        System.out.println("\nEl centro del grafo es: -"+ lug.get(posiciones.get(menor2)));

        return (String) lug.get(posiciones.get(menor2));
    }
}
