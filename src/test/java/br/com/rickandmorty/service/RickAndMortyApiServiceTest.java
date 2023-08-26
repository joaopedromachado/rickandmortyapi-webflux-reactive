package br.com.rickandmorty.service;

import br.com.rickandmorty.client.RickAndMortyApiClient;
import br.com.rickandmorty.client.model.character.CharacterInfo;
import br.com.rickandmorty.client.model.episode.EpisodeInfo;
import br.com.rickandmorty.config.ObjectMapperConfig;
import br.com.rickandmorty.dto.CharacterInfoDto;
import br.com.rickandmorty.mapper.CharacterInfoMapper;
import br.com.rickandmorty.stub.character.CharacterInfoStub;
import br.com.rickandmorty.stub.episode.EpisodeInfoStub;
import br.com.rickandmorty.stub.location.LocationStub;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static br.com.rickandmorty.stub.character.CharacterInfoStub.CHARACTER;
import static br.com.rickandmorty.stub.episode.EpisodeInfoStub.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RickAndMortyApiServiceTest {

    @InjectMocks
    private RickAndMortyApiService service;

    @Mock
    private RickAndMortyApiClient client;


    @Test
    @DisplayName("Quando buscar personagem ID deverá retornar os dados do personagem")
    void getCharacterById() {
        when(client.getCharacterById(anyInt()))
                .thenReturn(Mono.just(CHARACTER));


        StepVerifier
                .create(service.getCharacterById(2))
                .as("Então deve ser retornado o personagem esperado")
                .consumeNextWith(response ->
                        assertThat(2)
                                .isEqualTo(response.getId())
                )
                .verifyComplete();
    }

    @Test
    @DisplayName("Quando buscar uma lista de personagens por ID deverá retornar os dados do personagem")
    void getMultipleCharactersById() {
        when(client.getMultipleCharactersById(anyList()))
                .thenReturn(Flux.just(CHARACTER));

        StepVerifier
                .create(service.getMultipleCharactersById(List.of(1, 22, 333)))
                .as("Então deve ser retornado uma lista de personagens")
                .consumeNextWith(characterInfoDto ->
                        assertThat(characterInfoDto)
                                .isInstanceOf(CharacterInfoDto.class)
                                .isNotNull()
                )
                .verifyComplete();
    }

    @Test
    @DisplayName("Quando buscar localização por ID deverá retornar os dados da localização")
    void getLocationById() {
        when(client.getLocationById(anyInt()))
                .thenReturn(Mono.just(LocationStub.LOCATION));

        StepVerifier
                .create(service.getLocationById(100))
                .as("Então deve ser retornado a localização esperada")
                .consumeNextWith(locationInfoDto ->
                        assertThat(100)
                                .isEqualTo(locationInfoDto.getId())
                )
                .verifyComplete();
    }

    @Test
    @DisplayName("Quando buscar episódio por ID deverá retornar os dados do episódio")
    void getEpisodeById() {
        when(client.getEpisodeById(anyInt()))
                .thenReturn(Mono.just(EPISODE));


        StepVerifier
                .create(service.getEpisodeById(25))
                .as("Então deve ser retornado o episódio esperado")
                .consumeNextWith(episodeInfoDto ->
                        assertThat(25)
                                .isEqualTo(episodeInfoDto.getId())
                )
                .verifyComplete();
    }
}