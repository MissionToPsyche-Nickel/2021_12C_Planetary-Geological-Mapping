package planetarymapping.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import planetarymapping.model.UserAuthorities;


public interface AuthoritiesRepository extends JpaRepository<UserAuthorities, Long> {
}
