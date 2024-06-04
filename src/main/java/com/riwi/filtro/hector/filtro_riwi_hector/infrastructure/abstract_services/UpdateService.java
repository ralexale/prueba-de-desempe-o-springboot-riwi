package com.riwi.filtro.hector.filtro_riwi_hector.infrastructure.abstract_services;

public interface UpdateService<Request, Response, Id> {

    Response update(Request request, Id id);
}
