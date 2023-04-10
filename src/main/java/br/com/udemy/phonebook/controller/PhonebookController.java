package br.com.udemy.phonebook.controller;

import br.com.udemy.phonebook.controller.converter.PhonebookDTOConverter;
import br.com.udemy.phonebook.controller.dto.PhonebookDTO;
import br.com.udemy.phonebook.service.PhonebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("phonebook")
public class PhonebookController {

    private final PhonebookService phonebookService;
    private final PhonebookDTOConverter phonebookConverter;

    public PhonebookController(PhonebookService phonebookService,
                               PhonebookDTOConverter phonebookConverter) {
        this.phonebookService = phonebookService;
        this.phonebookConverter = phonebookConverter;
    }

    @PostMapping
    public ResponseEntity<PhonebookDTO> savePhonebook(@RequestBody PhonebookDTO phonebook) {
        return ResponseEntity.ok(phonebookConverter
                .convert(phonebookService.save(phonebookConverter.convert(phonebook))));
    }

    @GetMapping
    public ResponseEntity<List<PhonebookDTO>> getPhonebook() {
        return ResponseEntity.ok(phonebookConverter.convert(phonebookService.findAll()));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePhonebook(@PathVariable String id) {
        phonebookService.deleteById(id);
    }
}
