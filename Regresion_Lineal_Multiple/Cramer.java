package examples.hello;

import examples.hello.*;

public class Cramer {

    float MatrixY [];
    float MatrixX [][];
    float sumatoriaY = 0f;

    float sumatoriaX1 = 0f;
    float sumatoriaX2 = 0f;

    float sumatoriaX1Y = 0f;
    float sumatoriaX1C = 0f;

    float sumatoriaX1X2 = 0f;

    float sumatoriaX2Y = 0f;
    float sumatoriaX2C = 0f;

    float determinant [][] = {{0,0,0},
                            {0,0,0},
                            {0,0,0}};
    
    float[] constants = {0,0,0};


    Cramer(float MatrixY[], float MatrixX[][]){
        this.MatrixY = MatrixY;
        this.MatrixX = MatrixX;
    }

    private void sumatoria(){
        for(int i=0; i<this.MatrixX.length; i++){
            this.sumatoriaY = this.sumatoriaY + this.MatrixY[i];

            this.sumatoriaX1 = this.sumatoriaX1 + this.MatrixX[i][0];
            this.sumatoriaX2 = this.sumatoriaX2 + this.MatrixX[i][1];

            this.sumatoriaX1Y = this.sumatoriaX1Y + (this.MatrixX[i][0] * this.MatrixY[i]);
            this.sumatoriaX1C = this.sumatoriaX1C + (float)(Math.pow(this.MatrixX[i][0], 2));

            this.sumatoriaX1X2 = this.sumatoriaX1X2 + (this.MatrixX[i][0] * this.MatrixX[i][1]);
            this.sumatoriaX2Y = this.sumatoriaX2Y + (this.MatrixX[i][1] * this.MatrixY[i]);
            this.sumatoriaX2C = this.sumatoriaX2C + (float)(Math.pow(this.MatrixX[i][1],2));
        }
    }

    public void determinant(){

        this.determinant[0][0] = this.sumatoriaX1;
        this.determinant[0][1] = this.sumatoriaX2;
        this.determinant[0][2] = this.MatrixX.length;

        this.determinant[1][0] = this.sumatoriaX2C;
        this.determinant[1][1] = this.sumatoriaX1X2;
        this.determinant[1][2] = this.sumatoriaX1;

        this.determinant[2][0] = this.sumatoriaX1X2;
        this.determinant[2][1] = this.sumatoriaX2C;
        this.determinant[2][2] = this.sumatoriaX2;

        
    }

    public void constants(){
        this.constants[0] = this.sumatoriaY;
        this.constants[1] = this.sumatoriaX1Y;
        this.constants[2] = this.sumatoriaX2Y;
    }

    public void determinatConstants(float a, float b, CramersRule cramer){
        float [] result;
        
        result = cramer.solution(this.determinant, constants);

        float MLR = (a * result[0]) + (b * result[1]) + (result[2]);

        System.out.println("( " + a + " * " + result[0] + " ) + ( " + b + " * " + result[1] + " ) + ( " + result[2] + " ) ");

        System.out.println("Resultado-> " + MLR);
    }

    public void main(float a,  float b){

        sumatoria();
        
        determinant();

        constants();
    
        CramersRule cramer = new CramersRule();
        
        determinatConstants(a,b,cramer);
    }  


}
