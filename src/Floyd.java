import java.util.ArrayList;
import java.util.Arrays;

public class Floyd {

    Integer[][] P;

    public Integer[][] recacl(Integer[][] Matrix){
        P = new Integer[Matrix.length][Matrix.length];
        for (int x = 0; x < P.length; x++) {
            for (int y = 0; y < P.length; y++) {
                P[x][y]= 0;
            }
        }
        for (int k = 0; k < Matrix.length; k++) {
            for (int i = 0; i < Matrix.length; i++) {
                for (int j = 0; j < Matrix.length; j++) {
                    int cambio = Matrix[i][j];
                    int a = Matrix[i][k];
                    int b = Matrix[k][j];

                    if(cambio>a+b){
                        Matrix[i][j]=(a+b);
                        P[i][j] = k;
                    }
                }
            }
        }

        return Matrix;
    }


    public void path(int q, int r, ArrayList lug){

        if(P[q][r]!=0){
            path(q,P[q][r],lug);
            System.out.println("Pasa por -" + lug.get(P[q][r]));
            path(P[q][r],r,lug);
        }
    }
}
