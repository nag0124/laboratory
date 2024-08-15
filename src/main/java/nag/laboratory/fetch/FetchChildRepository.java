package nag.laboratory.fetch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FetchChildRepository extends JpaRepository<FetchChild, Long> {
}
