package com.ecommerce.urbanize.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String last_name1;

    @Size(min = 3, max = 255)
    private String last_name2;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate birth_date;

    @NotNull
    @Size(min = 9, max = 9, message = "The phone number must have 9 characters")
    @Pattern(regexp = "\\+?[0-9]+", message = "The phone number must contain only digits")
    private int phone_number;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9, message = "The DNI must have 8 characters")
    @Pattern(regexp = "\\d+", message = "The DNI must contain only digits")
    private String dni;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String city;

    @NotNull
    @Min(value = 1000, message = "The postal code must be at least 1000")
    @Max(value = 52999, message = "The postal code must be at most 52999")
    private int postal_code;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String address;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 15)
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    @NotBlank
    @Size(min = 64, max = 64)
    @Pattern(regexp = "^[a-fA-F0-9]+$", message = "Password must be hexadecimal")
    private String password = "e2cac5c5f7e52ab03441bb70e89726ddbd1f6e5b683dde05fb65e0720290179e";

    private Boolean role = false;

    @OneToMany(mappedBy = "user", fetch = jakarta.persistence.FetchType.LAZY)
    private List<PurchaseEntity> orders;

    @OneToMany(mappedBy = "user", fetch = jakarta.persistence.FetchType.LAZY)
    private List<RatingEntity> ratings;

    @OneToMany(mappedBy = "user", fetch = jakarta.persistence.FetchType.LAZY)
    private List<CartEntity> carts;

    /**
     * Default constructor initializes lists.
     */
    public UserEntity() {
        orders = new ArrayList<>();
        ratings = new ArrayList<>();
        carts = new ArrayList<>();
    }

    /**
     * Constructor with parameters for full entity initialization.
     *
     * @param id           The user's ID.
     * @param name         The user's first name.
     * @param last_name1   The user's first last name.
     * @param last_name2   The user's second last name.
     * @param birth_date   The user's birth date.
     * @param phone_number The user's phone number.
     * @param dni          The user's DNI.
     * @param postal_code  The user's postal code.
     * @param city         The user's city.
     * @param address      The user's address.
     * @param email        The user's email address.
     * @param username     The user's username.
     * @param password     The user's password.
     * @param role         The user's role.
     */
    public UserEntity(Long id, String name, String last_name1, String last_name2, LocalDate birth_date,
            int phone_number,
            String dni,
            int postal_code, String city, String address, String email, String username, String password,
            Boolean role) {
        this.id = id;
        this.name = name;
        this.last_name1 = last_name1;
        this.last_name2 = last_name2;
        this.birth_date = birth_date;
        this.phone_number = phone_number;
        this.dni = dni;
        this.city = city;
        this.postal_code = postal_code;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Constructor with parameters for partial entity initialization.
     *
     * @param name        The user's first name.
     * @param lastName1   The user's first last name.
     * @param lastName2   The user's second last name.
     * @param birthDate   The user's birth date.
     * @param phoneNumber The user's phone number.
     * @param dni         The user's DNI.
     * @param postalCode  The user's postal code.
     * @param city        The user's city.
     * @param address     The user's address.
     * @param email       The user's email address.
     * @param username    The user's username.
     * @param password    The user's password.
     * @param role        The user's role.
     */
    public UserEntity(String name, String lastName1, String lastName2, LocalDate birthDate, int phoneNumber, String dni,
            int postalCode, String city, String address, String email, String username, String password,
            Boolean role) {
        this.name = name;
        this.last_name1 = lastName1;
        this.last_name2 = lastName2;
        this.birth_date = birthDate;
        this.phone_number = phoneNumber;
        this.dni = dni;
        this.city = city;
        this.postal_code = postalCode;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Constructor with parameters for minimal entity initialization.
     *
     * @param username The user's username.
     * @param password The user's password.
     */
    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Get the user's ID.
     *
     * @return The user's ID.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the user's ID.
     *
     * @param id The user's ID.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the user's first name.
     *
     * @return The user's first name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the user's first name.
     *
     * @param name The user's first name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the user's first last name.
     *
     * @return The user's first last name.
     */
    public String getLastName1() {
        return last_name1;
    }

    /**
     * Set the user's first last name.
     *
     * @param lastName1 The user's first last name.
     */
    public void setLastName1(String lastName1) {
        this.last_name1 = lastName1;
    }

    /**
     * Get the user's second last name.
     *
     * @return The user's second last name.
     */
    public String getLastName2() {
        return last_name2;
    }

    /**
     * Set the user's second last name.
     *
     * @param lastName2 The user's second last name.
     */
    public void setLastName2(String lastName2) {
        this.last_name2 = lastName2;
    }

    /**
     * Get the user's birth date.
     *
     * @return The user's birth date.
     */
    public LocalDate getBirthDate() {
        return birth_date;
    }

    /**
     * Set the user's birth date.
     *
     * @param birthDate The user's birth date.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birth_date = birthDate;
    }

    /**
     * Get the user's phone number.
     *
     * @return The user's phone number.
     */
    public int getPhoneNumber() {
        return phone_number;
    }

    /**
     * Set the user's phone number.
     *
     * @param phoneNumber The user's phone number.
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phone_number = phoneNumber;
    }

    /**
     * Get the user's DNI.
     *
     * @return The user's DNI.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Set the user's DNI.
     *
     * @param dni The user's DNI.
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Get the user's city.
     *
     * @return The user's city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the user's city.
     *
     * @param city The user's city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the user's postal code.
     *
     * @return The user's postal code.
     */
    public int getPostalCode() {
        return postal_code;
    }

    /**
     * Set the user's postal code.
     *
     * @param postalCode The user's postal code.
     */
    public void setPostalCode(int postalCode) {
        this.postal_code = postalCode;
    }

    /**
     * Get the user's address.
     *
     * @return The user's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the user's address.
     *
     * @param address The user's address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Get the user's email address.
     *
     * @return The user's email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the user's email address.
     *
     * @param email The user's email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the user's username.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the user's username.
     *
     * @param username The user's username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the user's password.
     *
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the user's password.
     *
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user's role.
     *
     * @return The user's role.
     */
    public Boolean getRole() {
        return role;
    }

    /**
     * Set the user's role.
     *
     * @param role The user's role.
     */
    public void setRole(Boolean role) {
        this.role = role;
    }

    /**
     * Get the list of user's orders.
     *
     * @return The list of user's orders.
     */
    public List<PurchaseEntity> getOrders() {
        return orders;
    }

    /**
     * Get the list of user's ratings.
     *
     * @return The list of user's ratings.
     */
    public List<RatingEntity> getRatings() {
        return ratings;
    }

    /**
     * Get the list of user's carts.
     *
     * @return The list of user's carts.
     */
    public List<CartEntity> getCarts() {
        return carts;
    }

}