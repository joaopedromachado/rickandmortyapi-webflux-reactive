package br.com.rickandmorty.client.model.location;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class LocationInfo {

    private int id;
    private String name;
    private String type;
    private String Dimension;
    private List<String> residents;
    private String url;
    private String created;

}
