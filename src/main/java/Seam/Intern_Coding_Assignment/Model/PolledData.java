package Seam.Intern_Coding_Assignment.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PolledData {
  @Id
  @Column(nullable = false)
  private Long id;

  @Column(nullable = false)
  private String movie;

  @Column(nullable = false)
  private double rating;

  @Column(nullable = false)
  private String image;

  @Column(nullable = false)
  @JsonProperty("imdb_url")
  private String imdbUrl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMovie() {
    return movie;
  }

  public void setMovie(String movie) {
    this.movie = movie;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImdbUrl() {
    return imdbUrl;
  }

  public void setImdbUrl(String imdbUrl) {
    this.imdbUrl = imdbUrl;
  }

  //Getters and Setters


}