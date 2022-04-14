package fr.miage.blog.api.repositories;

import fr.miage.blog.api.entities.News;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class NewsRepository implements PanacheMongoRepository<News> {

    public List<News> listAllNews() {
        return listAll();
    }

    public Response deleteNews(String objectId) {
        News news = News.findById(new ObjectId(objectId));

        if(news == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
            news.delete();
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

}