package Seam.Intern_Coding_Assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import Seam.Intern_Coding_Assignment.Model.PolledData;

@Repository
public interface DataRepository extends JpaRepository<PolledData, Long> {
  Optional<PolledData> findBymovie(String movie);
}
