// --== CS400 File Header Information ==--
// Name: Isaac Colbert
// Email: icolbert@wisc.edu
// Team: CG
// TA: Yeping Wang
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
public class Song implements Comparable<Song> {
  private String songTitle;
  private String artist;
  private String genre;
  private int year;
  private int bpm;
  private int duration;
  
  /**
   * Constructor for a song object.
   * <p>
   * @param songTitle - the title of the song.
   * @param artist - the artist of the song.
   * @param genre - the top genre of the song.
   * @param year - the year of the song.
   * @param bpm - the tempo of the song (beats per minute).
   * @param duration - the length of the song in seconds.
   */
  public Song(String songTitle, String artist, String genre, int year, int bpm, int duration) {
    this.songTitle = songTitle;
    this.artist = artist;
    this.genre = genre;
    this.year = year;
    this.bpm = bpm;
    this.duration = duration;
  }

  /**
   * Getter for the songTitle field.
   * <p>
   * @return String representing the song's title.
   */
  protected String getSongTitle() {
    return songTitle;
  }

  /**
   * Getter for artist field.
   * <p>
   * @return String representing the artist's name.
   */
  protected String getArtist() {
    return artist;
  }

  /**
   * Setter for the artist field.
   * <p>
   * @param artist - the artist's updated name.
   */
  protected void setArtist(String artist) {
    this.artist = artist;
  }

  /**
   * Getter for the genre field.
   * <p>
   * @return String representing the song's genre.
   */
  protected String getGenre() {
    return genre;
  }

  /**
   * Setter for the genre field.
   * <p>
   * @param genre - the song's updated genre.
   */
  protected void setGenre(String genre) {
    this.genre = genre;
  }

  /**
   * Getter for the year field.
   * <p>
   * @return int representing the year of the song.
   */
  protected int getYear() {
    return year;
  }

  /**
   * Setter for the year field.
   * <p>
   * @param year - the updated year of the song.
   */
  protected void setYear(int year) {
    this.year = year;
  }

  /**
   * Getter for the bpm field.
   * <p>
   * @return int representing the song's tempo in beats per minute.
   */
  protected int getBpm() {
    return bpm;
  }

  /**
   * Setter for the bpm field.
   * <p>
   * @param bpm - the updated bpm of the song.
   */
  protected void setBpm(int bpm) {
    this.bpm = bpm;
  }

  /**
   * Getter for the duration of the song in seconds.
   * <p>
   * @return int representing the duration of the song in seconds.
   */
  protected int getDuration() {
    return duration;
  }

  /**
   * Setter for the duration of the song in seconds.
   * <p>
   * @param duration - the duration of the song in seconds.
   */
  protected void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * Compares the song title of this song to the passed song's title. If this song is less than the 
   * passed song, it returns a negative number. If this song is greater than the passed song, it 
   * returns a positive number. If the two songs are equal, this method will return 0.
   * <p>
   * @param otherSong - The song to compare this song to.
   * @return a negative number if this song is less than the passed song, a positive number if this 
   * song is greater than the passed song, and 0 if the two songs are equal.
   */
  @Override
  public int compareTo(Song otherSong) {
    return this.compareTo(otherSong.getSongTitle());
  }
  
  /**
   * Compares the song title of this song to the passed String. If this song is less than the 
   * passed title, it returns a negative number. If this song is greater than the passed song, it 
   * returns a positive number. If the two songs are equal, this method will return 0.
   * <p>
   * @param otherSongTitle - a String of the title to compare this song to.
   * @return a negative number if this song is less than the passed song, a positive number if this 
   * song is greater than the passed song, and 0 if the two songs are equal.
   */
  public int compareTo(String otherSongTitle) {
    return this.songTitle.compareTo(otherSongTitle);
  }
}
