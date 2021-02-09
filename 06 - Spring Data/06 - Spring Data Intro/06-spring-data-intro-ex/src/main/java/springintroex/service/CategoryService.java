package springintroex.service;

import springintroex.entity.Category;

import java.io.IOException;

public interface CategoryService {
    void seedCategories() throws IOException;
    Category getCategoryById(long id);
}
