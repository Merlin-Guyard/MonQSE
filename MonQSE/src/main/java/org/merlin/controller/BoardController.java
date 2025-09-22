package org.merlin.controller;

import org.merlin.model.Board;
import org.merlin.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    public  BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public Board getBoard(@RequestParam String id){
        Optional<Board> board = boardService.getBoardByID(id);
        if (board.isPresent())
            return (Board) board.get();
        return null;
    }

    @PostMapping("/addBoard")
    public void addBoard(@RequestBody Board board){
        boardService.addBoard(board);
    }

    @GetMapping("/allBoards")
    public List<Board> getBoard(){
        return boardService.getAllBoard();
    }
}
