package com.example.demo.Mapper;

import com.example.demo.Comment.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface test {

    @Select("SELECT * FROM t_comment")
    List<Comment> findAll();

    @Select("SELECT * FROM t_comment WHERE id=#{id}")
    Comment findById(Long id);

    @Insert("INSERT INTO t_comment(content,author) VALUES #{content},#{author}")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Comment comment);

    @Update("UPDATE t_comment SET content = #{content} , author = #{author} WHERE id=#{id} ")
    void update(Comment comment);

    @Delete("DELETE FROM t_comment WHERE id=#{id}")
    void delete(Long id);
}
