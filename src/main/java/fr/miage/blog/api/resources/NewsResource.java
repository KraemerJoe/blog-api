package fr.miage.blog.api.resources;

import fr.miage.blog.api.entities.News;
import fr.miage.blog.api.inputs.PublishNews;
import fr.miage.blog.api.repositories.NewsRepository;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/news")
public class NewsResource {

    @Inject
    NewsRepository newsRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<News> list() {
        return newsRepository.listAll();
    }

    @POST
    public Response publishNews(@Valid PublishNews publishNews) {
        News news = publishNews.generate();
        news.persist();
        return Response.created(URI.create("/news/" + news.id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNews(@PathParam("id") String id) {
        return newsRepository.deleteNews(id);
    }

}