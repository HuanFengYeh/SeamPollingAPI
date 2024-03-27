package Seam.Intern_Coding_Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import Seam.Intern_Coding_Assignment.Model.PolledData;
import Seam.Intern_Coding_Assignment.Model.PollingJ;

@Repository
public interface JobRepository extends JpaRepository<PollingJ, Long> {
  Optional<PollingJ> findByapiEndpoint(String apiEndpoint);
}
