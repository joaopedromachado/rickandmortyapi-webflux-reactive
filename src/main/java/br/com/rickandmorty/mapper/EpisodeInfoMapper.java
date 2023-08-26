package br.com.rickandmorty.mapper;

import br.com.rickandmorty.client.model.episode.EpisodeInfo;
import br.com.rickandmorty.dto.EpisodeInfoDto;

public class EpisodeInfoMapper {

    public static EpisodeInfo of(final EpisodeInfoDto episodeInfoDto) {
        return EpisodeInfo.builder()
                .id(episodeInfoDto.getId())
                .name(episodeInfoDto.getName())
                .episode(episodeInfoDto.getEpisode())
                .url(episodeInfoDto.getUrl())
                .characters(episodeInfoDto.getCharacters())
                .airDate(episodeInfoDto.getAirDate())
                .created(episodeInfoDto.getCreated())
                .build();
    }


    public static EpisodeInfoDto of(final EpisodeInfo episodeInfo) {
        return EpisodeInfoDto.builder()
                .id(episodeInfo.getId())
                .name(episodeInfo.getName())
                .episode(episodeInfo.getEpisode())
                .url(episodeInfo.getUrl())
                .characters(episodeInfo.getCharacters())
                .airDate(episodeInfo.getAirDate())
                .created(episodeInfo.getCreated())
                .build();
    }
}
