package br.com.udemy.phonebook.repository;

import br.com.udemy.phonebook.model.Phonebook;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonebookRepository extends MongoRepository<Phonebook, String> {

}
