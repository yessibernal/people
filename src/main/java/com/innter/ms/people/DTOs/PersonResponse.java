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

    @JsonProperty("person_id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @JsonProperty("email")
    @Email
    private String email;

    @JsonProperty("cellphone")
    @Size(min = 10, max = 13)
    private String cellphone;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private AddressResponse address;
}
