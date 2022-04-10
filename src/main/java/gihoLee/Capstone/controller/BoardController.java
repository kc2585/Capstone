package gihoLee.Capstone.controller;

import gihoLee.Capstone.domain.UserInfo;
import gihoLee.Capstone.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardService boardService;

    // 전체 커뮤니티
    @GetMapping("/community")
    public String getBoard(Model model) {
        List<gihoLee.Capstone.dto.PostDto> postList = boardService.getAllPostList();
        model.addAttribute("postList", postList);
        return "community";
    }

    // 자유 게시판
    @GetMapping("/community/free")
    public String getFreeBoard(Model model) {
        List<gihoLee.Capstone.dto.PostDto> postList = boardService.getPostList(3L);
        model.addAttribute("postList", postList);
        return "community";
    }

    // 특정 게시물 확인
    @GetMapping("/community/{postId}")
    public String getPost(@PathVariable Long postId, Model model) {
        gihoLee.Capstone.dto.PostDetailDto postDetailDto = boardService.getPost(postId);
        List<gihoLee.Capstone.dto.CommentDto> comment = boardService.getComment(postId);
        model.addAttribute("post", postDetailDto);
        model.addAttribute("commentList", comment);
        return "view";
    }

    @GetMapping("/community/write")
    public String write(@AuthenticationPrincipal UserInfo userInfo) {

        if(userInfo==null)
            return "login";

        return "write";
    }

    @PostMapping("/community/write")
    public RedirectView savePost(gihoLee.Capstone.dto.CreatePostRequest request, @AuthenticationPrincipal UserInfo userInfo) {
        boardService.savePost(request,userInfo);
        return new RedirectView("/community");
    }

    @PostMapping("/community/comment/{postId}")
    public RedirectView saveComment(@PathVariable Long postId, gihoLee.Capstone.dto.CreateCommentRequest request, @AuthenticationPrincipal UserInfo userInfo) {

        if(userInfo==null)
            return new RedirectView("/login");

        boardService.saveComment(postId,request,userInfo);
        return new RedirectView("/community/{postId}");
    }

    @DeleteMapping("/community/{postId}/{commentId}")
    public RedirectView deleteComment(@PathVariable String postId, @PathVariable String commentId) {
        Long post_id = Long.parseLong(postId);
        Long comment_id = Long.parseLong(commentId);

        boardService.deleteComment(post_id,comment_id);
        return new RedirectView("/community/{postId}");
    }

    @GetMapping("/community/{postId}/like")
    public RedirectView saveLike(@PathVariable String postId, @AuthenticationPrincipal UserInfo userInfo) {
        Long id = Long.parseLong(postId);
        boardService.saveLike(id, userInfo);
        return new RedirectView("/community/{postId}");
    }

    @DeleteMapping("/community/{postId}/like")
    public RedirectView deleteLike(@PathVariable String postId, @AuthenticationPrincipal UserInfo userInfo) {
        Long id = Long.parseLong(postId);
        boardService.deleteLike(id, userInfo);
        return new RedirectView("/community/{postId}");
    }

    @GetMapping("/community/{postId}/scrap")
    public RedirectView saveScrap(@PathVariable String postId, @AuthenticationPrincipal UserInfo userInfo) {
        Long id = Long.parseLong(postId);
        boardService.saveScrap(id,userInfo);
        return new RedirectView("/community/{postId}");
    }

    @DeleteMapping("/community/{postId}/scrap")
    public RedirectView deleteScrap(@PathVariable String postId, @AuthenticationPrincipal UserInfo userInfo) {
        Long id = Long.parseLong(postId);
        boardService.deleteScrap(id, userInfo);
        return new RedirectView("/community/{postId}");
    }

}
