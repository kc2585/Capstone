package gihoLee.Capstone.repository;

import java.util.Optional;
import gihoLee.Capstone.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    // 이메일로 UserInfo 찾기
    Optional<UserInfo> findByEmail(String email);

    // 이메일이 존재하는지 확인
    boolean existsByEmail(String email);
}
