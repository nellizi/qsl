package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.user.entity.SiteUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;


public interface UserRepository extends JpaRepository<SiteUser, Long>,UserRepositoryCustom {


    List<SiteUser> findByInterestKeywordsContaining(String kw);

    List<SiteUser> findByInterestKeywords_content(String kw);
}
