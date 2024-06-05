package vn.gmestoken.core.newsfeed.comment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;

import java.io.Serializable;

@Table(name = "newsfeed_comment")
@Entity
public class NewsfeedComment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsfeed_comment_generator")
	@SequenceGenerator(name = "newsfeed_comment_generator", sequenceName = "newsfeed_comment_id_seq", allocationSize = 1)
    protected Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_date")
    private LocalDateTime created_date;

    @Column(name = "createdby_idlink")
    private Long createdby_idlink;

    @Column(name = "postid_link")
    private Long postid_link;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public Long getCreatedby_idlink() {
        return createdby_idlink;
    }

    public void setCreatedby_idlink(Long createdby_idlink) {
        this.createdby_idlink = createdby_idlink;
    }

    public Long getPostid_link() {
        return postid_link;
    }

    public void setPostid_link(Long postid_link) {
        this.postid_link = postid_link;
    }

}
