package fr.miage.blog.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.lang.reflect.Array;
import java.util.ArrayList;

@NoArgsConstructor
public class User extends PanacheMongoEntity  {

    public ObjectId id;
    public String email;
    public String username;
    public ArrayList<String> follow;
    public ArrayList<String> favoriteNews;
    @JsonIgnore public String password;

}
