package org.vinaylogics.hibernatebasics.annotation.column_mapping.oto_unidirectional_mapping.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses_otoum")
public class OTOUMAddress {

    @Id
    @GeneratedValue
    private long id;

    private String street;

    private String city;

    private String country;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OTOUMAddress address = (OTOUMAddress) o;
        return id == address.id &&
                Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(country, address.country);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, country);
    }
}
