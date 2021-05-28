import java.util.ArrayList;
import java.util.Arrays;

public class Floyd {

    Integer[][] P;
    Integer[][] M;
    public Integer[][] recacl(Integer[][] Matrix){
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

        return M;
    }


    public void path(int q, int r, ArrayList lug){

        if(P[q][r]!=0){
            path(q,P[q][r],lug);
            System.out.println("Pasa por -" + lug.get(P[q][r]));
            path(P[q][r],r,lug);
        }
    }
}
