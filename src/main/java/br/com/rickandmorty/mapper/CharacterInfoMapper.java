package br.com.rickandmorty.mapper;

import br.com.rickandmorty.client.model.character.CharacterInfo;
import br.com.rickandmorty.dto.CharacterInfoDto;
import org.springframework.stereotype.Component;

public class CharacterInfoMapper {

    public static CharacterInfo of(final CharacterInfoDto characterInfoDto) {
        return CharacterInfo.builder()
                .id(characterInfoDto.getId())
                .name(characterInfoDto.getName())
                .status(characterInfoDto.getStatus())
                .episode(characterInfoDto.getEpisode())
                .url(characterInfoDto.getUrl())
                .gender(characterInfoDto.getGender())
                .image(characterInfoDto.getImage())
                .created(characterInfoDto.getCreated())
                .type(characterInfoDto.getType())
                .origin(characterInfoDto.getOrigin())
                .species(characterInfoDto.getSpecies())
                .location(characterInfoDto.getLocation())
                .build();
    }

    public static CharacterInfoDto of(final CharacterInfo characterInfo) {
        return CharacterInfoDto.builder()
                .id(characterInfo.getId())
                .name(characterInfo.getName())
                .status(characterInfo.getStatus())
                .episode(characterInfo.getEpisode())
                .url(characterInfo.getUrl())
                .gender(characterInfo.getGender())
                .image(characterInfo.getImage())
                .created(characterInfo.getCreated())
                .type(characterInfo.getType())
                .origin(characterInfo.getOrigin())
                .species(characterInfo.getSpecies())
                .location(characterInfo.getLocation())
                .build();
    }
}
