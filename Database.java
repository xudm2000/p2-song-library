// --== CS400 File Header Information ==--
// Name: Isaac Colbert
// Email: icolbert@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.NoSuchElementException;

/**
 * Class that represents the song database. This class usese a RedBlackTree to function as the 
 * database.
 * <p>
 * @author Isaac Colbert
 *
 */
public class Database {
  private RedBlackTree<Song> songLibrary;
  
  /**
   * Constructor for an instance of database.
   */
  public Database() {
    this.songLibrary = new RedBlackTree<Song>();
    this.importSongs();
  }
  
  /**
   * Returns the song with the provided title.
   * <p>
   * @param songTitle - the title of the song being searched for.
   * @return a reference to the song with the provided title.
   * @throws NoSuchElementException - if the song does not exist within the song database.
   */
  public Song getSong(String songTitle) throws NoSuchElementException {
    if (!this.containsSong(songTitle)) {
      throw new NoSuchElementException("The song with the title: " + songTitle + " does not exist "
          + "within the database.");
    }
    return songLibrary.get((node) -> { return node.data.getSongTitle().equals(songTitle); });
    /*
    Node<Song> currNode = songLibrary.root;
    while (currNode.data.compareTo(songTitle) != 0) {
      if (currNode.data.compareTo(songTitle) < 0) {
        currNode = currNode.leftChild;
      } else {
        currNode = currNode.rightChild;
      }
    }
    return currNode.data;*/
  }
  
  /**
   * Determines whether a song with the provided title exists within the database.
   * <p>
   * @param songTitle - the title of the song whose existence within the database is under question.
   * @return true if the song exists within the database, false otherwise.
   */
  public boolean containsSong(String songTitle) {
    return songLibrary.get((node) -> {
      return node.data.getSongTitle().equals(songTitle);
      }) != null;
  }
  
  /**
   * Adds a song to the database.
   * <p>
   * @param song - the new song to be added to the database.
   * @return true when the song is successfully added, false otherwise.
   */
  public boolean addSong(Song song) {
    if (this.containsSong(song.getSongTitle())) {
      return false;
    }
    songLibrary.insert(song);
    return true;
  }
  
  /**
   * Updates the song with the provided songTitle by replacing it with the new song.
   * <p>
   * @param songTitle - the title of the song to be updated.
   * @param newSong - the new song to replace the old song.
   * @return true if the song is successfully updated, false otherwise.
   */
  public boolean updateSong(Song newSong) {
    if (!this.containsSong(newSong.getSongTitle())){
      return false;
    }
    Song songToChange = songLibrary.get((node) -> {
      return newSong.getSongTitle().equals(node.data.getSongTitle());
    });
    if (!songToChange.getArtist().equals(newSong.getArtist())) {
      songToChange.setArtist(newSong.getArtist());
    }
    if (songToChange.getBpm() != newSong.getBpm()) {
      songToChange.setBpm(newSong.getBpm());
    }
    if (songToChange.getDuration() != newSong.getDuration()) {
      songToChange.setDuration(newSong.getDuration());
    }
    if (!songToChange.getGenre().equals(newSong.getGenre())) {
      songToChange.setGenre(newSong.getGenre());
    }
    if (songToChange.getYear() != newSong.getYear()) {
      songToChange.setYear(newSong.getYear());
    }
    return true;
  }
  
  /**
   * Clears the database of all songs.
   */
  public void clearDatabase() {
    this.songLibrary = new RedBlackTree<Song>();
  }
  
  /**
   * Calculates the size of the song library.
   * <p>
   * @return the size of the song library.
   */
  public int size() {
    return this.songLibrary.size();
  }
  
  /**
   * Imports songs from SongInformation.txt into the song database.
   */
  private void importSongs() {
    // Get the operating system
    String os = System.getProperty("os.name");
    // Set base file path as the path for Linux
    String fileToRead = "SongInformation.txt";
    // Adjust file path if os is Windows or MacOS
    if (os.toLowerCase().contains("win")) {
      fileToRead = "src\\SongInformation.txt";
    } else if (os.toLowerCase().contains("mac")) {
      fileToRead = "src/SongInformation.txt";
    }
    
    try {
      FileReader fileReader = new FileReader(fileToRead);
      BufferedReader buffer = new BufferedReader(fileReader);
      String line = buffer.readLine();
      while (line != null) {
        Song newSong;
        // Split line into different attributes
        String[] fields1 = line.split("\",\"");
        String[] fields2 = fields1[3].split(",");
        // Get rid of quotation marks on string fields
        fields1[0] = fields1[0].substring(1);
        String[] fields = new String[fields1.length + fields2.length - 1];
        // Copy over fields1 to fields
        for (int i = 0; i < fields1.length - 1; ++i) {
          fields[i] = fields1[i];
        }
        // Copy over fields2 to fields
        for (int i = 0; i < fields2.length; ++i) {
          fields[i + 3] = fields2[i];
        }
        // Check if it is the first line and therefore not a valid song.
        if (fields1[0].equals("")) {
          line = buffer.readLine();
          continue;
        }
        
        // Get the song title
        String songTitle = fields[1];
        
        // Get the artist
        String artist = fields[2];
        
        // Get the genre and make sure it is one of the categories.
        String genre = fields[3];
        if (genre.toLowerCase().contains("dance pop")) {
          genre = "dance pop";
        } else if (genre.toLowerCase().contains("pop")) {
          genre = "pop";
        } else if (genre.toLowerCase().contains("hip hop")) {
          genre = "hip hop";
        } else if (genre.toLowerCase().contains("rock")) {
          genre = "rock";
        } else if (genre.toLowerCase().contains("electro")) {
          genre = "electro";
        } else if (genre.toLowerCase().contains("boy band")) {
          genre = "boy band";
        } else if (genre.toLowerCase().contains("r&b")) {
          genre = "r&b";
        } else if (genre.toLowerCase().contains("soul")) {
          genre = "soul";
        } else if (genre.toLowerCase().contains("house")) {
          genre = "house";
        } else if (genre.toLowerCase().contains("dance")) {
          genre = "dance";
        } else if (genre.toLowerCase().contains("latin")) {
          genre = "latin";
        } else if (genre.toLowerCase().contains("trap")) {
          genre = "trap";
        } else if (genre.toLowerCase().contains("edm")) {
          genre = "edm";
        } else if (genre.toLowerCase().contains("wave")) {
          genre = "wave";
        } else if (genre.toLowerCase().contains("indie")) {
          genre = "indie";
        } else if (genre.toLowerCase().contains("mellow")) {
          genre = "mellow";
        } else if (genre.toLowerCase().contains("complextro")) {
          genre = "complextro";
        } else {
          // TODO may end up leaving the genre as is, talk to team
          genre = "other";
        }
        
        // Get the year
        int year = Integer.parseInt(fields[4]);
        
        // Get the bpm
        int bpm = Integer.parseInt(fields[5]);
        
        // Get the duration
        int duration = Integer.parseInt(fields[11]);
        
        // Create the song object
        newSong = new Song(songTitle, artist, genre, year, bpm, duration);
        
        // Add song to the database (if not already in database).
        if (!this.containsSong(newSong.getSongTitle())) {
          songLibrary.insert(newSong);
        }
        // Get the next line
        line = buffer.readLine();
      }
      buffer.close();
    } catch (Exception e) {
      // Catch any exceptions and stop importing. Ignore the exception.
      e.printStackTrace();
    }
  }
}
