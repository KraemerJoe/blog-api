package fr.miage.blog.api.repositories;

import fr.miage.blog.api.entities.News;
import fr.miage.blog.api.entities.User;
import fr.miage.blog.api.inputs.LoginCredentials;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public List<User> listAllUsers() {
        return listAll();
    }

    public Response deleteUser(String objectId) {
        User user = User.findById(new ObjectId(objectId));

        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
            user.delete();
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    public Response login(LoginCredentials loginCredentials) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", loginCredentials.email);
        params.put("password", loginCredentials.password);
        if(User.find("email = :email and password = :password", params).firstResult() != null){
            return Response.status(Response.Status.OK).build();
        }else{
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}