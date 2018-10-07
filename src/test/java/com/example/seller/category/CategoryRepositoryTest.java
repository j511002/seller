package com.example.seller.category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void findOneTest() {
        Integer id = 1;
        Category category = categoryRepository.findById(id).orElse(null);

        try {
            if (category == null) {
                throw new NullPointerException("数据库中没有数据");
            }
            System.out.println(category.toString());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void updateTest() {
        Integer id = 1;
        categoryRepository.findById(id).ifPresent(category -> {
            category.setName("火锅");
            System.out.println(category.toString());
            categoryRepository.save(category);
        });
    }

    @Test
    public void createTest() {
        Category category = new Category();
        category.setName("川菜");
        category.setParentId(0);
        categoryRepository.save(category);
    }
}