package br.com.udemy.phonebook.repository;

import br.com.udemy.phonebook.model.Phonebook;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class PhonebookCustomRepository {

    private final MongoOperations mongoOperations;

    public PhonebookCustomRepository(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public Page<Phonebook> findPaginated(Phonebook phonebook, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").descending());

        Example<Phonebook> example = Example.of(phonebook);

        Query query = Query.query(Criteria.byExample(example)).with(pageable);

        return PageableExecutionUtils.getPage(mongoOperations.find(query, Phonebook.class), pageable, () -> mongoOperations.count(query, Phonebook.class));
    }
}
