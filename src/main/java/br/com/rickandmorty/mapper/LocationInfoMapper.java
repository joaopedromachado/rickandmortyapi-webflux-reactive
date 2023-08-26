package br.com.rickandmorty.mapper;

import br.com.rickandmorty.client.model.location.LocationInfo;
import br.com.rickandmorty.dto.LocationInfoDto;

public class LocationInfoMapper {

    public static LocationInfo of(final LocationInfoDto locationInfoDto) {
        return LocationInfo.builder()
                .id(locationInfoDto.getId())
                .name(locationInfoDto.getName())
                .type(locationInfoDto.getType())
                .dimension(locationInfoDto.getDimension())
                .url(locationInfoDto.getUrl())
                .created(locationInfoDto.getCreated())
                .build();
    }


    public static LocationInfoDto of(final LocationInfo locationInfo) {
        return LocationInfoDto.builder()
                .id(locationInfo.getId())
                .name(locationInfo.getName())
                .type(locationInfo.getType())
                .dimension(locationInfo.getDimension())
                .url(locationInfo.getUrl())
                .created(locationInfo.getCreated())
                .build();
    }
}
