package com.dev.MusicPlayer;

public class Song {

	private int Song_Id;
	private String name;
	private String title;
	private String artist_name;
	private String location;
	private String desc;
	
	
	public int getSong_Id() {
		return Song_Id;
	}
	public void setSong_Id(int song_Id) {
		Song_Id = song_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
