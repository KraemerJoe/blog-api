package fr.miage.blog.api.repositories;

import fr.miage.blog.api.entities.News;
import fr.miage.blog.api.entities.Subject;
import fr.miage.blog.api.entities.User;
import fr.miage.blog.api.inputs.LoginCredentials;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class UserRepository implements PanacheMongoRepository<User> {

    public List<User> listAllUsers() {
        return listAll();
    }

    public Response deleteUser(String objectId) {
        User user = User.findById(new ObjectId(objectId));

        if(user == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        else {
            user.delete();
            return Response.status(Response.Status.NO_CONTENT).build();
        }
    }

    public User login(LoginCredentials loginCredentials) {
        Map<String, Object> params = new HashMap<>();
        params.put("email", loginCredentials.email);
        params.put("password", loginCredentials.password);
        return User.find("email = :email and password = :password", params).firstResult();
    }

    public List<String> getFollows(String id) {
        User user = User.findById(new ObjectId(id));
        return user.follow;
    }

    public List<String> getFollowers(String id) {
        User user = User.findById(new ObjectId(id));
        return user.followers;
    }

    public Response follow(String id, String userId) {
        User user = User.findById(new ObjectId(id));

        User userFollowed = User.findById(new ObjectId(userId));
        userFollowed.followers.add(id);
        userFollowed.update();

        if(user.follow == null) user.follow = new ArrayList<>();
        user.follow.add(userId);
        user.update();
        return Response.status(Response.Status.OK).build();
    }

    public Response unfollow(String id, String userId) {
        User user = User.findById(new ObjectId(id));
        if(user.follow == null) user.follow = new ArrayList<>();
        user.follow.remove(userId);
        user.update();
        return Response.status(Response.Status.OK).build();
    }

    public List<String> getFavoriteNews(String id) {
        User user = User.findById(new ObjectId(id));
        return user.favoriteNews;
    }

    public Response favorite(String id, String newsId) {
        User user = User.findById(new ObjectId(id));

        News news = News.findById(new ObjectId(newsId));
        news.favs.add(id);
        news.update();

        if(user.favoriteNews == null) user.favoriteNews = new ArrayList<>();
        user.favoriteNews.add(newsId);
        user.update();
        return Response.status(Response.Status.OK).build();
    }

    public Response unfavorite(String id, String newsId) {
        User user = User.findById(new ObjectId(id));
        if(user.favoriteNews == null) user.favoriteNews = new ArrayList<>();
        user.favoriteNews.remove(newsId);
        user.update();
        return Response.status(Response.Status.OK).build();
    }
}