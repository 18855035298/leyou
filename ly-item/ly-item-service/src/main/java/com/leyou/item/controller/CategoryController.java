package com.leyou.item.controller;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/list")
    public ResponseEntity<List<Category>> queryCategoryByParent(@RequestParam("pid")Long pid) {
        List<Category> categories = categoryService.queryCategoryByParent(pid);
        if (categories != null) {
            return ResponseEntity.ok(categories);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);

    }
    @PostMapping
    public ResponseEntity<Boolean> addnode(Category Category) {
        Boolean flag = false;
        flag  = categoryService.addCategory(Category);
        if (flag ) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(false);

    }
}
