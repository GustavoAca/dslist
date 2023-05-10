package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.exception.NaoEncontradoException;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    private final GameListRepository gameRepository;

    @Autowired
    public GameListService(GameListRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return gameRepository.findAll().stream().map(GameListDto::new).toList();
    }

    @Transactional(readOnly = true)
    public GameListDto findById(Long id) {
        return gameRepository.findById(id).stream().map(GameListDto::new).findFirst().orElseThrow(() -> new NaoEncontradoException("Id não encontrado"));
    }

}
