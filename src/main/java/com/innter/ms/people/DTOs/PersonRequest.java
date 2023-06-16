package com.innter.ms.people.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {

    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotBlank
    @JsonProperty("last_name")
    private String lastName;

    @NotBlank
    @JsonProperty("surname")
    private String surname;

    @NotBlank
    @JsonProperty("gender")
    private String gender;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @NotBlank
    @JsonProperty("email")
    @Email
    private String email;

    @NotBlank
    @JsonProperty("cellphone")
    @Size(min = 10, max = 13)
    private String cellphone;

    @NotBlank
    @JsonProperty("phone")
    private String phone;


    @Valid
    @JsonProperty("address")
    private AddressRequest address;

}
