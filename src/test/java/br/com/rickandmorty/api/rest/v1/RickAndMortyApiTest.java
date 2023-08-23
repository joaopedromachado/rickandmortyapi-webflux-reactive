package br.com.rickandmorty.api.rest.v1;

import br.com.rickandmorty.dto.EpisodeInfoDto;
import br.com.rickandmorty.dto.LocationInfoDto;
import br.com.rickandmorty.service.RickAndMortyApiService;
import br.com.rickandmorty.stub.episode.EpisodeInfoStub;
import br.com.rickandmorty.stub.location.LocationStub;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static br.com.rickandmorty.stub.character.CharacterInfoStub.*;
import static br.com.rickandmorty.stub.episode.EpisodeInfoStub.EPISODE_INFO_DTO;
import static br.com.rickandmorty.stub.location.LocationStub.LOCATION_INFO_DTO;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeastOnce;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebFluxTest(controllers = RickAndMortyApi.class)
class RickAndMortyApiTest {

    private static final String BASE_URL = "/v1/rickandmorty";

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private RickAndMortyApiService service;

    @Test
    void getCharacterById() {
        when(service.getCharacterById(anyInt()))
                        .thenReturn(Mono.just(CHARACTER_DTO));

        webTestClient
                .get()
                .uri(BASE_URL.concat("/personagem/2"))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").isEqualTo(2)
                .jsonPath("$.name").isEqualTo("Morty Smith")
                .jsonPath("$.status").isEqualTo("Alive")
                .jsonPath("$.species").isEqualTo("Human")
                .jsonPath("$.gender").isEqualTo("Male")
                .jsonPath("$.origin.name").isEqualTo("teste")
                .jsonPath("$.origin.url").isEqualTo("teste")
                .jsonPath("$.location.name").isEqualTo("Citadel of Ricks")
                .jsonPath("$.location.url").isEqualTo("https://rickandmortyapi.com/api/location/3")
                .jsonPath("$.image").isEqualTo("https://rickandmortyapi.com/api/character/avatar/2.jpeg")
                .jsonPath("$.episode").isArray()
                .jsonPath("$.episode[0]").isEqualTo("123")
                .jsonPath("$.episode[1]").isEqualTo("321")
                .jsonPath("$.url").isEqualTo("https://rickandmortyapi.com/api/character/2")
                .jsonPath("$.created").isEqualTo("2017-11-04T18:50:21.651Z");

        verify(service, atLeastOnce()).getCharacterById(2);
        verifyNoMoreInteractions(service);
    }

    @Test
    void getMultipleCharactersById() {
        Mockito.when(service.getMultipleCharactersById(anyList()))
                .thenReturn(Flux.just(CHARACTER_DTO));

        this.webTestClient.get()
                .uri(BASE_URL.concat("/personagens?ids=1,22,333"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class);

        verify(service, times(1))
                .getMultipleCharactersById(List.of(1,22,333));
    }

    @Test
    void getLocationById() {
        Mockito.when(service.getLocationById(anyInt()))
                .thenReturn(Mono.just(LOCATION_INFO_DTO));

        this.webTestClient
                .get()
                .uri(BASE_URL.concat("/localizacao/100"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(LocationInfoDto.class);

        Mockito.verify(service, times(1))
                .getLocationById(100);
        verifyNoMoreInteractions(service);
    }

    @Test
    void getEpisodeById() {
        Mockito.when(service.getEpisodeById(anyInt()))
                .thenReturn(Mono.just(EPISODE_INFO_DTO));

        this.webTestClient
                .get()
                .uri(BASE_URL.concat("/episodio/25"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(EpisodeInfoDto.class);

        Mockito.verify(service, times(1))
                .getEpisodeById(25);
        verifyNoMoreInteractions(service);
    }
}