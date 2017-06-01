
package jtwitter;

import java.util.*;
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

            mensajes += aux.getUser().getName() + " : " + aux.getText() + "\n-------\n";

            i++;

        }

        JOptionPane.showMessageDialog(null, mensajes);
        
    }
    
 
}
    



    

