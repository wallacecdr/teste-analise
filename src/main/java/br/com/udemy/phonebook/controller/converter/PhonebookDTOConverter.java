package br.com.udemy.phonebook.controller.converter;

import br.com.udemy.phonebook.controller.dto.PhonebookDTO;
import br.com.udemy.phonebook.model.Phonebook;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                    phonebook.setZipCode(source.getZipCode());
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
                        .withZipCode(source.getZipCode())
                        .withCity(source.getCity())
                        .withUf(source.getUf())
                        .build())
                .orElse(null);
    }

    public List<PhonebookDTO> convert(List<Phonebook> phonebookList) {
        return Optional.ofNullable(phonebookList)
                .map(list -> list.stream().map(this::convert).collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }

    public Phonebook convert(String id, String name, String address, String number,
                                      String complement, String zipCode, String city, String uf) {
        Phonebook phonebook = new Phonebook();
        phonebook.setId(id);
        phonebook.setName(name);
        phonebook.setAddress(address);
        phonebook.setNumber(number);
        phonebook.setComplement(complement);
        phonebook.setZipCode(zipCode);
        phonebook.setCity(city);
        phonebook.setUf(uf);

        return phonebook;
    }
}
