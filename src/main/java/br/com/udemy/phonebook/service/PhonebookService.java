package br.com.udemy.phonebook.service;

import br.com.udemy.phonebook.model.Phonebook;
import br.com.udemy.phonebook.repository.PhonebookRepository;
import org.springframework.stereotype.Service;

@Service
public class PhonebookService {

    private final PhonebookRepository phonebookRepository;

    public PhonebookService(PhonebookRepository phonebookRepository) {
        this.phonebookRepository = phonebookRepository;
    }

    public Phonebook save(Phonebook phonebook) {
        return phonebookRepository.save(phonebook);
    }
}
