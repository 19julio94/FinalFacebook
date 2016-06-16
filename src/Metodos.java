
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.conf.ConfigurationBuilder;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JP
 */
public class Metodos {
    public Facebook PFclase;

    public Facebook iniciar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        //introducir los tokens en los huecos con comillas
        cb.setDebugEnabled(true)
                .setOAuthAppId("796736570460792")
                .setOAuthAppSecret("c8386005ef537ef56daa494410a8c049")
                .setOAuthAccessToken("EAACEdEose0cBAH5ZCjrTpvdOEM4uDmZBQw1MFZAD8rRCL0iZBdW5ZBMSo4040DsiBy8NZBGcy7whMA2uKnxwBZCzMKpQm4VIL5ZAmcgqHOsMtLmNdhziuQiIZAnssXc0dZCVSkgCUDqlSTFai8WuJ1elQhyweCCvv2Ig1qEzkkHTPf0wZDZD");

        FacebookFactory ff = new FacebookFactory(cb.build());
        PFclase = ff.getInstance();
        return PFclase;
    }
    
    public void estado() throws FacebookException {

        PFclase.postStatusMessage(JOptionPane.showInputDialog("Introduce estado"));

    }
}
