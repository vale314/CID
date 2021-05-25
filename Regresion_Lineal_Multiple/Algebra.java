package examples.hello;

public class Algebra {
    float MatrixY[] = {};
    float MatrixX[][] = {{}};

    int MatrixXLengthRows = 0;
    int MatrixXLengthColumns = 0;
    int N = 0;

    Algebra(){

    }

    Algebra(float MatrixY[], float MatrixX[][]){
        this.MatrixY = MatrixY;
        this.MatrixX = MatrixX;

        this.MatrixXLengthRows = MatrixX.length;
        this.MatrixXLengthColumns = MatrixX[0].length+1;

        this.N = MatrixXLengthColumns;
    }

    public float[][] matNuevaCon1(float MatrixX[][]){

        int MatrixXLengthRows = MatrixX.length;
        int MatrixXLengthColumns = MatrixX[0].length+1;
    
        //Crear Matrix Nueva.
        float [][]MatrixX1 = new float[MatrixXLengthRows][MatrixXLengthColumns];
        
        //Rellenar Con 1 primer columna.
        for(int i = 0; i< MatrixXLengthRows; i++){
            MatrixX1[i][0] = 1;
        }

        return MatrixX1;
    }

    public float[][] matrixDatosFaltates(float MatrixX1[][], float MatrixX [][]){

        int MatrixXLengthRows = MatrixX.length;
        int MatrixXLengthColumns = MatrixX[0].length+1;
        
        //Rellenar Los Datos Faltantes.
        for(int i = 0; i< MatrixXLengthRows; i++){
            for(int j = 1; j<= MatrixXLengthColumns-1; j++){
                System.out.print(MatrixX[i][j-1]+" ");
                MatrixX1[i][j] = MatrixX[i][j-1];
            }
            System.out.print('\n');
        }
        System.out.print('\n');

        return MatrixX1;
    }

    public void imprimir(float MatrixX[][]){

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

    public float[][] createMatrixT(float MatrixX[][]){
        int MatrixXLengthRows = MatrixX.length;
        int MatrixXLengthColumns = MatrixX[0].length;

        float [][]MatrixX1T = new float[MatrixXLengthColumns][MatrixXLengthRows];

        for (int row=0; row < MatrixX1T.length; row++)
        {
            for (int col=0; col < MatrixX1T[0].length; col++)
            {
                MatrixX1T[row][col] = MatrixX[col][row];
    
            }
        }
        
        return MatrixX1T;
    }

    static float sumProduc(float MatrixX1[][], float MatrixX1T[][], int col, int row){
        // Imprimir.
        float sum = 0;
        for (int i=0; i < MatrixX1T[0].length; i++)
        {
            sum = sum + MatrixX1[i][col] * MatrixX1T[row][i];
        }
    
        return sum;
    }

    public float[][] matrixXporXT(float matrixX[][],float matrixXT[][]){

        int MatrixXLengthRows = matrixX.length;
        int MatrixXLengthColumns = matrixX[0].length;

        float [][]X1T_X1 = new float[MatrixXLengthRows][MatrixXLengthRows];

        System.out.print('\n');
        
        // XT x X
        System.out.println(" XT * X ");
        for (int row=0; row < matrixXT.length; row++)
        {
            for (int col=0; col < matrixXT.length; col++)
            {
                X1T_X1[row][col] = sumProduc(matrixX, matrixXT, col, row);
                System.out.print(X1T_X1[row][col] + " ");
            }
            System.out.print('\n');
        }
        return X1T_X1;
    }

    // Function to get cofactor of A[p][q] in temp[][]. n is current
    // dimension of A[][]
    static void getCofactor(float A[][], float temp[][], int p, int q, int n)
    {
        int i = 0, j = 0;
    
        // Looping for each element of the matrix
        for (int row = 0; row < n; row++)
        {
            for (int col = 0; col < n; col++)
            {
                // Copying into temporary matrix only those element
                // which are not in given row and column
                if (row != p && col != q)
                {
                    temp[i][j++] = A[row][col];
    
                    // Row is filled, so increase row index and
                    // reset col index
                    if (j == n - 1)
                    {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }
  
    /* Recursive function for finding determinant of matrix.
    n is current dimension of A[][]. */
    static float determinant(float A[][], int n, int N)
    {
        float D = 0; // Initialize result
    
        // Base case : if matrix contains single element
        if (n == 1)
            return A[0][0];
    
        float [][]temp = new float[N][N]; // To store cofactors
    
        int sign = 1; // To store sign multiplier
    
        // Iterate for each element of first row
        for (int f = 0; f < n; f++)
        {
            // Getting Cofactor of A[0][f]
            getCofactor(A, temp, 0, f, n);
            D += sign * A[0][f] * determinant(temp, n - 1, N);
    
            // terms are to be added with alternate sign
            sign = -sign;
        }
    
        return D;
    }

    // Function to get adjoint of A[N][N] in adj[N][N].
    static void adjoint(float A[][],float [][]adj, int N)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }
    
        // temp is used to store cofactors of A[][]
        int sign = 1;
        float [][]temp = new float[N][N];
    
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                // Get cofactor of A[i][j]
                getCofactor(A, temp, i, j, N);
    
                // sign of adj[j][i] positive if sum of row
                // and column indexes is even.
                sign = ((i + j) % 2 == 0)? 1: -1;
    
                // Interchanging rows and columns to get the
                // transpose of the cofactor matrix
                adj[j][i] = (sign)*(determinant(temp, N-1, N));
            }
        }
    }

    // Generic function to display the matrix. We use it to display
    // both adjoin and inverse. adjoin is integer matrix and inverse
    // is a float.
    
    static void display(int A[][], int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(A[i][j]+ " ");
            System.out.println();
        }
    }

