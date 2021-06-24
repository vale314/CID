package examples.hello;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

import examples.hello.*;

public class LogisticTRGui extends Agent {
    protected void setup() {

        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGenericBehaviour());

      } 

      private class MyGenericBehaviour extends Behaviour {
        
        boolean end = false;

        public void action() {
          // double MatrixX [][] = {{158,58},{158,59},{158,63}, {163,60} , {163, 61}, {160, 64}, {163, 64}, {165, 61}, {165, 62}, {165, 65}, {170, 68}, {170, 64}};
          // double MatrixY [] = {0,0,0,0,0,1,1,1,1,1,1,1}; 
  
          // double MatrixB [] = {170, 63};

          double MatrixX [][] = {
                                  {780, 4, 3},
                                  {750, 3.9, 4},
                                  {690, 3.3, 3},
                                  {710, 3.7, 5},
                                  {680,3.9,4}
                              };
          double MatrixY [] = {1, 1, 0, 1, 0}; 
          double MatrixB [] = {680, 3.9, 4};
    
            double alpha = 0.01; 
            double  e = 2.71828;

            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();

            Object [] fields = {
              "Field1", field1,
              "Field2", field2,
              "Field3", field3
            };
        
            int n = JOptionPane.showConfirmDialog(null,fields,"this is a header",JOptionPane.OK_CANCEL_OPTION);

            if (n == JOptionPane.YES_OPTION) {

                double a;
                double b;
                double c;

                a = Double.parseDouble(field1.getText());
                b = Double.parseDouble(field2.getText());
                c = Double.parseDouble(field3.getText());

                MatrixB[0] = a; 
                MatrixB[1] = b;
                MatrixB[2] = c;

                MainLogisticTR logisticR = new MainLogisticTR(MatrixX, MatrixY, MatrixB);

                logisticR.main();
                
            }else{
                end = true;
            }
        }

        public boolean done() {
            return end;
        }
       
        public int onEnd() {
          myAgent.doDelete();
          return super.onEnd();
        } 
    }
}
