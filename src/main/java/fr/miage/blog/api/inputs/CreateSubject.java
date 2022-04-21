package fr.miage.blog.api.inputs;

import fr.miage.blog.api.entities.Subject;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class CreateSubject {


    @NotNull public String subject;


    public Subject generate() {
        Subject subject = new Subject();
        subject.subject = this.subject;
        return subject;
    }

}