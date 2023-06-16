package com.innter.ms.people.services;

import com.innter.ms.people.DAOs.AddressDAO;
import com.innter.ms.people.DAOs.PersonDAO;
import com.innter.ms.people.DTOs.PersonEditedRequest;
import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import com.innter.ms.people.entities.PersonEntity;
import com.innter.ms.people.mappers.IAddressMapper;
import com.innter.ms.people.mappers.PersonMapper;
import com.innter.ms.people.services.IMPL.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private IAddressMapper addressMapper;


    @Override
    @Transactional
    public PersonResponse savePersonWithAddress(PersonRequest newPerson) {
        PersonEntity person = personMapper.personRequestToPerson(newPerson);
        personDAO.save(person);
        return personMapper.personToPersonResponse(person);
    }

    @Override
    @Transactional
    public PersonResponse editedPersonWithAddress(PersonEditedRequest newPersonEdited, Long id) {
        PersonEntity person = personDAO.findById(id).get();
        person.setBirthDate(newPersonEdited.getBirthDate());
        person.setEmail(newPersonEdited.getEmail());
        person.setCellphone(newPersonEdited.getCellphone());
        person.setPhone(newPersonEdited.getPhone());
        person.getAddress().setStreet(newPersonEdited.getAddress().getStreet());
        person.getAddress().setExternalNumber(newPersonEdited.getAddress().getExternalNumber());
        person.getAddress().setInternalNumber(newPersonEdited.getAddress().getInternalNumber());
        person.getAddress().setColony(newPersonEdited.getAddress().getColony());
        person.getAddress().setMunicipality(newPersonEdited.getAddress().getMunicipality());
        person.getAddress().setCity(newPersonEdited.getAddress().getCity());
        person.getAddress().setPostCode(newPersonEdited.getAddress().getPostCode());
        personDAO.save(person);
        return personMapper.personToPersonResponse(person);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonResponse getPerson(Long id) {
        Optional<PersonEntity> optionalPerson = personDAO.findById(id);
        PersonResponse personDto = new PersonResponse();
        PersonEntity person = optionalPerson.get();
        personDto = personMapper.personToPersonResponse(person);
        return personDto;
    }

    @Override
    public List<PersonResponse> getPersonName(String name, String lastName, String surname, Pageable pageable) {
        List<PersonEntity> personEntity = personDAO.findPersonByName(name, lastName, surname, pageable); //Se llena la entidad
        List<PersonResponse> personDao = new ArrayList<PersonResponse>();
        personEntity.stream().forEach(person -> {
            personDao.add(personMapper.personToPersonResponse(person));
        });
        personDao.forEach(System.out::println); //Se imprime la lista
        return personDao;
    }

    @Override
    public Boolean deletePerson(Long id) {
        try {
            personDAO.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

}
