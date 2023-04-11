package br.com.udemy.phonebook.controller;

import br.com.udemy.phonebook.controller.converter.PhonebookDTOConverter;
import br.com.udemy.phonebook.controller.dto.PhonebookDTO;
import br.com.udemy.phonebook.service.PhonebookService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<PhonebookDTO> getPhonebook(@RequestParam(required = false) String id,
                                                           @RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String address,
                                                           @RequestParam(required = false) String number,
                                                           @RequestParam(required = false) String complement,
                                                           @RequestParam(required = false) String zipCode,
                                                           @RequestParam(required = false) String city,
                                                           @RequestParam(required = false) String uf,
                                                           @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                                           @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) {

        return phonebookService.findPaginated(phonebookConverter.convert(id, name, address, number, complement, zipCode, city, uf), pageNumber, pageSize)
                .map(phonebookConverter::convert);
    }

    @PutMapping
    public ResponseEntity<PhonebookDTO> updatePhonebook(@RequestBody PhonebookDTO phonebook) {
        return ResponseEntity.ok(phonebookConverter
                .convert(phonebookService.update(phonebookConverter.convert(phonebook))));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePhonebook(@PathVariable String id) {
        phonebookService.deleteById(id);
    }
}
