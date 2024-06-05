package vn.gmestoken.core.newsfeed.post;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "newsfeed_post")
@Entity
public class NewsfeedPost implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id  
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "newsfeed_post_generator")
	@SequenceGenerator(name = "newsfeed_post_generator", sequenceName = "newsfeed_post_id_seq", allocationSize = 1) 
    protected Long id;

    @Column(name = "content")
    private String content;


    @Column(name = "created_date")
    private LocalDateTime created_date;

    @Column(name = "createdby_idlink")
    private Long createdby_idlink;

    @Column(name = "lastmodified_date")
    private LocalDateTime lastmodified_date;

    @Column(name = "lastmodifiedby_idlink")
    private Long lastmodifiedby_idlink;

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

    public LocalDateTime getLastmodified_date() {
        return lastmodified_date;
    }

}
