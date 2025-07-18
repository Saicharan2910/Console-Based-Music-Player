package com.model;

import java.util.ArrayList;
import java.util.List;
import com.service.Playable;

public  class Playlist implements Playable {
	  
    private int playlistId;
    private String playlistName;
    private List<Song> songs;

    public Playlist(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.songs = new ArrayList<>();
    }
    
    public int getPlayListId() {
    	return playlistId;
    }
    
    public String getPlaylistName() {
    	return playlistName;
    }
    
    public List<Song> getSongs() {
    	return songs;
    }
    
    public void addSong(Song song) {
    	songs.add(song);
    }
    
    public void displaySongs() {
    	if(songs.isEmpty()) {
    		System.out.println("Playlist Is Empty ");
    	}else {
    		for(Song song : songs) {
    			System.out.println(song);
    		}
    	}
    }
    
    public Song findSongById (String songId) { 
    	for(Song song : songs) {
    		if(song.getSongId().equalsIgnoreCase(songId)){
    			return song;
    		}
    	}
    	return null;	
    }
    
    public boolean removeSongById(String songId) {
    	Song song = getSongById(songId);
    	if (song != null) {
    		songs.remove(song);
    		System.out.println("Song Removed: "+songId);
    		return true;
    	}else {
    		System.out.println("Song Not Found With Id: "+songId);
    		return false;
    	}
    }
    
    public boolean updateSongById(String songId,String newTitle,
    		                String newArtist,double newDuration) {
    	Song song = findSongById(songId);
    	if(song != null) {
    		song.setTitle(newTitle);
    		song.setArtist(newArtist);
    		song.setDuration(newDuration);
    		System.out.println("Song Updated: "+songId);
    		return true;
    	}else {
    		System.out.println("Song Not Found With Id: "+songId);
    		return false;			
    	}
    }
    
    public Song getSongById(String songId) {
		for(Song song : songs) {
			if(song.getSongId().equalsIgnoreCase(songId)) {
				return song;
			}
		}
		return null;
	}

    public void play(String songId) {
    	Song song = findSongById(songId);
    	if (song != null) { 
    		System.out.println("Playing The Song: "+song);
    	}
    	else {
    		System.out.println("Song Not Found With Id: "+songId); 
    	}
    }
    
    public void play() {
    	System.out.println("Please Use Play(String songId)"
    			+ " To Play A Specific Song. ");
    }
    
    @Override
    public void pause(String songId) {
    	System.out.println("Paused Song With Id : "+songId);
    }
    
    @Override   
    public void stop(String songId) {
    	System.out.println("Stopped Song With Id: "+songId);
    }
      
}
    
    
    
    	
    
    

    
    