package com.innter.ms.people.mappers;

import com.innter.ms.people.DTOs.AddressRequest;
import com.innter.ms.people.DTOs.AddressResponse;
import com.innter.ms.people.entities.AddressEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper implements IAddressMapper{
    @Override
    public AddressResponse addressToAddressResponse(AddressEntity address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setStreet(address.getStreet().toLowerCase());
        addressResponse.setExternalNumber(address.getExternalNumber());
        addressResponse.setInternalNumber(address.getInternalNumber());
        addressResponse.setColony(address.getColony().toLowerCase());
        addressResponse.setMunicipality(address.getMunicipality().toLowerCase());
        addressResponse.setCity(address.getCity().toLowerCase());
        addressResponse.setPostCode(address.getPostCode());
        return addressResponse;
    }

    @Override
    public AddressEntity addressRequestToAddress(AddressRequest addressRequest) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(addressRequest.getStreet().toLowerCase());
        addressEntity.setExternalNumber(addressRequest.getExternalNumber());
        addressEntity.setInternalNumber(addressRequest.getInternalNumber());
        addressEntity.setColony(addressRequest.getColony().toLowerCase());
        addressEntity.setMunicipality(addressRequest.getMunicipality().toLowerCase());
        addressEntity.setCity(addressRequest.getCity().toLowerCase());
        addressEntity.setPostCode(addressRequest.getPostCode());
        return addressEntity;
    }
}
