package org.merlin.controller;

import org.merlin.model.Board;
import org.merlin.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BoardController {

    private BoardService boardService;

    @Autowired
    public  BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/allBoards")
    public List<Board> getAllBoard(){
        return boardService.getAllBoard();
    }

    @GetMapping("/boardById")
    public Board getBoardById(@RequestParam String id){
        Optional<Board> board = boardService.getBoardByID(id);
        if (board.isPresent())
            return (Board) board.get();
        return null;
    }

    @PostMapping("/addBoard")
    public void addBoard(@RequestBody Map<String, Object> board){
        String name = (String) board.get("name");

        Map<String, Object> data = new HashMap<>(board);
        data.remove("name");

        boardService.addBoard(name, data);
    }

//    @PutMapping("/updateBoard")
//    public void updateBoard(@RequestBody Board board, String id){
//        boardService.updateBoard(board, id);
//    }

    @DeleteMapping("/delBoard")
    public void delBoard(@RequestParam String id){
        boardService.delBoardById(id);
    }

}
