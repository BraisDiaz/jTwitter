
package jtwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.Iterator;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Brais Núñez
 */

public class Autorizacion {
   
    static Twitter twitter;

    static ConfigurationBuilder configbuilder;
    
    static DirectMessage mensaje;
    
    static Status estado;

    static ArrayList <Status> tweets = new ArrayList<Status>();

    static Iterator <Status>it = tweets.iterator();

    
    public Autorizacion() {
       
    }

    /**

     * Se configuran permisos para poder utilizar funciones de twitter, en este caso enviar y 
     * recibir datos.

     */
    
    public static void conectarse(){

        configbuilder = new ConfigurationBuilder();
        
        configbuilder.setOAuthConsumerKey("Introducir token propio");

        configbuilder.setOAuthConsumerSecret("Introducir token propio");

        configbuilder.setOAuthAccessToken("Introducir token propio");

        configbuilder.setOAuthAccessTokenSecret("Introducir token propio");


        TwitterFactory twittfact = new TwitterFactory(configbuilder.build());

        twitter = twittfact.getInstance();
    }

/**

 * Recoge en una lista las actualizaciones de estado de la linea temporal de un usuario.

 */

    public static void timeLine() {

        List<Status> estados;

        try {

            estados = twitter.getHomeTimeline();

            System.out.println("Mostrando timeline");

            for (Status estado : estados) {

                System.out.println(estado.getUser().getName() + ":"

                        + estado.getText());

                tweets.add(estado);
            }

        } catch (TwitterException ex) {

            java.util.logging.Logger.getLogger(JTwitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

/**

 * Usado para publicar un nuevo tweet desde teclado.

 * @param ultimoEstado recibe la última actualización de un estado.

 */

    public static void publicarTweet(String ultimoEstado) {

        try {

            estado = twitter.updateStatus(ultimoEstado);

            System.out.println("Tweet publicado: [" + estado.getText() + "].");

        } catch (TwitterException ex) {

            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);

        }
}

/**

 * Usado para buscar tweets que contengan la cadena de caracteres deseada.

 * 

 * @param busca Recibe una cadena de caracteres con el contenido que se desea encontrar.

 */
    public static void buscarTweet(String busca) {

        Query consulta = new Query(busca);

        QueryResult resultadoBusqueda;

        try {

            resultadoBusqueda = twitter.search(consulta);

            for (Status status : resultadoBusqueda.getTweets()) {

                System.out.println("@" + estado.getUser().getScreenName() + ":" + estado.getText());
          
            }

        } catch (TwitterException ex) {

            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    /**

     * Usado para permitir enviar mensajes directos de manera privada a los usuarios que seguimos o nos siguen.

     *

     * @param usuarioDestino Recibe el twitter del usuario al que queremos enviar un mensaje.

     * correo.

     * @param contenido Recibe el contenido del mensaje que se desea enviar.

     */

    public static void enviarMensaje(String usuarioDestino, String contenido) {

        try {

            mensaje = twitter.sendDirectMessage(usuarioDestino, contenido);

        } catch (TwitterException ex) {

            java.util.logging.Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);

        }

        System.out.println("Sent: " + mensaje.getText() + " to @" + mensaje.getRecipientScreenName());

    }

    /**

     * Usado para recoger estados y utilizar sus variables.

     */

    public static void seleccionar(){

      while(it.hasNext()){

      }

    for(int i=0;i<tweets.size();i++){

  System.out.println(tweets.get(i).getUser()+""+tweets.get(i).getGeoLocation()+""+tweets.get(i).getText());

    }
    }
}
    



    

