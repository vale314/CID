package examples.hello;

import java.util.HashMap;

import java.util.*;

public class MatrixO1 {
    
    MatrixO1(){}

    public void matrixInitialize(double matrix[]){
        for(int i = 0; i<matrix.length; i++){
            matrix[i] = 0.0;
        }
    }

    public void imprimir(double MatrixX[][]){

        int MatrixXLengthRows = MatrixX.length;
        int MatrixXLengthColumns = MatrixX[0].length;

        //Imprimir
        for (int row=0; row < MatrixXLengthRows; row++)
        {
            for (int col=0; col < MatrixXLengthColumns; col++)
            {
                System.out.print(MatrixX[row][col]+" ");
            }
            System.out.print('\n');
        }
        System.out.print('\n');
    }

    public void imprimir(double MatrixX[]){

        int MatrixXLengthColumns = MatrixX.length;

        //Imprimir

        {
            for (int col=0; col < MatrixXLengthColumns; col++)
            {
                System.out.print(MatrixX[col]+" ");
            }
            System.out.print('\n');
        }
    }

    // Function to sort by column
    public  void sortbyColumn(double arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<double[]>() {
            
        @Override              
        // Compare values according to columns
        public int compare(final double[] entry1, 
                            final double[] entry2) {

            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
        }
        });  // End of function call sort().
    }

    public void minimoMaximoMed(double Matrix[][], double MatrixMedia[], double MatrixMaximo[],double MatrixMinimo[]){

        for(int j=0; j<Matrix[0].length; j++){
            for(int i=0; i<Matrix.length; i++){
                MatrixMedia[j] += Matrix[i][j];
                // xMedia1 += Matrix[i][0];
                // xMedia2 += Matrix[i][1];
            }
        }
        for(int j=0; j<Matrix[0].length; j++){
            MatrixMedia[j] = MatrixMedia[j]/Matrix.length;
        }
        // xMedia1 = xMedia1/Matrix.length;
        // xMedia2 = xMedia2/Matrix.length;

        for(int j=0; j<Matrix[0].length; j++){
            sortbyColumn(Matrix, j);

            MatrixMinimo[j] = Matrix[0][j];
            MatrixMaximo[j] = Matrix[Matrix.length-1][j];
        }
    }

    public void normalize(double Matrix[][], double MatrixS[][], double MatrixMedia[], double MatrixMinimo[], double MatrixMaximo []){
        for(int i = 0; i < Matrix.length; i++){
            for(int j = 0; j < Matrix[0].length; j++){
                // if(j==0)
                    MatrixS[i][j] = (MatrixS[i][j]-MatrixMedia[j])/(MatrixMinimo[j]-MatrixMaximo[j]);
            }
        }
    }

    public void copyMatrix(double Matrix[][], double MatrixS[][]){
        for(int i = 0; i < Matrix.length; i++){
            for(int j = 0; j < Matrix[0].length; j++){
                MatrixS[i][j] = Matrix[i][j];
            }
        }
    }

    public void evaluar(double pred){
        System.out.println("El Valor Predecido Por El Modelo= "+pred);
        if(pred>0.5)
            pred=1;
        else
            pred=0;
        System.out.println("La Clase Establecido Por El Modelo= "+pred);
    }

}
