package Seam.Intern_Coding_Assignment.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Seam.Intern_Coding_Assignment.Model.PollingJ;
import Seam.Intern_Coding_Assignment.Service.PollingService;

@RestController
@RequestMapping("/polling-jobs")
public class PollingServiceController {

  @Autowired
  private PollingService pollingService;

  @PostMapping
  public ResponseEntity<String> createPollingJob(@RequestBody PollingJ request) {
    return pollingService.createPollingJob(request);
  }
}
