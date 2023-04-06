package br.com.udemy.phonebook.controller.dto;

public class PhonebookDTO {

    private final String id;
    private final String name;
    private final String address;
    private final String number;
    private final String complement;
    private final String zipNumber;
    private final String city;
    private final String uf;

    public PhonebookDTO(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
        this.number = builder.number;
        this.complement = builder.complement;
        this.zipNumber = builder.zipNumber;
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

    public String getZipNumber() {
        return zipNumber;
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
        private String zipNumber;
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

        public Builder withZipNumber(String zipNumber) {
            this.zipNumber = zipNumber;
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
