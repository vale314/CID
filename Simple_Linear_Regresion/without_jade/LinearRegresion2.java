package without_jade;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class LinearRegresion2 {
    private static final List<Integer> x = asList(23, 26, 30, 34, 43, 48, 52, 57, 58); 
    private static final List<Integer> y = asList(651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518); 

    private static Double predictForValue(int varibleDePrediccion) {
        List<Integer> x = asList(23, 26, 30, 34, 43, 48, 52, 57, 58); 
      List<Integer> y = asList(651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518); 

          if (x.size() != y.size())
              throw new IllegalStateException("Tanto Y Como X Deben de ser del mismo tamaño");

          Integer n = x.size();
  
          List<Double> xCuadrada = x
                  .stream()
                  .map(posicion -> Math.pow(posicion, 2))
                  .collect(Collectors.toList());
  
          List<Integer> XPorY = IntStream.range(0, n)
                  .map(i -> x.get(i) * y.get(i))
                  .boxed()
                  .collect(Collectors.toList());
  
          Integer sumaDeX = x
                  .stream()
                  .reduce((prev, next) -> prev + next)
                  .get();
  
          Integer sumaDeY = y
                  .stream()
                  .reduce((prev, next) -> prev + next)
                  .get();
  
          Double sumaDeXCuadrada = xCuadrada
                  .stream()
                  .reduce((prev, next) -> prev + next)
                  .get();
  
          Integer sumOfXMultipliedByY = XPorY
                  .stream()
                  .reduce((prev, next) -> prev + next)
                  .get();
  
          //B1
          int pendienteNumerador = n * sumOfXMultipliedByY - sumaDeY * sumaDeX;
          Double pendienteDenominador = n * sumaDeXCuadrada - Math.pow(sumaDeX, 2);
          Double pendiente = pendienteNumerador / pendienteDenominador;
  
          //B0
          double B0Numerador = sumaDeY - pendiente * sumaDeX;
          double b0Denominador = n;
          double B0 = B0Numerador / b0Denominador;
  
  
          
          System.out.println("Ÿ = " + B0 + "+" + pendiente + "*" + varibleDePrediccion );
  
        return ((pendiente * varibleDePrediccion) + B0);

    }

    public LinearRegresion2(int [] values) {
        for(int i = 0; i<values.length; i++){

                System.out.println(predictForValue(values[i]));
        }
    }
}