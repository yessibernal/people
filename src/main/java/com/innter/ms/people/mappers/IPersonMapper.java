package com.innter.ms.people.mappers;

import com.innter.ms.people.DTOs.PersonRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import com.innter.ms.people.entities.PersonEntity;
import org.mapstruct.Mapper;


@Mapper(
        componentModel = "spring"
)
public interface IPersonMapper {

    PersonResponse personToPersonResponse(PersonEntity person);

    PersonEntity personRequestToPerson(PersonRequest personRequest);


}
