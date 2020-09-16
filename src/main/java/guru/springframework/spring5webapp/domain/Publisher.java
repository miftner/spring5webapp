package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;
  private String streetName;
  private String houseNumber;
  private String postcode;
  private String city;
  private String country;

  @OneToMany
  @JoinColumn(name = "publisher_id")
  private Set<Book> books = new HashSet<>();

  public Publisher() {
  }

  @SuppressWarnings("checkstyle:MissingJavadocMethod")
  public Publisher(String firstName, String lastName, String streetName, String houseNumber,
                   String postcode, String city, String country) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.streetName = streetName;
    this.houseNumber = houseNumber;
    this.postcode = postcode;
    this.city = city;
    this.country = country;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetname) {
    this.streetName = streetname;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public void setHouseNumber(String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
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
  public String toString() {
    return "Publisher{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", LastName='" + lastName + '\'' +
        ", streetname='" + streetName + '\'' +
        ", houseNumber='" + houseNumber + '\'' +
        ", postcode=" + postcode +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Publisher publisher = (Publisher) o;

    return id != null ? id.equals(publisher.id) : publisher.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }
}
