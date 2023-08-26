package br.com.rickandmorty.service;

import br.com.rickandmorty.client.RickAndMortyApiClient;
import br.com.rickandmorty.client.model.location.LocationInfo;
import br.com.rickandmorty.dto.CharacterInfoDto;
import br.com.rickandmorty.dto.EpisodeInfoDto;
import br.com.rickandmorty.dto.LocationInfoDto;
import br.com.rickandmorty.mapper.CharacterInfoMapper;
import br.com.rickandmorty.mapper.EpisodeInfoMapper;
import br.com.rickandmorty.mapper.LocationInfoMapper;
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

    public Mono<CharacterInfoDto> getCharacterById(final int id) {
        return this.rickAndMortyApiClient.getCharacterById(id)
                .doOnNext(characterInfo -> log.info("Processando dados do personagem {}", characterInfo.getName()))
                .map(CharacterInfoMapper::of)
                .doOnSuccess(characterInfoDto -> log.info("[ID - {}]", characterInfoDto.getId()))
                .doOnError(throwable -> log.error("Erro ao encontrar personagem {}", throwable.getMessage()));
    }

    public Flux<CharacterInfoDto> getMultipleCharactersById(final List<Integer> ids) {
        return this.rickAndMortyApiClient.getMultipleCharactersById(ids)
                .map(CharacterInfoMapper::of);
    }

    public Mono<LocationInfoDto> getLocationById(final int id) {
        return this.rickAndMortyApiClient.getLocationById(id)
                .map(LocationInfoMapper::of);
    }

    public Mono<EpisodeInfoDto> getEpisodeById(final int id) {
        return this.rickAndMortyApiClient.getEpisodeById(id)
                .map(EpisodeInfoMapper::of);
    }
}
