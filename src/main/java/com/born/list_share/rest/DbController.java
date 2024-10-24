package com.born.list_share.rest;


import com.born.list_share.persistence.DatabaseService;
import com.born.list_share.persistence.entity.ItemsToGetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/db")
@RequiredArgsConstructor
public class DbController {
    private final DatabaseService db;

    @GetMapping()
    public ResponseEntity<List<ItemsToGetEntity>> getTable() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(db.getItemsToGet());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity postItem(@RequestBody ItemsToGetEntity itemsToGetEntity) {
        try {
            db.postItemsToGet(itemsToGetEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity deleteItem(@PathVariable String itemId ) {
        try {
            Integer id = Integer.parseInt(itemId);
            db.removeItemsToGet(id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
