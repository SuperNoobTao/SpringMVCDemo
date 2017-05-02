package com.gaussic.controller;

import com.gaussic.model.CommentEntity;
import com.gaussic.repository.CommentReposity;
import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import org.dom4j.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/4/30.
 */

@RestController
public class CommentController {

    @Autowired
    CommentReposity commentReposity;

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    public List<CommentEntity> listComments() {

        List<CommentEntity> list = commentReposity.findAll();

        return list;
    }

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public CommentEntity saveComments(String userName,String comment) {

        Date date = new Date();
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(comment);
        commentEntity.setUserName(userName);
        commentEntity.setTime(date);
        commentReposity.saveAndFlush(commentEntity);
        return commentEntity;

    }
}
