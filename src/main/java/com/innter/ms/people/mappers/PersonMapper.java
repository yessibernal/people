package com.innter.ms.people.mappers;

import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import com.innter.ms.people.entities.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PersonMapper implements IPersonMapper {

    @Autowired
    private IAddressMapper addressMapper;


    @Override
    public PersonResponse personToPersonResponse(PersonEntity person) {
        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setName(person.getName().toLowerCase());
        personResponse.setLastName(person.getLastName().toLowerCase());
        personResponse.setSurname(person.getSurname().toLowerCase());
        personResponse.setGender(person.getGender().toLowerCase());
        personResponse.setBirthDate(person.getBirthDate());
        personResponse.setEmail(person.getEmail().toLowerCase());
        personResponse.setCellphone(person.getCellphone());
        personResponse.setPhone(person.getPhone());
        personResponse.setAddress(addressMapper.addressToAddressResponse(person.getAddress()));
        return personResponse;
    }


    @Override
    public PersonEntity personRequestToPerson(PersonRequest personRequest) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personRequest.getName().toLowerCase());
        personEntity.setLastName(personRequest.getLastName().toLowerCase());
        personEntity.setSurname(personRequest.getSurname().toLowerCase());
        personEntity.setGender(personRequest.getGender().toLowerCase());
        personEntity.setBirthDate(personRequest.getBirthDate());
        personEntity.setEmail(personRequest.getEmail().toLowerCase());
        personEntity.setCellphone(personRequest.getCellphone());
        personEntity.setPhone(personRequest.getPhone());
        personEntity.setAddress(addressMapper.addressRequestToAddress(personRequest.getAddress()));
        return personEntity;
    }
}
