package Seam.Intern_Coding_Assignment.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PollingJ {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String userId;
  @Column(nullable = false)
  private String apiEndpoint;
  @Column(nullable = false)
  private Long pollingInterval;

  public Long getId() {
    return id;
  }

  // Getters
  public String getUserId() {
    return userId;
  }

  public String getApiEndpoint() {
    return apiEndpoint;
  }

  public Long getPollingInterval() {
    return pollingInterval;
  }


}