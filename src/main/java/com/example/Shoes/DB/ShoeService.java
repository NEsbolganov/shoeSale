package com.example.Shoes.DB;

import com.example.Shoes.DB.dto.Shoe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoeService {
    private final ShoeRepository shoeRepository;

    @Autowired
    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @Transactional
    public void save(Shoe shoe) {
        shoeRepository.save(shoe);
        shoeRepository.clear();
    }

    public List<Shoe> getAll() {
        return shoeRepository.getAll();
    }

    public Shoe get(Integer id) {
        return shoeRepository.getShoeById(id);
    }
}
