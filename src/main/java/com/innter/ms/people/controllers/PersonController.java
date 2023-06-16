package com.innter.ms.people.controllers;


import com.innter.commons.response.Success;
import com.innter.ms.people.DTOs.PersonEditedRequest;
import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.services.IMPL.IPersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonRequest newPerson) {
        Success responseSuccess = new Success();
        responseSuccess.setCode(HttpStatus.CREATED.value());
        responseSuccess.setData(personService.savePersonWithAddress(newPerson));
        responseSuccess.setMessage("La persona se creo exitosamente.");
        responseSuccess.setUUID("hucsdoicjsokj3827equwhdil23");
        try {
            return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePerson(@Valid @RequestBody PersonEditedRequest newPerson, @PathVariable long id) {
        Success responseSuccess = new Success();
        responseSuccess.setCode(HttpStatus.OK.value());
        responseSuccess.setData(personService.editedPersonWithAddress(newPerson, id));
        responseSuccess.setMessage("La persona con el id:"+ id +" se actualizo exitosamente.");
        responseSuccess.setUUID("hucsdoicjsokj3827equwhdil23");
        try {
            return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIdPersonAddress(@Valid @PathVariable long id) {
        Success responseSuccess = new Success();
        responseSuccess.setCode(HttpStatus.FOUND.value());
        responseSuccess.setData(personService.getPerson(id));
        responseSuccess.setMessage("La persona con el id:"+ id +" se encontró exitosamente.");
        responseSuccess.setUUID("hucsdoicjsokj3827equwhdil23");
        try {
            return new ResponseEntity<>(responseSuccess, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByNamePersonAddress(@Valid
                                                    @RequestParam String name,
                                                    @RequestParam(required = false) String lastName,
                                                    @RequestParam(required = false) String surname,
                                                    @RequestParam(required = false) Integer pageIndex,
                                                    @RequestParam(required = false) Integer pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        Success responseSuccess = new Success();
        responseSuccess.setCode(HttpStatus.FOUND.value());
        responseSuccess.setData(personService.getPersonName(name, lastName, surname, pageable));
        responseSuccess.setMessage("La persona se encontro por nombre exitosamente.");
        responseSuccess.setUUID("hucsdoicjsokj3827equwhdil23");
        try {
            return new ResponseEntity<>(responseSuccess, HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePerson(@PathVariable("id") long id) {

            Success responseSuccess = new Success();
            responseSuccess.setCode(HttpStatus.OK.value());
            responseSuccess.setData(personService.deletePerson(id));
            responseSuccess.setMessage("El paciente con el id:"+ id +" se elimino correctamente.");
            responseSuccess.setUUID("hucsdoicjsokj3827equwhdil23");
        try {
            return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
