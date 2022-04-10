package gihoLee.Capstone.dto;

import gihoLee.Capstone.domain.Post;
import gihoLee.Capstone.domain.UserInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class CreateCommentRequest {

    private String context;
}
