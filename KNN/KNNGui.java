package examples.hello;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

import examples.hello.*;

public class KNNGui extends Agent {
    protected void setup() {

        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGenericBehaviour());

      } 

      private class MyGenericBehaviour extends Behaviour {
        
        boolean end = false;

        public void action() {
            double Matrix [][] = {{158,58,0},{158,59,0},{158,63,0},{160,59,0},{160,60,0},{163,60,0},{163,61,0},{160,64,1},{163,64,1},{165,61,1},{165,61,1},{165,62,1},{165,65,1},{168,62,1},{168,63,1},{168,66,1},{170,63,1},{170,64,1},{170,68,1}};
            // double Matrix [][] = {{5.3,3.7,0},{5.1,3.8,0},{7.2,3.0,1},{5.4,3.4,0},{5.1,3.3,0},{5.4,3.9,0},{7.4,2.8,1},{6.1,2.8,2},{7.3,2.9,1},{6.0,2.7,2},{5.8,2.8,1},{6.3,2.3,2},{5.1,2.5,2},{6.3,2.5,2},{5.5,2.4,2}};

            int clasesN = 2;

            int K = 2;

            double test1 = 160;
            double test2 = 59;

            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();

            Object [] fields = {
              "Field1", field1,
              "Field2", field2,
            };
        
            int n = JOptionPane.showConfirmDialog(null,fields,"this is a header",JOptionPane.OK_CANCEL_OPTION);

            if (n == JOptionPane.YES_OPTION) {

                MainKNN Knn = new MainKNN();

                double a;
                double b;

                a = Double.parseDouble(field1.getText());
                b = Double.parseDouble(field2.getText());

                Knn.MainK(Matrix, clasesN, a, b, K);

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
