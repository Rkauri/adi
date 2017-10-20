package com.model;


public class Show {  
int id;	
String showName;
long duration;
long min_audio;
long min_video;
long min_adds;
long min_voice;
int type;
int no_of_times_played;
String genre;

public Show() {
	super();
}

public Show(int id,String showName, long duration, long min_audio, long min_video, long min_adds, long min_voice, int type,
		int no_of_times_played, String genre) {
	super();
	this.id=id;
	this.showName = showName;
	this.duration = duration;
	this.min_audio = min_audio;
	this.min_video = min_video;
	this.min_adds = min_adds;
	this.min_voice = min_voice;
	this.type = type;
	this.no_of_times_played = no_of_times_played;
	this.genre = genre;
}

public String getShowName() {
	return showName;
}
public void setShowName(String showName) {
	this.showName = showName;
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public long getDuration() {
	return duration;
}
public void setDuration(long duration) {
	this.duration = duration;
}
public long getMin_audio() {
	return min_audio;
}
public void setMin_audio(long min_audio) {
	this.min_audio = min_audio;
}
public long getMin_video() {
	return min_video;
}
public void setMin_video(long min_video) {
	this.min_video = min_video;
}
public long getMin_adds() {
	return min_adds;
}
public void setMin_adds(long min_adds) {
	this.min_adds = min_adds;
}
public long getMin_voice() {
	return min_voice;
}
public void setMin_voice(long min_voice) {
	this.min_voice = min_voice;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getNo_of_times_played() {
	return no_of_times_played;
}
public void setNo_of_times_played(int no_of_times_played) {
	this.no_of_times_played = no_of_times_played;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}

}

