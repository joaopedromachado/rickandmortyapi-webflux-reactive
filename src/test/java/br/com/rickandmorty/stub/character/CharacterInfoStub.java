package br.com.rickandmorty.stub.character;

import br.com.rickandmorty.client.model.character.CharacterInfo;
import br.com.rickandmorty.dto.CharacterInfoDto;

import java.util.List;

import static br.com.rickandmorty.stub.character.Location.*;
import static br.com.rickandmorty.stub.character.Origin.ORIGIN;

public class CharacterInfoStub {

    public static final CharacterInfoDto CHARACTER_DTO = CharacterInfoDto.builder()
            .id(2)
            .name("Morty Smith")
            .status("Alive")
            .species("Human")
            .gender("Male")
            .origin(ORIGIN)
            .location(LOCATION)
            .image("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
            .episode(List.of("123", "321"))
            .url("https://rickandmortyapi.com/api/character/2")
            .created("2017-11-04T18:50:21.651Z")
            .build();

    public static final CharacterInfo CHARACTER = CharacterInfo.builder()
            .id(2)
            .name("Morty Smith")
            .status("Alive")
            .species("Human")
            .gender("Male")
            .origin(ORIGIN)
            .location(LOCATION)
            .image("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
            .episode(List.of("123", "321"))
            .url("https://rickandmortyapi.com/api/character/2")
            .created("2017-11-04T18:50:21.651Z")
            .build();

}
