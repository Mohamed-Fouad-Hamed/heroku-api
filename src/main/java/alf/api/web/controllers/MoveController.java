package alf.api.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import alf.api.web.modelRequest.ItemMoveRequest;
import alf.api.web.models.ItemMove;
import alf.api.web.services.ItemMoveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/move")
public class MoveController {

  @Autowired
  ItemMoveService service;

  @GetMapping("/findById/{id}")
  public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
    ItemMove itemMove = service.findById(id);
    if (itemMove == null) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
    }
    Map<String, Object> response = new HashMap<>();
    response.put("status", 0);
    response.put("data", itemMove);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/findAll")
  public ResponseEntity<Map<String, Object>> findAll() {
    List<ItemMove> itemMoveList = service.findAll();
    if (itemMoveList == null) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
    }
    Map<String, Object> response = new HashMap<>();
    response.put("status", 0);
    response.put("data", itemMoveList);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/createmove")
  public ResponseEntity<Map<String, Object>> createMove(@RequestBody ItemMove itemMove) {
    ItemMove itemMoveUpdated = service.save(itemMove);

    Map<String, Object> response = new HashMap<>();
    response.put("status", 0);
    response.put("data", itemMoveUpdated);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/updatemove")
  public ResponseEntity<Map<String, Object>> updateMove(@RequestBody ItemMove itemMove) {
    ItemMove itemMoveUpdated = service.update(itemMove);
    Map<String, Object> response = new HashMap<>();
    response.put("status", 0);
    response.put("data", itemMoveUpdated);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/deletemove/{id}")
  public ResponseEntity<Map<String, Object>> deleteMove(@PathVariable("id") Long id) {
    ItemMove itemMove = service.findById(id);
    if (itemMove == null) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.NOT_FOUND);
    }
    service.delete(id);
    Map<String, Object> response = new HashMap<>();
    response.put("status", 0);
    response.put("data", null);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PostMapping("/findAllPaging")
  public ResponseEntity<Map<String, Object>> findAllPaging(@RequestBody ItemMoveRequest itemMoveRequest) {
	  Direction dir = Direction.fromString(itemMoveRequest.getPageInfo().getDirection());
	  String sortString =  itemMoveRequest.getPageInfo().getSortBy();
	  Sort sort = Sort.by(dir, sortString);
      Pageable pageable =  PageRequest.of(itemMoveRequest.getPageInfo().getPage(), itemMoveRequest.getPageInfo().getSize(), sort);
      Page<ItemMove> page = service.findAll(itemMoveRequest.getItemMoveSearcher() , pageable);
      Map<String, Object> response = new HashMap<>();
      response.put("status", 0);
      response.put("data", page.getContent());
      response.put("totalRows", page.getTotalElements());
      return new ResponseEntity<>(response, HttpStatus.OK);
  }

}
