
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
     * <li>1.Buscar un tweet.</li>
     * <li>2.Mostrar TimeLine.</li>
     * <li>3.Publicar un tweet.</li>
     * <li>4.Enviar un mensaje directo.</li>
     * </ul>
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int opcion;

        Autorizacion aut = new Autorizacion();

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción: \n1) Buscar tweet.\n2) Mostrar TimeLine.\n3) Publicar Tweet.\n4) Enviar un MD.\n0) Salir"));

            } catch (NumberFormatException ex) {

                opcion = 999;

            }

            switch (opcion) {

                case 1:

                    aut.queryTweet("4j");

                    break;



                case 2:

                    aut.showTimeLine();

                    break;



                case 3:

                    aut.postTweet("Es un tweet de prueba");

                    break;



                case 4:

                    aut.sendDM("UsuarioEjemplo", "Mensaje ejemplo");

                    break;

                case 0:

                    JOptionPane.showMessageDialog(null, "Gracias por usar JTwitter");

                    break;

                default:

                    JOptionPane.showMessageDialog(null, "Opcion no válida.");

            }

        } while (opcion != 0);

    }

    }
