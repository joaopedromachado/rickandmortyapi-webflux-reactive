package br.com.rickandmorty.api.rest.v1;

import br.com.rickandmorty.dto.CharacterInfoDto;
import br.com.rickandmorty.dto.EpisodeInfoDto;
import br.com.rickandmorty.dto.LocationInfoDto;
import br.com.rickandmorty.service.RickAndMortyApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/v1/rickandmorty")
@RequiredArgsConstructor
@Tag(name = "Rick And Morty API")
public class RickAndMortyApi {

    private final RickAndMortyApiService rickAndMortyApiService;

    @GetMapping("/personagem/{id}")
    @Operation(summary = "Obter informações de um personagem por ID")
    @ApiResponse(responseCode = "200", description = "Personagem encontrado", content = @Content(schema = @Schema(implementation = CharacterInfoDto.class)))
    @ApiResponse(responseCode = "404", description = "Personagem não encontrado")
    public Mono<CharacterInfoDto> getCharacterById(
            @PathVariable @Parameter(description = "ID do personagem a ser buscado") final int id) {
        return rickAndMortyApiService.getCharacterById(id);
    }

    @GetMapping("/personagens")
    @Operation(summary = "Obter informações de vários personagens por IDs")
    @ApiResponse(responseCode = "200", description = "Personagens encontrados", content = @Content(schema = @Schema(implementation = CharacterInfoDto.class)))
    public Flux<CharacterInfoDto> getMultipleCharactersById(
            @RequestParam @Parameter(description = "Lista de IDs dos personagens a serem buscados") final List<Integer> ids) {
        return rickAndMortyApiService.getMultipleCharactersById(ids);
    }

    @GetMapping("/localizacao/{id}")
    @Operation(summary = "Obter informações de uma localização por ID")
    @ApiResponse(responseCode = "200", description = "Localização encontrada", content = @Content(schema = @Schema(implementation = LocationInfoDto.class)))
    @ApiResponse(responseCode = "404", description = "Localização não encontrada")
    public Mono<LocationInfoDto> getLocationById(
            @PathVariable @Parameter(description = "ID da localização a ser buscada") final int id) {
        return rickAndMortyApiService.getLocationById(id);
    }

    @GetMapping("/episodio/{id}")
    @Operation(summary = "Obter informações de um episódio por ID")
    @ApiResponse(responseCode = "200", description = "Episódio encontrado", content = @Content(schema = @Schema(implementation = EpisodeInfoDto.class)))
    @ApiResponse(responseCode = "404", description = "Episódio não encontrado")
    public Mono<EpisodeInfoDto> getEpisodeById(
            @PathVariable @Parameter(description = "ID do episódio a ser buscado") final int id) {
        return rickAndMortyApiService.getEpisodeById(id);
    }

}
