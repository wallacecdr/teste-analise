package br.com.udemy.phonebook.client;

import br.com.udemy.phonebook.client.dto.ViaCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ViaCep", url = "${viacep.url}")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepDTO getAddress(@PathVariable String cep);
}
