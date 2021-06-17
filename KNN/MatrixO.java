package examples.hello;

import java.util.HashMap;

import java.util.*;

public class MatrixO {
    
    MatrixO(){}

    public void copyMatrix(double Matrix[][], double MatrixS[][]){
        for(int i = 0; i < Matrix.length; i++){
            for(int j = 0; j < Matrix[0].length; j++){
                MatrixS[i][j] = Matrix[i][j];
            }
        }
    }

    public int snl( double[] array )
    {
        if ( array == null || array.length == 0 ) return -1; // null or empty

        int largest = 0;
        for ( int i = 1; i < array.length; i++ )
            {
                if ( array[i] > array[largest] ) largest = i;
            }
        return largest; // position of the first largest found
    }

    public void matrixInitialize(double matrix[]){
        for(int i = 0; i<matrix.length; i++){
            matrix[i] = 0;
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

}
