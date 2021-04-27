package without_jade;

import java.util.Arrays;

import without_jade.LinearRegresion2;

public class Main {

    public static void main(String[] args) {

        int [] values =  new int[args.length];

        for(int i=0; i<args.length; i++) {
            values[i] = Integer.parseInt(args[i]);
         }

        LinearRegresion2 r2 = new LinearRegresion2(values);

        // SimpleLinearRegression r = new SimpleLinearRegression(values);


    }
}