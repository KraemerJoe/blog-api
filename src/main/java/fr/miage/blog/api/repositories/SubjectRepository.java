package fr.miage.blog.api.repositories;

import fr.miage.blog.api.entities.Subject;
import fr.miage.blog.api.entities.User;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class SubjectRepository implements PanacheMongoRepository<Subject> {

    public List<Subject> listAllSubject() {
        return listAll();
    }

    public Response deleteSubject(String objectId) {
        Subject subject = Subject.findById(new ObjectId(objectId));

        if(subject == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
            subject.delete();
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}