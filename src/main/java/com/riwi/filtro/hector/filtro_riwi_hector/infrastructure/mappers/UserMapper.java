package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.mappers;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.UserRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.update.UserUpdateRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toUser(UserRequest userRequest);


    UserResponse toUserResponse(User user);

    void updateFromUserRequest(UserUpdateRequest userRequest, @MappingTarget User user);
}