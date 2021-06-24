package examples.hello;

import examples.hello.*;

public class MainLogisticTR {

    double MatrixX [][];
    double MatrixY [];
    double MatrixB [];

    MainLogisticTR(double MatrixX [][],double MatrixY [], double MatrixB []){
        this.MatrixX = MatrixX;
        this.MatrixY = MatrixY;
        this.MatrixB = MatrixB;
    }

    public static double ef(double matrixW[], double matrixX[]){
        
        double sum = 0;

        // System.out.println("Pesos De Nuestro Sistema");

        sum = matrixW[0];

        for(int i=1; i<matrixW.length; i++){
            sum = sum + (matrixW[i] * matrixX[i-1]);
        }

        sum = sum * -1;

        double result = Math.pow(2.71828,sum);

        result = 1/ (1+result);
        
        return result;
    }

    public static void normalizeData(double MatrixB [], double MatrixMaximo[], double MatrixMedia[], double MatrixMinimo[]){

        for(int i=0; i<MatrixB.length; i++){
            MatrixB[i] = (MatrixB[i]-MatrixMedia[i])/(MatrixMaximo[i]-MatrixMinimo[i]);
        }
        
    }

    public static void iter(double MatrixX1[][], double MatrixS[][], double MatrixW[], double MatrixY[], double AS){
        int NI = 0;
        double act = 0;

        // System.out.println("Pesos De Nuestro Sistema");

        for(int k = 0; k<1000; k++){
            
            NI = 0;
            act = 0;

            int iter = 0;

            double MatrixW1[] = new double [MatrixW.length];

            for(int i = 0; i<MatrixX1.length; i++){
                
                double resultEF = ef(MatrixW, MatrixS[i]);
                
                // matrixO.imprimir(MatrixW);
            
                for(int j = 0; j<MatrixX1[i].length; j++){
                    MatrixW1[j] =((resultEF-MatrixY[j]) * MatrixX1[i][j]);

                    resultEF = ef(MatrixW1, MatrixS[i]);
                }

                for(int j = 0; j<MatrixW1.length; j++){
                    act += MatrixW1[j];
                }
                
                double prev = ef(MatrixW1, MatrixS[i]);

                iter++;

                if(iter>100){
                    for(int j = 0; j<MatrixW1.length; j++){
                        MatrixW[j] = MatrixW1[j] - (act * AS);
                    }
                    continue;
                }

                if( .5 < prev && MatrixY[i] != 1){
                    i = i - 1;
                    continue;
                }

                if(.5 > prev && MatrixY[i] != 0){
                    i = i - 1;
                    continue;
                }

                for(int j = 0; j<MatrixW1.length; j++){
                    MatrixW[j] = MatrixW1[j] - (act * AS);
                }

                // if(NI>MatrixW.length-1){
                //     NI = 0;
                // }else{
                //     MatrixW[NI] = MatrixW[NI] - (act * AS);
                //     NI++;
                // }
            }
        }

    }

    public void main() {
    
        double MatrixX [][] = this.MatrixX;
        double MatrixY [] = this.MatrixY;

        double MatrixB [] = this.MatrixB;


        double MatrixW [] = new double [MatrixX[0].length+1];

        double MatrixMedia[] = new double [MatrixX[0].length];
        double MatrixMinimo[] = new double [MatrixX[0].length];
        double MatrixMaximo[] = new double [MatrixX[0].length];

        double AS = 0.01;

        MatrixO1 matrixO = new MatrixO1();
    
        matrixO.minimoMaximoMed(MatrixX, MatrixMedia, MatrixMaximo, MatrixMinimo);

        normalizeData(MatrixB, MatrixMaximo, MatrixMedia, MatrixMinimo);

        double MatrixS[][] = new double[MatrixX.length][MatrixX[0].length];

        Algebra algebra = new Algebra();

        matrixO.matrixInitialize(MatrixW);

        matrixO.copyMatrix(MatrixX, MatrixS);

        matrixO.normalize(MatrixX, MatrixS, MatrixMedia, MatrixMinimo, MatrixMaximo);


        System.out.println("Matriz De Original");
        matrixO.imprimir(MatrixX);

        System.out.println("Matriz Normalizada");
        matrixO.imprimir(MatrixS);

        double [][]MatrixX1 = algebra.matNuevaCon1(MatrixS);

        System.out.println("Matriz Con Unos");
        matrixO.imprimir(MatrixX1);

        MatrixX1 = algebra.matrixDatosFaltates(MatrixX1, MatrixS);

        System.out.println("Matriz Normalizada Con Unos");
        matrixO.imprimir(MatrixX1);

        iter(MatrixX1, MatrixS, MatrixW, MatrixY, AS);

        System.out.println("Varibles Con Los Pesos: ");
        matrixO.imprimir(MatrixW);
        System.out.println("\n");

        double resultEF = ef(MatrixW, MatrixB);

        for(int i=0; i<MatrixB.length; i++){
            System.out.println("Buscar Valores: " + "X" + i + ": " + MatrixB[i]);
        }

        System.out.println();

        matrixO.evaluar(resultEF);

    }

}
