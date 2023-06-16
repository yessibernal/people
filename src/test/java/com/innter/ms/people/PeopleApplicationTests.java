package com.innter.ms.people;

import com.innter.ms.people.DAOs.PersonDAO;
import com.innter.ms.people.DTOs.AddressRequest;
import com.innter.ms.people.DTOs.AddressResponse;
import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import com.innter.ms.people.entities.AddressEntity;
import com.innter.ms.people.entities.PersonEntity;
import com.innter.ms.people.services.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

//@SpringBootTest(classes = PeopleApplication.class)
class PeopleApplicationTests {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private PersonService personService;

    @Test
    void contextLoads() {

        PersonRequest personExample = new PersonRequest();
        personExample.setName("Wero");
        personExample.setLastName("Chapeete");
        personExample.setSurname("No calico");
        LocalDate birthDate = LocalDate.of(2022, 01, 10);
        personExample.setBirthDate(birthDate);
        personExample.setGender("Masculino");
        personExample.setEmail("wero@gmail.com");
        personExample.setPhone("2463101737");
        personExample.setCellphone("2461976418");
        AddressRequest address = new AddressRequest();
        address.setStreet("20 de noviembre");
        address.setExternalNumber(10);
        address.setInternalNumber(0);
        address.setColony("La loma");
        address.setMunicipality("Papalotla");
        address.setCity("Puebla");
        address.setPostCode(90000);
        personExample.setAddress(address);
        PersonResponse createdPerson = personService.savePersonWithAddress(personExample);
        System.out.println(createdPerson);

    }

}
