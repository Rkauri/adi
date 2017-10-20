
package com.model;

public class Clip {
int clip_id;	
String filename;
long file_duration;
int file_type;
boolean check_ads;
int no_of_times_played;
int max;
int min;
String Genre;

public Clip() {
	super();
}

public Clip(int clip_id,String filename, long file_duration, int file_type, boolean check_ads, int no_of_times_played, int max,
		int min, String genre) {
	super();
	this.clip_id=clip_id;
	this.filename = filename;
	this.file_duration = file_duration;
	this.file_type = file_type;
	this.check_ads = check_ads;
	this.no_of_times_played = no_of_times_played;
	this.max = max;
	this.min = min;
	Genre = genre;
}

public int getClip_id() {
	return clip_id;
}

public void setClip_id(int clip_id) {
	this.clip_id = clip_id;
}

public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public long getFile_duration() {
	return file_duration;
}
public void setFile_duration(long file_duration) {
	this.file_duration = file_duration;
}
public int getFile_type() {
	return file_type;
}
public void setFile_type(int file_type) {
	this.file_type = file_type;
}
public boolean isCheck_ads() {
	return check_ads;
}
public void setCheck_ads(boolean check_ads) {
	this.check_ads = check_ads;
}
public int getNo_of_times_played() {
	return no_of_times_played;
}
public void setNo_of_times_played(int no_of_times_played) {
	this.no_of_times_played = no_of_times_played;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public String getGenre() {
	return Genre;
}
public void setGenre(String genre) {
	Genre = genre;
}

}
