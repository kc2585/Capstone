package gihoLee.Capstone.repository;

import gihoLee.Capstone.domain.Scrap;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {

    Optional<Scrap> findByUserInfoAndPost(Long userInfoId, Long postId);
}
