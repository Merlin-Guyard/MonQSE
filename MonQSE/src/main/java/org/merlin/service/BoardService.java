package org.merlin.service;

import org.merlin.model.Board;
import org.merlin.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<Board> getAllBoard() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoardByID(String id) {
        Optional<Board> oBoard = boardRepository.findById(id);
        if (oBoard.isPresent())
            return boardRepository.findById(id);
        return Optional.empty();
    }

    public void addBoard(String name, Map<String, Object> data){
        Board board = new Board(name, data);
        boardRepository.save(board);
    }

//    public void updateBoard(Board board, String id) {
//        Optional<Board> oBoard = boardRepository.findById(id);
//        if (oBoard.isPresent())
//            boardRepository.findById(id).map(existingBoard -> {
//                existingBoard.setName(board.getName());
//                existingBoard.setDatastring(board.getDatastring());
//                existingBoard.setDataint(board.getDataint());
//                return boardRepository.save(existingBoard);
//            });
//    }

    public void delBoardById(String id) {
        boardRepository.deleteById(id);
    }
}
