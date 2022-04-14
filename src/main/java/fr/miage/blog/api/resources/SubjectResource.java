package fr.miage.blog.api.resources;

import fr.miage.blog.api.entities.Subject;
import fr.miage.blog.api.entities.User;
import fr.miage.blog.api.inputs.CreateSubject;
import fr.miage.blog.api.inputs.CreateUser;
import fr.miage.blog.api.repositories.SubjectRepository;
import fr.miage.blog.api.repositories.UserRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/subjects")
public class SubjectResource {

    @Inject
    SubjectRepository subjectRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Subject> list() {
        return subjectRepository.listAll();
    }

    @POST
    public Response createSubject(@Valid CreateSubject createSubject) {
        Subject subject = createSubject.generate();
        subject.persist();
        return Response.created(URI.create("/users/" + subject.id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSubject(@PathParam("id") String id) {
        return subjectRepository.deleteSubject(id);
    }

}