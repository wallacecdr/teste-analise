package br.com.udemy.phonebook.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepDTO {

    @JsonProperty("logradouro")
    private String address;
    @JsonProperty("complemento")
    private String complement;
    @JsonProperty("localidade")
    private String city;
    private String uf;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
