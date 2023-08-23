package br.com.rickandmorty.service;

import br.com.rickandmorty.client.RickAndMortyApiClient;
import br.com.rickandmorty.client.model.location.LocationInfo;
import br.com.rickandmorty.dto.CharacterInfoDto;
import br.com.rickandmorty.dto.EpisodeInfoDto;
import br.com.rickandmorty.dto.LocationInfoDto;
import br.com.rickandmorty.mapper.CharacterInfoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RickAndMortyApiService {

    private final RickAndMortyApiClient rickAndMortyApiClient;
    private final ObjectMapper objectMapper;

    public Mono<CharacterInfoDto> getCharacterById(final int id) {
        return this.rickAndMortyApiClient.getCharacterById(id)
                .doOnNext(characterInfo -> log.info("Processando dados do personagem {}", characterInfo.getName()))
                .map(CharacterInfoMapper::of)
                .doOnSuccess(characterInfoDto -> log.info("[ID - {}]", characterInfoDto.getId()));
    }

    public Flux<CharacterInfoDto> getMultipleCharactersById(final List<Integer> ids) {
        return this.rickAndMortyApiClient.getMultipleCharactersById(ids)
                .map(characterInfo -> this.objectMapper.convertValue(characterInfo, CharacterInfoDto.class));
    }

    public Mono<LocationInfoDto> getLocationById(final int id) {
        return this.rickAndMortyApiClient.getLocationById(id)
                .map(locationInfo -> this.objectMapper.convertValue(locationInfo, LocationInfoDto.class));
    }

    public Mono<EpisodeInfoDto> getEpisodeById(final int id) {
        return this.rickAndMortyApiClient.getEpisodeById(id)
                .map(episodeInfo -> this.objectMapper.convertValue(episodeInfo, EpisodeInfoDto.class));
    }
}
