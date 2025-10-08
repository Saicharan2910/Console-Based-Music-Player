package com;
import java.util.Scanner;

import com.model.Playlist;
import com.model.Song;
import com.service.MusicPlayer;

public class MenuDrivenApplication {

	public static void main(String[] args) {
		
	  Scanner sc = new Scanner(System.in);
	  MusicPlayer musicplayer = new MusicPlayer();
	  
	  while(true) {
			System.out.println("========= Music Player Menu ==========");
			System.out.println("1. Add New Song");
			System.out.println("2. Update Existing Song");
			System.out.println("3. Delete Song");
			System.out.println("4. Display All Songs");
			System.out.println("5. Create New Playlist");
			System.out.println("6. Add Song To Playlist");
			System.out.println("7. Display All Playlists");
			System.out.println("8. Display Songs In Playlist");
			System.out.println("9. Play Song In Playlist");
			System.out.println("10. Pause Song In Playlist");
			System.out.println("11. Stop Song In Playlist");
			System.out.println("12. Exit");
			System.out.println("13. Enter Your Choice: ");

			int choice = -1;
			try {
				choice = Integer.parseInt(sc.nextLine());
			}catch (NumberFormatException e) {
				System.out.println("Invalid input. Enter a Number.");
				continue;
			}

          switch (choice) {
          case 1: 
        	  System.out.println("Enter Song Id: ");
        	  String songId = sc.nextLine();
        	  System.out.println("Enter Title: ");
        	  String title = sc.nextLine();
        	  System.out.println("Enter Artist: ");
        	  String artist = sc.nextLine();
        	  System.out.println("Enter Duration: ");
        	  double duration = 0.0;
        	  
        	  try {
        		  duration = Double.parseDouble(sc.nextLine());
        	  }catch (NumberFormatException e) {
        		  System.out.println("Invalid Duration. ");
        		  break;
        	  }
        	 
        	  Song song = new Song(songId,title,artist,duration);
        	  musicplayer.addSong(song);
        	  break;
        	  
          case 2:
        	  System.out.println("Enter SongId To Update: ");
        	  String updateId = sc.nextLine();
        	  System.out.println("Enter New Title: ");
        	  String newTitle = sc.nextLine();
        	  System.out.println("Enter New Artist: ");
        	  String newArtist = sc.nextLine();
        	  System.out.println("Enter New Duration: ");
        	  double newDuration = 0.0;
        	  
        	  try {
        		  newDuration = Double.parseDouble(sc.nextLine());
        	  }catch (NumberFormatException e) {
        		  System.out.println("Invalid Duration. ");
        		  break;
        	  }
        	  
        	  Song  updatedSong = new Song(updateId,newTitle,newArtist,newDuration);
        	  musicplayer.updateSong(updateId,updatedSong);	  
        	  break;
        	  
          case 3: 
        	  System.out.println("Enter SongId To Delete: ");
        	  String deletedId = sc.nextLine();
        	  musicplayer.deleteSong(deletedId);
        	  break;
        	  
          case 4:
        	  musicplayer.displayAllSongs();
        	  break;
        	  
          case 5:
        	  System.out.println("Enter Playlist Name: ");
        	  String playlistName = sc.nextLine();
        	  musicplayer.createPlaylist(playlistName);
        	  break;
        	  
          case 6:
        	  System.out.println("Enter Playlist Name: ");
        	  String playlistName1 = sc.nextLine();
        	  System.out.println("Enter Song Id To Add: ");
        	  String songIdToAdd = sc.nextLine();
        	  Song songToAdd = null;
        	  
        	  for(Song s : musicplayer.getAllSongs()) {
        		  if(s.getSongId().equalsIgnoreCase(songIdToAdd)) {
        			  songToAdd = s;
        			  break;
        		  }
        	  } 
        	  if(songToAdd != null) {
        		  musicplayer.addSongToPlaylist(playlistName1, songToAdd);
        	  }
        	  else {
        		  System.out.println("Song Not Found. ");
        		  }
        	  break;
        	  
        	  
          case 7:
        	  musicplayer.displayAllPlaylists();
        	  break;
        	  
          case 8:
        	  System.out.println("Enter Playlist Name: ");
        	  Playlist p = musicplayer.getPlaylist(sc.nextLine());
        	  if(p != null) {
        		  p.displaySongs();
        		  continue;
        	  }
        	  else {
        		  System.out.println("Playlist Not Found: ");
        		  break;
        	  }
        	  
          case 9:
        	    System.out.print("Enter Playlist Name: ");
        	    String playlistNamePlay = sc.nextLine();
        	    Playlist playlistPlay = musicplayer
        	    		                  .getPlaylist(playlistNamePlay);
        	    if (playlistPlay != null) {
        	        System.out.print("Enter Song ID to play: ");
        	        songIdToAdd = sc.nextLine();
        	        playlistPlay.play(songIdToAdd);
        	    } else {
        	        System.out.println("Playlist not found.");
        	    }
        	    break;
        	    
          case 10:
        	    System.out.print("Enter Playlist Name: ");
        	    String playlistNamePause = sc.nextLine();
        	    Playlist playlistPause = musicplayer 
        	    		                 .getPlaylist(playlistNamePause);
        	    if (playlistPause != null) {
        	        System.out.print("Enter Song ID to pause: ");
        	        songIdToAdd = sc.nextLine(); 
        	        playlistPause.pause(songIdToAdd);
        	    } else {
        	        System.out.println("Playlist not found.");
        	    }
        	    break;
        	    
          case 11:
        	    System.out.print("Enter Playlist Name: ");
        	    String playlistNameStop = sc.nextLine();
        	    Playlist playlistStop = musicplayer 
        	    		                .getPlaylist(playlistNameStop);
        	    if (playlistStop != null) {
        	        System.out.print("Enter Song ID to stop: ");
        	        songIdToAdd = sc.nextLine(); 
        	        playlistStop.stop(songIdToAdd);
        	    } else {
        	        System.out.println("Playlist not found.");
        	    }
        	    break;
        	    
          case 12:
        	  System.out.println("Exiting ......");
        	  sc.close();
        	  return;
        	  
        default:System.out.println("Invalid Choice.Please Enter Between 1-12. ");
        
        }
          
	  }
	  
	}
	
}
        	  
        	  
        	  
        	  
        	

