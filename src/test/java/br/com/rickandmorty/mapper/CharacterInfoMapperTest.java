package br.com.rickandmorty.mapper;

import br.com.rickandmorty.stub.character.CharacterInfoStub;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static br.com.rickandmorty.stub.character.CharacterInfoStub.CHARACTER;
import static org.junit.jupiter.api.Assertions.*;

class CharacterInfoMapperTest {

    @Test
    void of() {
        Assertions.assertThat(CHARACTER)
                .hasFieldOrPropertyWithValue("id", 2)
                .hasFieldOrPropertyWithValue("name", "Morty Smith")
                .hasFieldOrPropertyWithValue("status", "Alive")
                .hasFieldOrPropertyWithValue("species", "Human")
                .hasFieldOrPropertyWithValue("gender", "Male")
                .hasFieldOrProperty("origin")
                .hasFieldOrProperty("location")
                .hasFieldOrPropertyWithValue("image", "https://rickandmortyapi.com/api/character/avatar/2.jpeg")
                .hasFieldOrPropertyWithValue("created", "2017-11-04T18:50:21.651Z");
    }

}