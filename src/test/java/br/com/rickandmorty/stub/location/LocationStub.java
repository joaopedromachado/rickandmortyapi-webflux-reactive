package br.com.rickandmorty.stub.location;

import br.com.rickandmorty.client.model.location.LocationInfo;
import br.com.rickandmorty.dto.LocationInfoDto;

import java.util.List;

public class LocationStub {

    public static final LocationInfoDto LOCATION_INFO_DTO = LocationInfoDto.builder()
            .id(100)
            .name("Ricks’s Story")
            .type("Diegesis")
            .residents(List.of("teste1", "teste2", "teste3", "teste4"))
            .url("https://rickandmortyapi.com/api/location/100")
            .created("2020-08-06T11:45:08.782Z")
            .build();

    public static final LocationInfo LOCATION = LocationInfo.builder()
            .id(100)
            .name("Ricks’s Story")
            .type("Diegesis")
            .residents(List.of("teste1", "teste2", "teste3", "teste4"))
            .url("https://rickandmortyapi.com/api/location/100")
            .created("2020-08-06T11:45:08.782Z")
            .build();
}
