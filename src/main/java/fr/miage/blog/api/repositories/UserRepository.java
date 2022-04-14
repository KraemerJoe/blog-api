package fr.miage.blog.api.repositories;

import fr.miage.blog.api.entities.News;
import fr.miage.blog.api.entities.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

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

}