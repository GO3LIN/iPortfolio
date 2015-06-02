package com.iporfilio.beans;

import java.util.List;


import com.iportfolio.categories.*;;


public class CategoriesPL {
	private CategoriesDAO categoriesDAO; 

    public CategoriesDAO getCategoriesDAO() { 
        return categoriesDAO; 
    } 

    public void setCategoriesDAO(CategoriesDAO CatDAO) { 
        this.categoriesDAO = CatDAO; 
    } 
    
    public void addCategories(Categories cat) { 
    	categoriesDAO.save(cat); 
    } 
    
    public Categories findCategoriesById(Integer id) { 
        return categoriesDAO.findById(id); 
    } 
    
    
    public void updateCategories(Categories cat) { 
    	categoriesDAO.merge(cat); 
    } 
    
    public void deleteCategories(Categories cat) { 
    	categoriesDAO.delete(cat); 
    } 
    public List findAll()
    { return categoriesDAO.findAll();}

}
