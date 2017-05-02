package com.gaussic.repository;

import com.gaussic.model.BlogEntity;
import com.gaussic.model.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/4/30.
 */
@Repository
public interface CommentReposity extends JpaRepository<CommentEntity, Integer> {



}
