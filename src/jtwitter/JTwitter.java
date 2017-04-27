
package jtwitter;


import javax.swing.JOptionPane;

/**
 *
 * @author Brais Núñez
 */
public class JTwitter {

       /**
     * Menú con las llamadas a los distintos métodos mediante la pulsación de un número.
     * <ul>
     * <li>1.Buscar un tweet.
     * <li>2.Mostrar TimeLine.
     * <li>3.Publicar un tweet.
     * <li>4.Enviar un mensaje directo.
     * <li>5.Seleccionar un tweet.
     * <ul>
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Autorizacion.conectarse();
   
       int opcion;
    
       do {

  opcion = Integer.parseInt(JOptionPane.showInputDialog("1.Buscar Tweet \n 2.TimeLine \n 3.Nuevo Tweet \n 4.Enviar Mensaje \n 5.Seleccionar tweet"));

    switch(opcion){

        case 1:Autorizacion.buscarTweet(JOptionPane.showInputDialog("Introduzca el hashtag a buscar"));  

            break;

        case 2:Autorizacion.timeLine();

            break;

        case 3:Autorizacion.publicarTweet(JOptionPane.showInputDialog(null,"Introduzca lo que desee publicar"));

            break;

        case 4:Autorizacion.enviarMensaje(JOptionPane.showInputDialog("Introduce destinatario"),JOptionPane.showInputDialog("Introduce el mensaje"));

            break;

        case 5:Autorizacion.seleccionar();

            break;

    }

          }while(opcion!=0);
    }
}
        
        
        
    
    

