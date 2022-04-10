package gihoLee.Capstone.repository;

import gihoLee.Capstone.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

}
