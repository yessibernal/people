package com.innter.ms.people.mappers;

import com.innter.ms.people.DTOs.AddressRequest;
import com.innter.ms.people.DTOs.AddressResponse;
import com.innter.ms.people.entities.AddressEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface IAddressMapper {


    AddressResponse addressToAddressResponse(AddressEntity address);

    AddressEntity addressRequestToAddress(AddressRequest addressRequest);
}
