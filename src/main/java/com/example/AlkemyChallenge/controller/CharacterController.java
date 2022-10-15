package com.example.AlkemyChallenge.controller;

import com.example.AlkemyChallenge.entity.Character;
import com.example.AlkemyChallenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @PostMapping
    private ResponseEntity addCharacter(@RequestBody Character character){
        return new ResponseEntity<>(characterService.saveCharacter(character), HttpStatus.CREATED);
    }

    @PostMapping("/addMany")
    public ResponseEntity<?> addCharacters(@RequestBody List<Character> characters) {
        return new ResponseEntity<>(characterService.saveCharacters(characters), HttpStatus.CREATED);
    }

    @GetMapping
    private  ResponseEntity<?> showCharacterNameAndImage() {
        return new ResponseEntity<>(characterService.showCharacterNameAndImage(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        return new ResponseEntity<>(characterService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/{age}")
    public ResponseEntity<?> findByAge(@PathVariable Integer age) {
        return new ResponseEntity<>(characterService.findByAge(age), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCharacters() {
        return new ResponseEntity<>(characterService.getAllCharacters(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCharacterById(@PathVariable Long id) {
        return new ResponseEntity<>(characterService.getCharacterById(id), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity updateCharacter(@RequestBody Character character){
        return new ResponseEntity<>(characterService.saveCharacter(character), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id){

        return characterService.deleteCharacter(id);
    }


}
