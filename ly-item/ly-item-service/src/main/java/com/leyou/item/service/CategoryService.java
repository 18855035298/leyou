package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryByParent(Long pid) {
        Category category = new Category();
        category.setParentId(pid);
        List<Category> lists = categoryMapper.select(category);
        if (lists != null) {
            return lists;
        }
        return null;
    }
    public Boolean addCategory(Category category) {
        int insert = 0;
        insert = categoryMapper.insert(category);
        if (insert != 0) {
            return true;
        }
        return false;
    }
}
