package examples.hello;

import examples.hello.*;

// Java program to find adjoint and inverse of a matrix
public class MLRM
{
    float X1 = 0;
    float X2 = 0;

    float MatrixX[][];
    float MatrixY[] = {};


    MLRM(float MatrixY[],float MatrixX[][], float X1, float X2){

        this.MatrixY = MatrixY;
        this.MatrixX = MatrixX;

        this.X1= X1;
        this.X2= X2;
    }

    public void main()
{
    

    Algebra algebra = new Algebra();



    int N = MatrixX[0].length+1;

   
    float [][]MatrixX1 = algebra.matNuevaCon1(MatrixX);
    
    
    MatrixX1 = algebra.matrixDatosFaltates(MatrixX1, MatrixX);

    
    System.out.println(" X ");

    algebra.imprimir(MatrixX1);

    
    float [][]MatrixX1T = algebra.createMatrixT(MatrixX1);

    

    System.out.println(" XT ");

    algebra.imprimir(MatrixX1T);


    float [][]X1T_X1 = algebra.matrixXporXT(MatrixX1, MatrixX1T);



    float [][]inv = algebra.inversa(X1T_X1,N);



    float []XTY = algebra.XTY(MatrixX1T, MatrixY);



    float []B = algebra.obtenerB(inv, XTY);

    

    System.out.print('\n');

    System.out.println("Y^ = B0 " + B[0] + " + B1 X1 + " + B[1]*this.X1 + "+ B2 X2 + " + B[2]*this.X2 + "+ B3 X3 + ");
    System.out.println(B[0] + B[1]*this.X1  + B[2]*this.X2);
}
  
}