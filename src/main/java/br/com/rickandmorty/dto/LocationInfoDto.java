package br.com.rickandmorty.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class LocationInfoDto {

    private int id;
    private String name;
    private String type;
    private String Dimension;
    private List<String> residents;
    private String url;
    private String created;

}
