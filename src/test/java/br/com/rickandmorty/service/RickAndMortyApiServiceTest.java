package br.com.rickandmorty.service;

import br.com.rickandmorty.client.RickAndMortyApiClient;
import br.com.rickandmorty.client.model.character.CharacterInfo;
import br.com.rickandmorty.config.ObjectMapperConfig;
import br.com.rickandmorty.dto.CharacterInfoDto;
import br.com.rickandmorty.mapper.CharacterInfoMapper;
import br.com.rickandmorty.stub.character.CharacterInfoStub;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static br.com.rickandmorty.stub.character.CharacterInfoStub.CHARACTER;
import static br.com.rickandmorty.stub.character.CharacterInfoStub.CHARACTER_DTO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;
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
                        assertEquals(2, response.getId())
                )
                .verifyComplete();
    }

    @Test
    void getCharacterById_whenCharacterNotExists() {
    }

    @Test
    void getMultipleCharactersById() {
    }

    @Test
    void getLocationById() {
    }

    @Test
    void getEpisodeById() {
    }
}