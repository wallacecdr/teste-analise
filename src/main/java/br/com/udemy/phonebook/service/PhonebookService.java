package br.com.udemy.phonebook.service;

import br.com.udemy.phonebook.client.ViaCepClient;
import br.com.udemy.phonebook.client.dto.ViaCepDTO;
import br.com.udemy.phonebook.model.Phonebook;
import br.com.udemy.phonebook.repository.PhonebookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhonebookService {

    private final PhonebookRepository phonebookRepository;
    private final ViaCepClient viaCepClient;

    public PhonebookService(PhonebookRepository phonebookRepository, ViaCepClient viaCepClient) {
        this.phonebookRepository = phonebookRepository;
        this.viaCepClient = viaCepClient;
    }

    public Phonebook save(Phonebook phonebook) {
        updateAddressIfNecessary(phonebook);
        return phonebookRepository.save(phonebook);
    }

    public List<Phonebook> findAll() {
        return phonebookRepository.findAll();
    }

    private void updateAddressIfNecessary(Phonebook phonebook) {
        if(!phonebook.hasAddress() && phonebook.hasZipCodeValid()) {
            ViaCepDTO viaCepDTO = viaCepClient.getAddress(phonebook.getZipCode());
            phonebook.setAddress(viaCepDTO.getAddress());
            phonebook.setComplement(viaCepDTO.getComplement());
            phonebook.setCity(viaCepDTO.getCity());
            phonebook.setUf(viaCepDTO.getUf());
        }
    }
}
