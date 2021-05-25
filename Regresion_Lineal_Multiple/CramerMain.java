package examples.hello;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;

import java.lang.reflect.Array;

import javax.swing.*;

import examples.hello.*;

public class CramerMain extends Agent{

    protected void setup() {

        System.out.println("Agent "+getLocalName()+" started.");
        addBehaviour(new MyGenericBehaviour());

      } 

      private class MyGenericBehaviour extends Behaviour {
        
        boolean fin = false;
        
        public void action() {

            int varibleDePrediccion;

            float MatrixY [] = {251.3f,251.3f,248.3f,267.5f,273.0f,276.5f,270.3f,274.9f,285.0f,290.0f,297.0f,302,5f,304.5f,309.3f,321.7f,330.7f,349.0f};
        
            float MatrixX [][] = {
                {41.9f,29.1f},
                {43.4f,29.3f},
                {43.9f,29.5f},
                {44.5f,29.7f},
                {47.3f,29.9f},
                {47.5f,30.3f},
                {47.9f,30.5f},
                {50.2f,30.7f},
                {52.8f,30.8f},
                {53.2f,30.9f},
                {56.9f,30.5f},
                {57.0f,31.7f},
                {63.5f,31.9f},
                {65.3f,32.0f},
                {71.1f,32.1f},
                {77.0f,32.5f},
                {77.8f,32.9f}
              };

              System.out.println(getLocalName() + " Preparandose para recibir");
              
            //Obtiene el primer mensaje de la cola de mensajes
            ACLMessage mensaje = receive();
   
            if (mensaje!= null) {
              
              System.out.println(mensaje.getContent());
              
              String msg = mensaje.getContent();
              if(msg.equals("a")){
                
                fin = true;
                return;
              }else{
                System.out.println(getLocalName() + ": acaba de recibir el siguiente mensaje: ");
                
                String[] partsM = mensaje.getContent().split(",");

                float a = 78.9f;
                float b = 33.0f;

                a = Float.parseFloat(partsM[0]);
                b = Float.parseFloat(partsM[1]);

                Cramer cramer = new Cramer(MatrixY, MatrixX);
                cramer.main(a, b);
                // fin = true;
              }
            } else{
              System.out.println(getLocalName() + " Esperando a recibir mensaje...");
              block();
            }

        } 
        
        public boolean done() {
            return fin;
        }
       
        public int onEnd() {
          System.out.println("Remove Cramer Agent");
          myAgent.doDelete();
          return super.onEnd();
        } 
      }    // END of inner class ...Behaviour
}
