package com.example.AlkemyChallenge.service.impl;

import com.example.AlkemyChallenge.entity.Character;
import com.example.AlkemyChallenge.exception.ResourceNotFoundException;
import com.example.AlkemyChallenge.repository.CharacterRepository;
import com.example.AlkemyChallenge.repository.projection.ProjectNameAndImage;
import com.example.AlkemyChallenge.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository characterRepository;
    @Override
    public Character saveCharacter(Character character){
        return characterRepository.save(character);
    }

    @Override
    public List<Character> saveCharacters(List<Character> characters) {
        return characterRepository.saveAll(characters);
    }

    @Override
    public List<ProjectNameAndImage> showCharacterNameAndImage() {
        return characterRepository.findAllProjectedBy();
    }


    @Override
    public Character getCharacterById(Long id) {
        return characterRepository.findById(id).get();
    }

    @Override
    public Optional<Character> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public Optional<Character> findByAge(Integer age) {
        return  characterRepository.findByAge(age);
    }

    //find by movies---

    ///---
    @Override
    public List<Character> getAllCharacters() {
        List<Character> characters = characterRepository.findAll();
        return characters;
    }

    @Override
    public Character updateCharacter(Character character, long id) {
        return characterRepository.save(character);
    }

    @Override
    public String deleteCharacter(Long id){
        if(characterRepository.findById(id).isPresent()){
            characterRepository.deleteById(id);
            return "Character with id: " + id + " has been successfully deleted";
        } else
            throw new ResourceNotFoundException("Character with id: " + id + " doesn't exist");

    }





}
