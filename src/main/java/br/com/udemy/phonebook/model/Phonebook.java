package br.com.udemy.phonebook.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("phonebook")
public class Phonebook {

    @Id
    private String id;
    private String name;
    private String address;
    private String number;
    private String complement;
    private String zipNumber;
    private String city;
    private String uf;
}
