/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import java.text.Format;
import java.text.SimpleDateFormat;
import twitter4j.GeoLocation;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;

/**
 *
 * @author franz
 */
public class Stream {
    
    private Login login;
    private TwitterStream twitterStream;
    private StatusListener listener;
    
    public Stream(){
        login = new Login();
        twitterStream = login.loginStream();
        openStream();
    }
    
    public final void openStream(){
        listener = new StatusListener() {
            // <editor-fold defaultstate="collapsed" desc="@Overrides">   
            @Override
            public void onException(Exception arg0) {}   

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {}

            @Override
            public void onScrubGeo(long arg0, long arg1) {}

            @Override
            public void onTrackLimitationNotice(int arg0) {}

            @Override
            public void onStallWarning(StallWarning sw) {}
            // </editor-fold>  
            
            @Override
            public void onStatus(Status status) {
                twitter4j.User user = status.getUser();
                GeoLocation location = status.getGeoLocation();
                String latitude = Double.toString(location.getLatitude());
                String longitud = Double.toString(location.getLongitude());
                String lang = status.getUser().getLang();
 
                if(location != null && status.isRetweet() != true && lang.equals("en")){
                    System.out.println(status.getText());
                    
                    Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    long tweet_id = status.getId();
                    String date = formatter.format(status.getCreatedAt());
                    String userid = Long.toString(status.getUser().getId());
                    String username = status.getUser().getScreenName();
                    String content = status.getText();
   
                    int tweets = status.getUser().getStatusesCount();
                    int followers = status.getUser().getFollowersCount();
                    int following = status.getUser().getFriendsCount();
     
                   // try {
                        String values =tweet_id+",'"+date+"','"+userid
                                            +"','"+username+"','"+content.replace("'"," ") +"','"+latitude
                                            +"','"+longitud+"',"+followers+","+following+","+tweets;
         
                        //System.out.println(values);
                        //stmt.executeQuery("SHOW TABLES");
                        /*stmt.executeUpdate("INSERT INTO dataset(tweet_id,"
                                                 + "date,"+ "user_id,"+ "user_name,"
                                                 + "text,"+ "latitude,"+ "longitude,"
                                                 + "followers,"+ "following,"
                                                 + "tweets) VALUES("+values+");");*/
                    /*} 
                    catch (SQLException ex) {
                        Logger.getLogger(DataSet.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
                }
            }
        };
        /*FilterQuery fq = new FilterQuery();
        String keywords[] = {"car"};
        fq.track(keywords);
        twitterStream.addListener(listener);
        twitterStream.filter(fq);*/  
        twitterStream.addListener(listener);
        twitterStream.sample();
    }
    
    public void closeStream(){
        twitterStream.cleanUp();
        twitterStream.shutdown();
    }
}
