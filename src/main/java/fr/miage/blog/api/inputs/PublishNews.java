package fr.miage.blog.api.inputs;

import fr.miage.blog.api.entities.News;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;

public class PublishNews {


    @NotNull public String title;
    @NotNull public String content;

    @NotNull public String author;
    @NotNull public String subject;

    public News generate() {
        News news = new News();
        news.title = this.title;
        news.content = this.content;
        news.author = this.author;
        news.subject = this.subject;
        news.favs = new ArrayList<>();
        news.releaseDate = Instant.now();
        return news;
    }

}