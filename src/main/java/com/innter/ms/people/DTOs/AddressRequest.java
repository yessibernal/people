package com.innter.ms.people.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    @NotNull
    @NotBlank
    @JsonProperty("street")
    private String street;

    @NotNull
    @Min(1)
    @JsonProperty("external_number")
    private int externalNumber;

    @JsonProperty("internal_number")
    private int internalNumber;

    @NotNull
    @NotBlank
    @JsonProperty("colony")
    private String colony;

    @NotNull
    @NotBlank
    @JsonProperty("municipality")
    private String municipality;

    @NotNull
    @NotBlank
    @JsonProperty("city")
    private String city;

    @NotNull
    @Min(5)
    @JsonProperty("post_code")
    private int postCode;
}
