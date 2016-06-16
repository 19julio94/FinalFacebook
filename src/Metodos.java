
import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.PostUpdate;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.conf.ConfigurationBuilder;
import java.net.MalformedURLException;
import java.net.URL;
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

    public void darLike() throws FacebookException {

        PFclase.likePost(JOptionPane.showInputDialog("Introduce la ID del Post \n (Para obtenerla haz click en la hora \n del post y copia los numeros del enlace)"));
    }

    public void subirImagen() throws MalformedURLException, FacebookException {

        PostUpdate post = new PostUpdate(new URL("https://www.formula1.com/content/fom-website/en.html"))
                .picture(new URL("http://e01-marca.uecdn.es/assets/multimedia/imagenes/2016/03/20/14584597103222.jpg"))
                .description("Crash Fernando Alonso ");
        PFclase.postFeed(post);

    }
    public void buscarTema() throws FacebookException {
        //No lo admite GraphAPI 2.0 o superior
        ResponseList<Post> results = PFclase.searchPosts(JOptionPane.showInputDialog("Selecciona el tema del que buscar posts"));
        JOptionPane.showMessageDialog(null, results);
    }

    public void buscarComentarios() throws FacebookException {

        ResponseList<Comment> lista = PFclase.getCommentReplies(JOptionPane.showInputDialog("Selecciona el post del que buscar comentarios"));
        System.out.println(lista);
    }
    
    public void comentarFoto() throws FacebookException {

        PFclase.commentPhoto(JOptionPane.showInputDialog("Introduce la ID del post \n (Para obtenerla haz click en la hora \n del post y copia los numeros del enlace)"), JOptionPane.showInputDialog("Introduce el comentario"));
    }

    public void buscarUser() throws FacebookException {

        ResponseList<User> userlist = PFclase.searchUsers(JOptionPane.showInputDialog("Introduce el nombre a buscar"));
        System.out.println(userlist);
    }
}
