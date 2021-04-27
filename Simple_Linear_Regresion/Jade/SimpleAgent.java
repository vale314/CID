package examples.hello;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

import javax.swing.*;

public class SimpleAgent extends Agent {

  protected void setup() {
    System.out.println("Agent "+getLocalName()+" started.");
    addBehaviour(new MyOneShotBehaviour());
  } 


  private class MyOneShotBehaviour extends OneShotBehaviour {

    public void action() {
      int varibleDePrediccion;

      JFrame f;  
      f=new JFrame();   
      String v = JOptionPane.showInputDialog(f,"Valor variable Ad");  

      varibleDePrediccion = Integer.parseInt(v);


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
          Double B0 = B0Numerador / b0Denominador;
  
  
          
          System.out.println("Ÿ = " + B0 + "+" + pendiente + "*" + varibleDePrediccion );
  
          System.out.println((pendiente * varibleDePrediccion) + B0);
    } 
    
    public int onEnd() {
      myAgent.doDelete();   
      return super.onEnd();
    } 
  }    // END of inner class ...Behaviour
}
