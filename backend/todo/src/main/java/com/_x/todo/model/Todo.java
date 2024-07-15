package com._x.todo.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document(collection = "todos")
@Data
public class Todo {

    ObjectId id;

    String title;

    String description;

    boolean completed;

}
