package com.example.AlkemyChallenge.repository;

import com.example.AlkemyChallenge.entity.Character;
import com.example.AlkemyChallenge.repository.projection.ProjectNameAndImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    //select name, image from character
    List<ProjectNameAndImage> findAllProjectedBy();

    //find character by name
    Optional<Character> findByName(String name);

    //find by age
    Optional<Character> findByAge(Integer age);

    //find by movies
    //@Query(value = " SELECT product.*, city.id FROM product INNER JOIN city ON product.city_id = city.id WHERE city.id =(:id)", nativeQuery = true)
    //    List<Product> findByCityId(@Param("id") Long id);


}
