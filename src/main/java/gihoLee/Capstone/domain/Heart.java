package gihoLee.Capstone.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
public class Heart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="post_id")
    private gihoLee.Capstone.domain.Post post;

    @ManyToOne
    @JoinColumn(name="user_info_code")
    private UserInfo userInfo;

    @Builder
    public Heart(gihoLee.Capstone.domain.Post post, UserInfo userInfo) {
        this.post = post;
        this.userInfo = userInfo;
    }

}
