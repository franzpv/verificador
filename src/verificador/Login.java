/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.GeoLocation;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author franz
 */
public class Login {
    
    private TwitterFactory twitterfactory;
    private Twitter twitter;
    private TwitterStream twitterStream;
    private AccessToken accessToken;
    private ConfigurationBuilder cb;
    private StatusListener listener;
    
    public Login(){
        cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("Al0CUcEQqnXglbWMBQ3znA");
        cb.setOAuthConsumerSecret("1edsJvJZJGU9luM6DCWVFPLhtkoftsfaG5975twE14");
        cb.setOAuthAccessToken("15340345-y8VmoQm94XA7sgloPx7oE1jcS676VOCbHj6h8XXVT");
        cb.setOAuthAccessTokenSecret("x63nssXBlUzmQf6oRO7jkoBJlYYvXfgILXq0gioKdpg");
    }
    public void loginTwitter(){
        twitterfactory = new TwitterFactory(cb.build());
        accessToken = new AccessToken("15340345-y8VmoQm94XA7sgloPx7oE1jcS676VOCbHj6h8XXVT","x63nssXBlUzmQf6oRO7jkoBJlYYvXfgILXq0gioKdpg");
        twitter = twitterfactory.getInstance();
        twitter.setOAuthAccessToken(accessToken);
    }
    
    public TwitterStream loginStream(){
        twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        return twitterStream; 
    }
}