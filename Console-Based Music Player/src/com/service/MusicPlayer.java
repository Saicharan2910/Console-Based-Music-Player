package com.service;

import java.util.ArrayList;
import java.util.List;
import com.model.Playlist;
import com.model.Song;

public class MusicPlayer implements Playable {

	private List<Song> allSongs;
	private List<Playlist> playlists;

	public MusicPlayer() {
		allSongs = new ArrayList<>();
		playlists = new ArrayList<>();
	}
	
	// Find Song By Id
	public Song findSongById(String songId) {
		for (Song song : allSongs) {
			if (song.getSongId().equalsIgnoreCase(songId)) {
				return song;
			}
		}
		return null;
	}
    
	// 1. Add New Song
	public void addSong(Song song) {
		for(Song s :allSongs) {
		if (s.getSongId().equalsIgnoreCase(song.getSongId())) {
			System.out.println("Song With Id Already Exists. ");
			return;
		  }
		} 
		allSongs.add(song);
		System.out.println("Song Added Successfully: " 
                    + song.getSongId());
		System.out.println("Current Songs: "+allSongs.size());
	}
	

	// 2. Update Song By Id
	public void updateSong(String songId, Song updatedSong) {
		Song existingSong = findSongById(songId);
		if(existingSong != null) {
			existingSong.setTitle(updatedSong.getTitle());
			existingSong.setArtist(updatedSong.getArtist());
			existingSong.setDuration(updatedSong.getDuration());
			System.out.println("Song Updated Successfully... ");
			}else {
		System.out.println("Song Not Found! ");
			}
	}
	
	// 3. Delete Song By Id
	public void deleteSong(String songId) {
		boolean removed = allSongs.removeIf(song -> song.getSongId()
				                                .equalsIgnoreCase(songId));
		if (removed) {
			System.out.println("Deleted Song With Id: " + songId);
		} else {
			System.out.println("Song Not Found With Id: " + songId);
		}
	}
	
	// 4. Display All Songs
	public void displayAllSongs() {
		System.out.println("All Songs:");
		System.out.println("Songs List Size: "+getAllSongs().size());
		if(allSongs.isEmpty()) {
			System.out.println("No Songs Available. ");
		}
		for (Song song : getAllSongs()) {
			System.out.println(song);
		}
	}
	
	// 5. Create New Playlist
	public void createPlaylist(String playlistName) {
		int id = playlists.size() + 1;
		Playlist playlist = new Playlist(id, playlistName);
		playlists.add(playlist);
		System.out.println("Playlist Created: " + playlistName);
	}
	
    // 6. Add Song To Playlist
	public void addSongToPlaylist(String playlistName, Song song) {
		Playlist playlist = getPlaylist(playlistName);
		if (playlist != null) {
			playlist.addSong(song);
			System.out.println("Song Added To Playlist: " + playlistName);
		} else {
			System.out.println("Playlist Not Found: " + playlistName);	
		}
	}
	
	// 7. Delete Playlist
	public void deletePlaylist(String playlistName) {
		boolean removed = playlists.removeIf(p -> p.getPlaylistName()
				                   .equalsIgnoreCase(playlistName));
		if (removed) {
			System.out.println("Deleted Playlist: " + playlistName);
		} else {
			System.out.println("Playlist Is Not Found: " + playlistName);
		}
	}

	// 8. Display All Playlists
	public void displayAllPlaylists() {
		if(playlists.isEmpty()) {
			System.out.println("No Playlists Found.");
			return;
		}
		
		System.out.println("All Playlists: ");
		for (Playlist playlist : playlists) {
			System.out.println("Playlist Name: " 
		                + playlist.getPlaylistName());
			
			List<Song> songs = playlist.getSongs();
			
			if(songs.isEmpty()) {
				System.out.println("No Songs In This Playlist.");
			}else {
				for(Song song : songs) {
					System.out.println(" - "+song);
				}
			}
		}
	}
	
	// 9. Play Song By Id
	@Override
	public void play(String songId) {
		Song songToPlay = findSongById(songId);
		if (songToPlay != null) {
			System.out.println("Now Playing: " + songToPlay.getTitle());
		} else {
			System.out.println("Song Not Found With Id: " + songId);
		}
	}
	
	// 10. Pause Song 
	@Override
	public void pause(String songId) {
		Song songToPause = findSongById(songId);
		if (songToPause != null) {
			System.out.println("Paused: " + songToPause.getTitle());
		} else {
			System.out.println("Song Not Found With Id: " + songId);
		}
	}
	
	// 11. Stop Song
	@Override
	public void stop(String songId) {
		Song songToStop = findSongById(songId);
		if (songToStop != null) {
			System.out.println("Stopped Playing: " + songToStop.getTitle());
		} else {
			System.out.println("Song Not Found With Id: " + songId);
		}
	}
	
	// 12. Play  Full Playlist
	public void playPlaylist(String playlistName) {
		Playlist playlist = getPlaylist(playlistName);
		if (playlist != null) {
			System.out.println("Playing Playlist: " + playlistName);
			playlist.displaySongs();
		} else {
			System.out.println("Playlist Not Found: " + playlistName);
		}
	}
	
	// Play All Songs From A Given Song
	public void playFromSong(String songId) {

		int startIndex = -1;
		for (int i = 0; i < allSongs.size(); i++) {
			Song song = allSongs.get(i);
			if (song.getSongId().equalsIgnoreCase(songId)) {
				startIndex = i;
				break;
			}
		}

		if (startIndex == -1) {
			System.out.println("Song With Id \"" + songId + "\"Not Found In Playlist");
			return;
		}

		System.out.println("Playing Playlist From Song Id: " + songId);
		for (int i = startIndex; i < allSongs.size(); i++) {
			Song song = allSongs.get(i);
			System.out.println("Now Playing \"" + song.getTitle() + "\" By " + song.getArtist());
		}
	}
	
	// Methods
	public Playlist getPlaylist(String playlistName) {
		for (Playlist p : playlists) {
			if (p.getPlaylistName().equalsIgnoreCase(playlistName)) {
				return p;
			}
		}
		return null;
	}
	
	public List<Song> getAllSongs() {
		return allSongs;
	}
	
	public void setAllSongs(List<Song> allSongs) {
		this.allSongs = allSongs;
	}

	public void addPlaylist(Playlist playlist) {
		playlists.add(playlist);
	}

}


