package com.dao;

import java.util.List;

import com.model.Clip;

public interface ClipDao {
public boolean addClip(Clip clipObj);
public boolean editClip(Clip clipObj);
public boolean deleteClip(int clipid);
public List<Clip> getClipByLength(Long duration,int type, String genre);
}
