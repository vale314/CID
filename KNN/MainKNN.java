package examples.hello;

import java.util.*;

import java.lang.Math;

import examples.hello.*;

import java.util.HashMap;

public class MainKNN {

    public void MainK( double Matrix [][], int clasesN, double test1, double test2, int K ) {

        double MatrixMedia[] = new double [Matrix[0].length-1];
        double MatrixMinimo[] = new double [Matrix[0].length-1];
        double MatrixMaximo[] = new double [Matrix[0].length-1];

        MatrixO matrixI = new MatrixO();
        KNN KNN = new KNN();

        KNN.minimoMaximoMed(Matrix, MatrixMedia, MatrixMaximo, MatrixMinimo);

        double MatrixS[][] = new double[Matrix.length][Matrix[0].length+1];

        matrixI.copyMatrix(Matrix, MatrixS);

        KNN.normalize(Matrix, MatrixS, MatrixMedia, MatrixMinimo, MatrixMaximo);
        
        System.out.println("\nMatrix\n");

        matrixI.imprimir(Matrix);

        System.out.println("\nMatrix2\n");

        matrixI.imprimir(MatrixS);


        //algoritmo KNN

        int LMS = MatrixS[0].length-1;

        KNN.distance(test1, test2, MatrixMedia, MatrixMaximo, MatrixMinimo, MatrixS);

        matrixI.sortbyColumn(MatrixS, LMS);

        System.out.println("\nMatrixSD\n");

        matrixI.imprimir(MatrixS);

        System.out.println("\nMatrixC\n");

        double clases [] = new double[clasesN];

        KNN.generateClases(clases, MatrixS, K);

        int clase = matrixI.snl(clases);
        
        System.out.println(clase);

        matrixI.imprimir(clases);
    }
}
