package com.innter.ms.people.mappers;

import com.innter.ms.people.DTOs.PersonEditedRequest;
import com.innter.ms.people.DTOs.PersonResponse;
import com.innter.ms.people.entities.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring"
)
public interface IPersonEditedMapper {

    PersonResponse personToPersonEditedResponse(PersonEntity person);

    PersonEntity personRequestToPersonEdited(PersonEditedRequest personEditedRequest);

}
