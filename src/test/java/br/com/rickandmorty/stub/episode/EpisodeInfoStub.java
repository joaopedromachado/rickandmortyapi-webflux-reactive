package br.com.rickandmorty.stub.episode;

import br.com.rickandmorty.dto.EpisodeInfoDto;

import java.util.List;

public class EpisodeInfoStub {

    public static final EpisodeInfoDto EPISODE_INFO_DTO = EpisodeInfoDto.builder()
            .id(25)
            .name("Vindicators 3: The Return of Worldender")
            .airDate("August 13, 2017")
            .episode("S03E04")
            .characters(List.of("teste1", "teste2", "teste3"))
            .url("https://rickandmortyapi.com/api/episode/25")
            .created("2017-11-10T12:56:36.310Z")
            .build();
}
