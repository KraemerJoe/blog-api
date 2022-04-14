package fr.miage.blog.api.inputs;

import fr.miage.blog.api.entities.Subject;

import javax.validation.constraints.NotNull;

public class LoginCredentials {


    @NotNull public String email;
    @NotNull public String password;

}