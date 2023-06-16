package com.innter.ms.people.services.IMPL;

import com.innter.ms.people.DTOs.PersonEditedRequest;
import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPersonService {

    public PersonResponse savePersonWithAddress(PersonRequest newPerson);

    public PersonResponse editedPersonWithAddress(PersonEditedRequest newPersonEdited, Long id);

    public PersonResponse getPerson(Long id);

    public List<PersonResponse> getPersonName(String name, String lastName, String surname, Pageable pageable);

    public Boolean deletePerson(Long id);

}
