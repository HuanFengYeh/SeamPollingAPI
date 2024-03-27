package Seam.Intern_Coding_Assignment.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

import Seam.Intern_Coding_Assignment.Model.PolledData;
import Seam.Intern_Coding_Assignment.Model.PollingJ;
import Seam.Intern_Coding_Assignment.Repository.DataRepository;
import Seam.Intern_Coding_Assignment.Repository.JobRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;

@Service
public class PollingService {
  @Autowired
  private final JobRepository jobRepository;
  @Autowired
  private final DataRepository dataRepository;

  public PollingService(JobRepository jobRepository, DataRepository dataRepository) {
    this.jobRepository = jobRepository;
    this.dataRepository = dataRepository;
  }

  private RestTemplate restTemplate = new RestTemplate();
  private TaskScheduler taskScheduler;

  @PostConstruct
  private void init() {
    ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
    scheduler.initialize();
    this.taskScheduler = scheduler;
  }

  // Method to start polling jobs
  public ResponseEntity<String> createPollingJob(PollingJ job) {

    try {
      if(jobRepository.findByapiEndpoint(job.getApiEndpoint()).isEmpty()) {
        //create a new pulling job
        jobRepository.save(job);
        schedulePollingJob(job);
      }else {
        // Update the interval
        jobRepository.save(job);
        schedulePollingJob(job);
        return new ResponseEntity<>("Update the interval",
                HttpStatus.OK);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(),
              HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("Polling job created successfully.",
            HttpStatus.OK);
  }

  // Method to schedule polling jobs
  private void schedulePollingJob(PollingJ job) {
    ScheduledFuture<?> futureTask = taskScheduler.scheduleWithFixedDelay(
            () -> pollApi(job),
            job.getPollingInterval());
  }

  // Method to poll the data
  private void pollApi(PollingJ job) {
    String response = restTemplate.getForObject(job.getApiEndpoint(), String.class);
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      List<PolledData> movies = objectMapper.readValue(response, new TypeReference<List<PolledData>>(){});
      for (PolledData movie : movies) {
        if (dataRepository.findBymovie(movie.getMovie()).isEmpty()) {
          dataRepository.save(movie);
        }
      }
      System.out.print("Successfully Update the Movies, User: " + job.getUserId() + "\n");
    } catch (Exception e) {
      System.out.print(e.getMessage());
    }
  }
}

