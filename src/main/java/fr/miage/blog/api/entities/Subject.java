package fr.miage.blog.api.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.Instant;
import java.util.ArrayList;

@NoArgsConstructor
public class Subject extends PanacheMongoEntity  {

    public ObjectId id;
    public String subject;
}
