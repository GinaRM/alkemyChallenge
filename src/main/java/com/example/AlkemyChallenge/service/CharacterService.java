package com.example.AlkemyChallenge.service;

import com.example.AlkemyChallenge.entity.Character;
import com.example.AlkemyChallenge.repository.projection.ProjectNameAndImage;

import java.util.List;
import java.util.Optional;

public interface CharacterService {

    List<ProjectNameAndImage> showCharacterNameAndImage();

    Character getCharacterById(Long id);

    Optional<Character> findByName(String name);

    Optional<Character> findByAge(Integer age);

    List<Character> getAllCharacters();

    Character saveCharacter(Character character);

    List<Character> saveCharacters(List<Character> characters);



    Character updateCharacter(Character character, long id);

    String deleteCharacter(Long id);
}
