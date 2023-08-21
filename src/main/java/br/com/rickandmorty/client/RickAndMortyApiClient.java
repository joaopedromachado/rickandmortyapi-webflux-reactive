package br.com.rickandmorty.client;

import br.com.rickandmorty.client.model.character.CharacterInfo;
import br.com.rickandmorty.client.model.episode.EpisodeInfo;
import br.com.rickandmorty.client.model.location.LocationInfo;
import br.com.rickandmorty.dto.LocationInfoDto;
import io.netty.channel.epoll.EpollTcpInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.*;

@Component
public class RickAndMortyApiClient {

    private static final String BASE_URL = "https://rickandmortyapi.com/api";

    private final WebClient webClient;

    public RickAndMortyApiClient(WebClient.Builder builder) {
        HttpClient client = HttpClient.create().responseTimeout(Duration.ofSeconds(45));
        this.webClient = builder
                .clientConnector(new ReactorClientHttpConnector(client))
                .baseUrl(BASE_URL)
                .build();
    }

    public Mono<CharacterInfo> getCharacterById(final int id) {
        return this.webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        (error) -> Mono.error(RuntimeException::new))
                .bodyToMono(CharacterInfo.class);
    }

    public Flux<CharacterInfo> getMultipleCharactersById(final List<Integer> ids) {
        String concatenatedIds = ids.stream()
                .map(Object::toString)
                .collect(Collectors.joining(","));

        return this.webClient
                .get()
                .uri("/character/" + concatenatedIds)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        (error) -> Mono.error(RuntimeException::new))
                .bodyToFlux(CharacterInfo.class);
    }

    public Mono<LocationInfo> getLocationById(final int id) {
        return this.webClient
                .get()
                .uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        (error) -> Mono.error(RuntimeException::new))
                .bodyToMono(LocationInfo.class);
    }

    public Mono<EpisodeInfo> getEpisodeById(final int id) {
        return this.webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError,
                        (error) -> Mono.error(RuntimeException::new))
                .bodyToMono(EpisodeInfo.class);
    }
}
