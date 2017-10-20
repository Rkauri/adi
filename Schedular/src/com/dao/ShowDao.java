package com.dao;

import java.util.List;

import com.model.Show;

public interface ShowDao {
public List<Show> getAllShow();	
public boolean addShow(Show showObj);
public boolean editShow(Show showObj);
public boolean deleteShow(int id);
public Show getShowById(int id);

}