    static void display(float A[][], int N)
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.printf("%.6f ",A[i][j]);
            System.out.println();
        }
    }

    // Function to calculate and store inverse, returns false if
    // matrix is singular
    static boolean inverse(float A[][], float [][]inverse, int N)
    {
        // Find determinant of A[][]
        float det = determinant(A, N, N);
        if (det == 0)
        {
            System.out.print("Singular matrix, can't find its inverse");
            return false;
        }
    
        // Find adjoint
        float [][]adj = new float[N][N];
        adjoint(A, adj, N);
    
        // Find Inverse using formula "inverse(A) = adj(A)/det(A)"
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                inverse[i][j] = adj[i][j]/(float)det;
    
        return true;
    }

    public float[][] inversa(float X1T_X1[][], int N){
        // Inversa
  
        float [][]adj = new float[N][N]; // To store adjoint of A[][]
    
        float [][]inv = new float[N][N]; // To store inverse of A[][]
    

        adjoint(X1T_X1, adj, N);
    
        System.out.print('\n');
        
        System.out.println(" Inversa De XT");
        if (inverse(X1T_X1, inv, N))
            display(inv, N);
        return inv;
    }

    public float[] XTY(float MatrixX1T[][],float MatrixY[]){
        float []XTY = new float[MatrixX1T.length];

        System.out.print('\n');
        System.out.print('\n');

        System.out.println("XT * Y");

        //XT * Y
        for(int i = 0; i < MatrixX1T.length; i++){
            float sum = 0;
            for(int j = 0; j < MatrixX1T[0].length; j++){
                sum =  sum + (MatrixX1T[i][j] * MatrixY[j]);
            }
            XTY[i] = sum;
            System.out.print(sum);
            System.out.print('\n');
        }

        System.out.print('\n');

        return XTY;
    }

    public float[] obtenerB(float inv[][],float XTY[]){
        float []B = new float[inv.length];

        System.out.println("X INV * XTY");

        //XInversa * Y
        for(int i = 0; i < inv.length; i++){
            float sum1 = 0;
            for(int j = 0; j < inv.length; j++){
                sum1 += inv[i][j] * XTY[j];
            }
            B[i] = sum1;
            System.out.print(B[i]);
            System.out.print('\n');
        }

        return B;
    }
}
