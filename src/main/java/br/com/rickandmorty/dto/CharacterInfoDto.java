package br.com.rickandmorty.dto;

import br.com.rickandmorty.client.model.character.Location;
import br.com.rickandmorty.client.model.character.Origin;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class CharacterInfoDto {

    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private List<String> episode;
    private String url;
    private String created;
}
