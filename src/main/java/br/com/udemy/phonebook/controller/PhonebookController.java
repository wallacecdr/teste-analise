package br.com.udemy.phonebook.controller;

import br.com.udemy.phonebook.controller.dto.PhonebookDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phonebook")
public class PhonebookController {

    @PostMapping
    public void savePhonebook(PhonebookDTO phonebook) {
    }
}
