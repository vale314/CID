package examples.hello;

import examples.hello.*;

public class KNN {

    public void minimoMaximoMed(double Matrix[][], double MatrixMedia[], double MatrixMaximo[],double MatrixMinimo[]){
        MatrixO matrixI = new MatrixO();

        for(int j=0; j<Matrix[0].length-1; j++){
            for(int i=0; i<Matrix.length; i++){
                MatrixMedia[j] += Matrix[i][j];
                // xMedia1 += Matrix[i][0];
                // xMedia2 += Matrix[i][1];
            }
        }
        for(int j=0; j<Matrix[0].length-1; j++){
            MatrixMedia[j] = MatrixMedia[j]/Matrix.length;
        }
        // xMedia1 = xMedia1/Matrix.length;
        // xMedia2 = xMedia2/Matrix.length;

        for(int j=0; j<Matrix[0].length-1; j++){
            matrixI.sortbyColumn(Matrix, j);

            MatrixMinimo[j] = Matrix[0][j];
            MatrixMaximo[j] = Matrix[Matrix.length-1][j];
        }
    }

    public void normalize(double Matrix[][], double MatrixS[][], double MatrixMedia[], double MatrixMinimo[], double MatrixMaximo []){
        for(int i = 0; i < Matrix.length; i++){
            for(int j = 0; j < Matrix[0].length-1; j++){
                // if(j==0)
                    MatrixS[i][j] = (MatrixS[i][j]-MatrixMedia[j])/(MatrixMinimo[j]-MatrixMaximo[j]);
            }
        }
    }

    public void generateClases( double clases [], double MatrixS[][], int K){
        for(int i = 0; i < K; i++){
            clases[ (int)MatrixS[i][2]] = clases[ (int)MatrixS[i][2]]+1;
        }
    }

    public void distance(double test1, double test2, double MatrixMedia[], double MatrixMaximo[], double MatrixMinimo[], double MatrixS[][]){
        test1 = (test1-MatrixMedia[0])/(MatrixMaximo[0]-MatrixMinimo[0]);
        test2 = (test2-MatrixMedia[1])/(MatrixMaximo[1]-MatrixMinimo[1]);

        int LMS = MatrixS[0].length-1;

        for(int i = 0; i < MatrixS.length; i++){
            // for(int j = 0; j < MatrixS[0].length; j++){
            MatrixS[i][LMS] = Math.sqrt(
                (Math.pow((test1-MatrixS[i][0]), 2) +
                Math.pow((test2-MatrixS[i][1]), 2))
                );
            
        }
    }
}
