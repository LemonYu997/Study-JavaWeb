package travel.service;

import travel.domain.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有
     * */
    public List<Category> findAll();
}
