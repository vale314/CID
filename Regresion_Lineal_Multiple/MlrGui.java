package examples.hello;

import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;

import javax.swing.*;

import examples.hello.*;

public class MlrGui extends Agent{

    protected void setup() {

        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGenericBehaviour());

      } 

    private class MyGenericBehaviour extends Behaviour {
        
        boolean end = false;

        public void action() {

            float a = 78.9f;
            float b = 33.0f;

            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JTextField field3 = new JTextField();

            Object [] fields = {
              "Field1", field1,
              "Field2", field2,
              "Field3", field3,
            };

        
            int n = JOptionPane.showConfirmDialog(null,fields,"this is a header",JOptionPane.OK_CANCEL_OPTION);

            AID id = new AID();
            ACLMessage mensaje = new ACLMessage(ACLMessage.INFORM);


            if(field3.getText().equals("cramer")){
                id.setLocalName("receptorCramer");
            }else{
                id.setLocalName("receptorMatrix");
            }

            if (n == JOptionPane.YES_OPTION) {

                a = Float.parseFloat(field1.getText());
                b = Float.parseFloat(field2.getText());

                float MX[] = {a,b};

                //Rellenar los campos necesarios del mensaje
                mensaje.setSender(getAID());
                mensaje.setLanguage("Float");
                mensaje.addReceiver(id);

                String af=String.valueOf(a);  
                String bf=String.valueOf(b);  

                String send = af+','+bf;
                mensaje.setContent(send);

                //Envia el mensaje a los destinatarios
                send(mensaje);
    
                System.out.println(getLocalName() +": ... What are you up to");
                System.out.println(mensaje.toString());

            } else if (n == JOptionPane.NO_OPTION) {
    
                
                id.setLocalName("receptorCramer");
                

                //Rellenar los campos necesarios del mensaje
                mensaje.setSender(getAID());
                mensaje.setLanguage("String");
                mensaje.addReceiver(id);

                mensaje.setContent("a");

                //Envia el mensaje a los destinatarios
                send(mensaje);
                System.out.println(mensaje.toString());

                
                id.setLocalName("receptorMatrix");
                
                
                //Rellenar los campos necesarios del mensaje
                mensaje.setSender(getAID());
                mensaje.setLanguage("String");
                mensaje.addReceiver(id);

                mensaje.setContent("a");

                //Envia el mensaje a los destinatarios
                send(mensaje);
                System.out.println(mensaje.toString());
                end = true;
            }else{

                
                id.setLocalName("receptorCramer");
                

                //Rellenar los campos necesarios del mensaje
                mensaje.setSender(getAID());
                mensaje.setLanguage("String");
                mensaje.addReceiver(id);

                mensaje.setContent("a");

                //Envia el mensaje a los destinatarios
                send(mensaje);
                System.out.println(mensaje.toString());

                
                id.setLocalName("receptorMatrix");
                
                
                //Rellenar los campos necesarios del mensaje
                mensaje.setSender(getAID());
                mensaje.setLanguage("String");
                mensaje.addReceiver(id);

                mensaje.setContent("a");

                //Envia el mensaje a los destinatarios
                send(mensaje);
                System.out.println(mensaje.toString());

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
