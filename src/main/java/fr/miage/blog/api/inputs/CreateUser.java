package fr.miage.blog.api.inputs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.miage.blog.api.entities.News;
import fr.miage.blog.api.entities.User;

import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.ArrayList;

public class CreateUser {


    @NotNull public String email;
    @NotNull public String username;
    @NotNull public String password;

    public User generate() {
        User user = new User();
        user.email = this.email;
        user.username = this.username;
        user.password = this.password;
        user.follow = new ArrayList<>();
        return user;
    }

}