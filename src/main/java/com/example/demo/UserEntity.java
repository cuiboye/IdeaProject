package com.example.demo;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Component
@Table(name = "user", schema = "money", catalog = "")
public class UserEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid")
    private int userid;
    @Basic
    @Column(name = "username")
    private String username;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userid == that.userid && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username);
    }
}
