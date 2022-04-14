package fr.miage.blog.api.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.Instant;

@NoArgsConstructor
public class News extends PanacheMongoEntity  {

    public ObjectId id;
    public String title;
    public String content;
    public Instant releaseDate;

    public ObjectId authorId;
    public ObjectId subjectId;

}
