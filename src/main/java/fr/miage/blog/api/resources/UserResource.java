package fr.miage.blog.api.resources;

import fr.miage.blog.api.entities.News;
import fr.miage.blog.api.entities.User;
import fr.miage.blog.api.inputs.CreateUser;
import fr.miage.blog.api.inputs.LoginCredentials;
import fr.miage.blog.api.inputs.PublishNews;
import fr.miage.blog.api.repositories.NewsRepository;
import fr.miage.blog.api.repositories.UserRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/users")
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list() {
        return userRepository.listAll();
    }

    @POST
    public Response createUser(@Valid CreateUser createUser) {
        User user = createUser.generate();
        user.persist();
        return Response.created(URI.create("/users/" + user.id)).build();
    }

    @POST
    @Path("/login")
    public Response login(@Valid LoginCredentials loginCredentials){
        return userRepository.login(loginCredentials);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        return userRepository.deleteUser(id);
    }

}