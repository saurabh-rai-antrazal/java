package day24.nestedClass.Exercise45;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    // write code here
    
    private String name;
    private String artist;
    private ArrayList<Song> songs;
    
    public Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }
    
    public boolean addSong(String title, double duration){

        Song song = this.findSong(title);
        if(song != null){
            return false;
        }

        return songs.add(new Song(title, duration));
    }
    
    
    public Song findSong(String title){
        for(Song it: songs){
            if(it.getTitle() == title){
                return it;
            }
        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){

        if(songs.size() > trackNumber){
            String song = songs.get(trackNumber).getTitle();
            for(Song it: playList){
                if(it.getTitle() == song){
                    return true;
                }
            }

            playList.add(songs.get(trackNumber));
            return true;
        }
        return false; 
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList){
        Song s = findSong(title);

        for(Song it: playList){
            if(it.getTitle() == s.getTitle()){
                return true;
            }
        }

        if(s == null){
            return false;
        }
        playList.add(s);
        return true;
    }
}
