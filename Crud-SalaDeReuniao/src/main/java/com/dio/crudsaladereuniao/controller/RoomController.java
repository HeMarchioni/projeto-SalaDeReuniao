package com.dio.crudsaladereuniao.controller;


import com.dio.crudsaladereuniao.exception.ResourceNotFoundException;
import com.dio.crudsaladereuniao.model.Room;
import com.dio.crudsaladereuniao.repository.RoomRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable("id") Long roomId  ) throws ResourceNotFoundException {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(()->new ResourceNotFoundException("Room not found:: " + roomId));
        return ResponseEntity.ok().body(room);
    }


    @PostMapping("/rooms")
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }


    @PutMapping("rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") Long roomId, @Valid @RequestBody Room room) throws ResourceNotFoundException {

        roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room not found for this id:: " + roomId));
        room.setId(roomId);
        final Room uptdateRoom = roomRepository.save(room);
        return ResponseEntity.ok(uptdateRoom);
    }

    @DeleteMapping("rooms/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") Long roomId) throws ResourceNotFoundException {
        roomRepository.findById(roomId).orElseThrow(()->new ResourceNotFoundException("Room not found for this id: " + roomId));

        roomRepository.deleteById(roomId);
        return ResponseEntity.ok("{ " +
                "\"Deleted\":true" +
                " }");
    }






}
