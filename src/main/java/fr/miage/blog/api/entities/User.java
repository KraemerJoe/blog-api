package fr.miage.blog.api.entities;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@NoArgsConstructor
public class User extends PanacheMongoEntity  {

    public ObjectId id;
    public String email;
    public String username;
    public String password;

}
