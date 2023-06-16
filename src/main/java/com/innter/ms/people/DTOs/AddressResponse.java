package com.innter.ms.people.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class AddressResponse {

    @NotNull
    @JsonProperty("address_id")
    private Long id;

    @NotNull
    @JsonProperty("street")
    private String street;

    @NotNull
    @JsonProperty("external_number")
    private int externalNumber;

    @JsonProperty("internal_number")
    private int internalNumber;

    @NotNull
    @JsonProperty("colony")
    private String colony;

    @NotNull
    @JsonProperty("municipality")
    private String municipality;

    @NotNull
    @JsonProperty("city")
    private String city;

    @NotNull
    @JsonProperty("post_code")
    private int postCode;
}
