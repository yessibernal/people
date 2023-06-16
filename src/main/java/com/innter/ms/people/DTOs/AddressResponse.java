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

    @JsonProperty("address_id")
    private Long id;

    @JsonProperty("street")
    private String street;

    @NotNull
    @JsonProperty("external_number")
    private int externalNumber;

    @JsonProperty("internal_number")
    private int internalNumber;

    @JsonProperty("colony")
    private String colony;

    @JsonProperty("municipality")
    private String municipality;

    @JsonProperty("city")
    private String city;

    @NotNull
    @JsonProperty("post_code")
    private int postCode;
}
