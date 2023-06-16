package com.innter.ms.people.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponse {

    @NotNull
    @JsonProperty("person_id")
    private Long id;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotNull
    @JsonProperty("last_name")
    private String lastName;

    @NotNull
    @JsonProperty("surname")
    private String surname;

    @NotNull
    @JsonProperty("gender")
    private String gender;

    @NotNull
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @NotBlank
    @JsonProperty("email")
    @Email
    private String email;

    @NotNull
    @JsonProperty("cellphone")
    @Size(min=10, max=13)
    private String cellphone;

    @NotNull
    @JsonProperty("phone")
    private String phone;

    @NotNull
    @JsonProperty("address")
    private AddressResponse address;
}
