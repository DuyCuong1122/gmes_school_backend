package vn.gmestoken.core.newsfeed.like;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.time.LocalDateTime;

import javax.persistence.Column;

@Table(name = "newsfeed_like")
@Entity
public class NewsfeedLike implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsfeed_like_generator")
	@SequenceGenerator(name = "newsfeed_like_generator", sequenceName = "newsfeed_like_id_seq", allocationSize = 1)

    protected Long id;

    @Column(name = "postid_link")
    private Long post_id;

    @Column(name = "created_date")
    private LocalDateTime created_date;

    @Column(name = "createdby_idlink")
    private Long createdby_idlink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
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

}
