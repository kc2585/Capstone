package gihoLee.Capstone.repository;

import gihoLee.Capstone.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {

    List<Post> findByBoardId(Long boardId);
    List<Post> findByUserInfo_Code(Long code);
}
