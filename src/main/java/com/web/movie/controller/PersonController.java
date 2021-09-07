package com.web.movie.controller;

import com.web.movie.entity.Comment;
import com.web.movie.entity.User;
import com.web.movie.entity.UserInfo;
import com.web.movie.service.RatingService;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    UserService userService;

    @Autowired
    RatingService ratingService;

    @RequestMapping("/person")
    public String toPerson(ModelMap map, HttpSession session) {
        int id = (int) session.getAttribute("id");
        User user = userService.getUser(id);
        UserInfo userInfo = userService.getUserInfoById(id);
        List<Comment> commentList = ratingService.getRatingByUser(id);
        map.addAttribute("user", user);
        map.addAttribute("userInfo", userInfo);
        map.addAttribute("commentList", commentList);
        return "person";
    }

    @RequestMapping(value = "/reverse", method = RequestMethod.POST)
    public String toReverse(UserInfo userInfo, ModelMap map, HttpSession session) {
        userService.updateUserInfo(userInfo);
        int id = (int) session.getAttribute("id");
        User user = userService.getUser(id);
        List<Comment> commentList = ratingService.getRatingByUser(id);
        map.addAttribute("user", user);
        map.addAttribute("userInfo", userInfo);
        map.addAttribute("commentList", commentList);
        return "person";
    }


    @RequestMapping("delete")
    public String toDelete(int comment_id, ModelMap map, HttpSession session) {
        ratingService.deleteComment(comment_id);
        int id = (int) session.getAttribute("id");
        User user = userService.getUser(id);
        UserInfo userInfo = userService.getUserInfoById(id);
        List<Comment> commentList = ratingService.getRatingByUser(id);
        map.addAttribute("user", user);
        map.addAttribute("userInfo", userInfo);
        map.addAttribute("commentList", commentList);
        return "person";
    }
}
