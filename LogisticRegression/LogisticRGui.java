package examples.hello;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

import examples.hello.*;

public class LogisticRGui extends Agent {
    protected void setup() {

        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGenericBehaviour());

      } 

      private class MyGenericBehaviour extends Behaviour {
        
        boolean end = false;

        public void action() {
            double x1[] = {780, 750, 690, 710, 680,730};                          
            double x2[] = {4, 3.9, 3.3, 3.7, 3.9, 3.7};
            double x3[] = {3,4,3,5,4,6};
            double y[] = {1, 1, 0, 1, 0, 1};
    
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
                LogisticR logisticR = new LogisticR(alpha, e);
                    
                logisticR.regresion(x1, x2, x3, y);

                double pred = logisticR.pred(690,2.3,1);
                
                logisticR.evaluar(pred);
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
