package examples.hello;

import java.util.*;

public class LogisticR {

    double alpha = 0.01; 
    double  e = 2.71828;

    double b0 = 0; 
    double b1 = 0; 
    double b2 = 0; 
    double b3 = 0;

    public static int custom_sort(double a, double b) 
    {
        double  a1=Math.abs(a-0);
        double  b1=Math.abs(b-0);
        return (a1<b1) ? 1 : 0;
    }

    LogisticR(double alpha, double e){
        this.alpha = alpha;
        this.e = e;
    }

    public void regresion( double x1[], double x2[],  double x3[], double y[]){
        ArrayList<Double> error = new ArrayList<Double>(); 
        double err;   
        double b0 = 0; 
        double b1 = 0; 
        double b2=  0; 
        double b3=  0; 

        for (int i = 0; i<100; i++) { 
            int idx = i % x1.length;   
            double p = -(b0 + b1 * x1[idx]+ b2* x2[idx] + b3*x3[idx]); 
            double pred  = 1/(1+ Math.pow(e,p));
            
            err = y[idx]-pred;  
            b0 = b0 - alpha * err*pred *(1-pred)* 1.0;   
            b1 = b1 + alpha * err * pred*(1-pred) *x1[idx];
            b2 = b2 + alpha * err * pred*(1-pred) * x2[idx];
            b3 = b3 + alpha * err * pred*(1-pred) * x3[idx];
            System.out.println("B0= " + b0 + " B1= " + b1 + " B2= " + b2 + " B3= " + b3 + " error= " + err);
            error.add(err);
        }

        Collections.sort(error, 
                        (o1, o2) -> custom_sort(o1,o2));

            System.out.println("Final Values are:  B0= " + b0 + " B1= " + b1 + " B2= " + b2 + " B3= " + b3 + " error= " + error.get(0));

            this.b0 = b0;
            this.b1 = b1;
            this.b2 = b2;
            this.b3 = b3;
    }

    public double pred(double test1, double test2, double test3){
        double p=this.b0+(this.b1*test1)+(this.b2*test2)+(this.b3*test3); 
        p=p*-1;

        double pred  = 1/(1+ (Math.pow(2.71828,p)));

        return pred;
    }

    public void evaluar(double pred){
        System.out.println("The value predicted by the model= "+pred);
        if(pred>0.5)
            pred=1;
        else
            pred=0;
        System.out.println("The class predicted by the model= "+pred);
    }
}
