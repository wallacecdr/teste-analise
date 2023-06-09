package br.com.udemy.phonebook.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhonebookDTO {

    private String id;
    private String name;
    private String address;
    private String number;
    private String complement;
    private String zipCode;
    private String city;
    private String uf;

    public PhonebookDTO() {

    }

    public PhonebookDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.number = builder.number;
        this.complement = builder.complement;
        this.zipCode = builder.zipCode;
        this.city = builder.city;
        this.uf = builder.uf;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getUf() {
        return uf;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String name;
        private String address;
        private String number;
        private String complement;
        private String zipCode;
        private String city;
        private String uf;

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withComplement(String complement) {
            this.complement = complement;
            return this;
        }

        public Builder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder withCity(String city) {
            this.city = city;
            return this;
        }

        public Builder withUf(String uf) {
            this.uf = uf;
            return this;
        }

        public PhonebookDTO build() {
            return new PhonebookDTO(this);
        }
    }
}
