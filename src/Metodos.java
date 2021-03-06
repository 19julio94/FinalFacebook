
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

    /**
     *
     */
    public Facebook PFclase;

    /**
     *Metodo donde se insertan los tokens de nuestra app para que funcione,en el AccessToken hay que configurar los permisos
     * @return
     */
    public Facebook iniciar() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        //introducir los tokens en los huecos con comillas
        cb.setDebugEnabled(true)
                .setOAuthAppId("")
                .setOAuthAppSecret("")
                .setOAuthAccessToken("");

        FacebookFactory ff = new FacebookFactory(cb.build());
        PFclase = ff.getInstance();
        return PFclase;
    }

    /**
     *Metodo que nos actualiza el estado,donde nosotros introduciremos el estado que queramos
     * @throws FacebookException
     */
    public void estado() throws FacebookException {

        PFclase.postStatusMessage(JOptionPane.showInputDialog("Introduce estado"));

    }

    /**
     *Metodo que sirve para dar like a un post que nosotros querramos donde nosotros tendremos que expecificar el ID
     * @throws FacebookException
     */
    public void darLike() throws FacebookException {

        PFclase.likePost(JOptionPane.showInputDialog("Introduce la ID del Post \n (Para obtenerla haz click en la hora \n del post y copia los numeros del enlace)"));
    }

    /**
     *Metodo para postear una imagen,tendremos que ponerle la direccion manualmente
     * @throws MalformedURLException
     * @throws FacebookException
     */
    public void subirImagen() throws MalformedURLException, FacebookException {

        PostUpdate post = new PostUpdate(new URL("https://www.formula1.com/content/fom-website/en.html"))
                .picture(new URL("http://e01-marca.uecdn.es/assets/multimedia/imagenes/2016/03/20/14584597103222.jpg"))
                .description("Crash Fernando Alonso ");
        PFclase.postFeed(post);

    }

    /**
     *Metodo para buscar un tema pero no funciona a partir de la GraphAPI 2.0 o superior
     * @throws FacebookException
     */
    public void buscarTema() throws FacebookException {
       
        ResponseList<Post> results = PFclase.searchPosts(JOptionPane.showInputDialog("Selecciona el tema del que buscar posts"));
        JOptionPane.showMessageDialog(null, results);
    }

    /**
     *Metodo para buscar comentarios de un post que nosotros indiquemos mediante el ID
     * @throws FacebookException
     */
    public void buscarComentarios() throws FacebookException {

        ResponseList<Comment> lista = PFclase.getCommentReplies(JOptionPane.showInputDialog("Selecciona el post del que buscar comentarios"));
        System.out.println(lista);
    }
    
    /**
     *Metodo para comentar en una foto mediante el ID de la foto que nosotros introduzcamos,en mi caso no da error pero no publica
     * @throws FacebookException
     */
    public void comentarFoto() throws FacebookException {

        PFclase.commentPhoto(JOptionPane.showInputDialog("Introduce la ID del post \n (Para obtenerla haz click en la hora \n del post y copia los numeros del enlace)"), JOptionPane.showInputDialog("Introduce el comentario"));
    }

    /**
     *Metodo para buscar un usuario,introducimos un nombre y nos mostrara todos los usuarios con dicho nombre
     * @throws FacebookException
     */
    public void buscarUsuario() throws FacebookException {

        ResponseList<User> userlist = PFclase.searchUsers(JOptionPane.showInputDialog("Introduce el nombre a buscar"));
        System.out.println(userlist);
    }
}
