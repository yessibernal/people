package com.innter.ms.people.services;

import com.innter.ms.people.DAOs.AddressDAO;
import com.innter.ms.people.DAOs.PersonDAO;
import com.innter.ms.people.DTOs.PersonEditedRequest;
import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import com.innter.ms.people.entities.PersonEntity;
import com.innter.ms.people.exception.BadRequestInnter;
import com.innter.ms.people.exception.NotFoundInnter;
import com.innter.ms.people.mappers.IAddressMapper;
import com.innter.ms.people.mappers.PersonMapper;
import com.innter.ms.people.services.IMPL.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
        try {
            PersonEntity person = personMapper.personRequestToPerson(newPerson);
            personDAO.save(person);
            return personMapper.personToPersonResponse(person);
        } catch (Exception e) {
            throw new BadRequestInnter("P-400", HttpStatus.BAD_REQUEST, "La persona no se creo correctamente.");
        }
    }

    @Override
    @Transactional
    public PersonResponse editedPersonWithAddress(PersonEditedRequest newPersonEdited, Long id) {
        PersonEntity person = findPersonById(personDAO.findById(id));
        person.setBirthDate(newPersonEdited.getBirthDate());
        person.setEmail(newPersonEdited.getEmail());
        person.setCellphone(newPersonEdited.getCellphone());
        person.setPhone(newPersonEdited.getPhone());
        person.getAddress().setStreet(newPersonEdited.getAddress().getStreet());
        person.getAddress().setExternalNumber(newPersonEdited.getAddress().getExternalNumber());
        person.getAddress().setInternalNumber(newPersonEdited.getAddress().getInternalNumber());
        person.getAddress().setMunicipality(newPersonEdited.getAddress().getMunicipality());
        person.getAddress().setCity(newPersonEdited.getAddress().getCity());
        person.getAddress().setColony(newPersonEdited.getAddress().getColony());
        person.getAddress().setPostCode(newPersonEdited.getAddress().getPostCode());
        personDAO.save(person);
        return personMapper.personToPersonResponse(person);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonResponse getPerson(Long id) {
        PersonEntity person = findPersonById(personDAO.findById(id));
        PersonResponse personDto = personMapper.personToPersonResponse(person);
        return personDto;
    }

    @Override
    public List<PersonResponse> getPersonName(String name, String lastName, String surname, Pageable pageable) {
        try {
            List<PersonEntity> personEntity = personDAO.findPersonByName(name, lastName, surname, pageable); //Se llena la entidad
            List<PersonResponse> personDao = new ArrayList<PersonResponse>();
            personEntity.stream().forEach(person -> {
                personDao.add(personMapper.personToPersonResponse(person));
            });
            personDao.forEach(System.out::println); //Se imprime la lista
            return personDao;
        } catch (Exception e) {
            throw new NotFoundInnter("P-400", HttpStatus.NOT_FOUND, "La persona no se encontro por nombre correctamente.");
        }
    }

    @Override
    public Boolean deletePerson(Long id) {
        try {
            personDAO.deleteById(id);
            return Boolean.TRUE;
        } catch (Exception e) {
            throw new NotFoundInnter("P-404", HttpStatus.NOT_FOUND, "La persona no se elimino correctamente.");
        }
    }

    private PersonEntity findPersonById(Optional<PersonEntity> optionalPerson) {
        return optionalPerson.orElseThrow(() -> new NotFoundInnter("P-404", HttpStatus.NOT_FOUND, "La persona no se encontro correctamente."));
    }


}
