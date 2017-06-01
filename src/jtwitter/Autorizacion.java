
package jtwitter;

import java.util.List;
import java.util.logging.Level;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Brais Núñez
 */

public class Autorizacion {
   
    private ConfigurationBuilder cb;
    
    private Twitter twitter = TwitterFactory.getSingleton();

    public Autorizacion() {
    }
    
    /**

     * Shows the last five tweets from our timeline

     */
    
    public void showTimeLine(){
        
        List<Status> statuses = null;

        String mensajes = "Showing home timeline.\n";

        int i = 0;
        
        Status aux = null;

        try {

            statuses = twitter.getHomeTimeline();

        } catch (TwitterException ex) {

            Logger.getLogger(JTwitter.class.getName()).log(Level.SEVERE, null, ex);

        }

        Iterator<Status> it = statuses.iterator();

        while (it.hasNext() && i < 5) {

            aux = it.next();

            mensajes += aux.getUser().getName() + " : " + aux.getText() + "\n----\n";

            i++;

        }

        JOptionPane.showMessageDialog(null, mensajes);
        
    }
    
    /**

     * Posts a new Tweet from our twitter

     *

     * @param lastTweet it contents the information of the tweet which we are going to post.

     */

    public void postTweet(String lastTweet) {

        Status status = null;

        try {

            status = twitter.updateStatus(lastTweet);

        } catch (TwitterException ex) {

            Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);

        }

        System.out.println("Properly posted tweet ["+ status.getText()+"].");

    }
    
    /**

     * Search a tweet for a word or a hashtag

     * @param consulta It contains the word you are looking for.

     */

    public void queryTweet(String consulta) {

        Query query = new Query(consulta);

        QueryResult result = null;

        try {

            result = twitter.search(query);

        } catch (TwitterException ex) {

            Logger.getLogger(JTwitter.class.getName()).log(Level.SEVERE, null, ex);

        }

        for (Status status : result.getTweets()) {

            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());

        }
    }
    
    /**

 * Sends a DM to a user.

 * @param usuario The user you wants to send a message

 * @param mensaje The information of the message

 */

    public void sendDM(String usuario, String mensaje) {

        DirectMessage message;

        try {

            message = twitter.sendDirectMessage(usuario, mensaje);

            System.out.println("Sent: "+ message.getText() + " to @" + message.getRecipientScreenName());       

        } catch (TwitterException ex) {

            Logger.getLogger(Autorizacion.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
    
    

