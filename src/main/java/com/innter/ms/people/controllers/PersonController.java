package com.innter.ms.people.controllers;


import com.innter.commons.response.SuccessResponse;
import com.innter.ms.people.DTOs.PersonEditedRequest;
import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.services.IMPL.IPersonService;
import com.innter.ms.people.utils.ResponseUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @Autowired
    private ResponseUtils responseUtils;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPerson(@Valid @RequestBody PersonRequest newPerson) {
        SuccessResponse responseSuccess = responseUtils.successResponseCreate(personService.savePersonWithAddress(newPerson),
                "La persona se creo correctamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatePerson(@Valid @RequestBody PersonEditedRequest newPerson, @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(personService.editedPersonWithAddress(newPerson, id),
                "La persona con el id:" + id + " se actualizo correctamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIdPersonAddress(@Valid @PathVariable long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(personService.getPerson(id),
                "La persona con el id:" + id + " se encontró correctamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.FOUND);
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByNamePersonAddress(@Valid
                                                    @RequestParam String name,
                                                    @RequestParam(required = false) String lastName,
                                                    @RequestParam(required = false) String surname,
                                                    @RequestParam(required = false) Integer pageIndex,
                                                    @RequestParam(required = false) Integer pageSize) {
        Pageable pageable = PageRequest.of(pageIndex, pageSize);
        SuccessResponse responseSuccess = responseUtils.successResponseOK(personService.getPersonName(name, lastName, surname, pageable),
                "La persona se encontro por nombre correctamente.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.FOUND);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletePerson(@PathVariable("id") long id) {
        SuccessResponse responseSuccess = responseUtils.successResponseOK(personService.deletePerson(id),
                "El paciente con el id:" + id + " se elimino de manera correcta.");
        return new ResponseEntity<>(responseSuccess, HttpStatus.OK);
    }

}
