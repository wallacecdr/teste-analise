package br.com.udemy.phonebook.controller.converter;

import br.com.udemy.phonebook.controller.dto.PhonebookDTO;
import br.com.udemy.phonebook.model.Phonebook;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PhonebookDTOConverter {

    public Phonebook convert(PhonebookDTO phonebookDTO) {
        return Optional.ofNullable(phonebookDTO)
                .map(source -> {
                    Phonebook phonebook = new Phonebook();
                    phonebook.setId(source.getId());
                    phonebook.setName(source.getName());
                    phonebook.setAddress(source.getAddress());
                    phonebook.setNumber(source.getNumber());
                    phonebook.setComplement(source.getComplement());
                    phonebook.setZipNumber(source.getZipNumber());
                    phonebook.setCity(source.getCity());
                    phonebook.setUf(source.getUf());
                    return phonebook;
                })
                .orElse(null);
    }

    public PhonebookDTO convert(Phonebook phonebook) {
        return Optional.ofNullable(phonebook)
                .map(source -> PhonebookDTO.builder()
                        .withId(source.getId())
                        .withName(source.getName())
                        .withAddress(source.getAddress())
                        .withNumber(source.getNumber())
                        .withComplement(source.getComplement())
                        .withZipNumber(source.getZipNumber())
                        .withCity(source.getCity())
                        .withUf(source.getUf())
                        .build())
                .orElse(null);
    }
}
