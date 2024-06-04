package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.request.create.UserRequest;
import com.riwi.filtro.hector.filtro_riwi_hector.api.dto.response.UserResponse;


public interface IUserService extends CreateReadService<UserRequest, UserResponse, Long>,
        UpdateService<UserRequest, UserResponse, Long> {

}
