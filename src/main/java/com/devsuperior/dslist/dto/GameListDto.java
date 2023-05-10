package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.GameList;
import lombok.Getter;

@Getter
public class GameListDto {
    private Long id;
    private String name;

    public GameListDto() {
    }

    public GameListDto(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
