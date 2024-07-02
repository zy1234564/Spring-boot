package com.example.demo.service;

import com.example.demo.Comment.Comment;
import com.example.demo.Mapper.IndexMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tst {
    public final IndexMapper indexMapper;

    public tst(IndexMapper indexMapper) {
        this.indexMapper = indexMapper;
    }

    public List<Comment> findCommentAll(){
        return indexMapper.findAll();
    }

    public Comment findCommentById(Long id){
        return indexMapper.findById(id);
    }

    public void saveComment(Comment comment){
        if (comment.getId() == null ){
            indexMapper.insert(comment);
        }else {
            indexMapper.update(comment);
        }
    }

    public void deleteComment(Long id){
        indexMapper.delete(id);
    }
}
