package org.merlin.service;

import org.merlin.model.Board;
import org.merlin.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public void addBoard(Board board){
        boardRepository.save(board);
    }

    public Optional<Board> getBoardByID(String id) {
        Optional<Board> oBoard = boardRepository.findById(id);
        if (oBoard.isPresent())
            return boardRepository.findById(id);
        return Optional.empty();
    }

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }
}
