package com.example.Shoes.DB;

import com.example.Shoes.DB.dto.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoeRepository extends JpaRepository<Shoe,Integer> {

    @Modifying
    @Query(value = "DELETE FROM shoe WHERE manufacturer IS NULL OR size IS NULL;",nativeQuery = true)
    void clear();

    @Query(value = "SELECT * FROM shoe",nativeQuery = true)
    List<Shoe> getAll();

    Shoe getShoeById(Integer id);
}
