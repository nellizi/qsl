package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.interestKeyword.entity.InterestKeyword;
import com.ll.exam.qsl.user.entity.SiteUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);

    long getQslCount();

    SiteUser getQslUserOrderByIdAscOne();

    List<SiteUser> getQslUsersOrderByIdAsc();

    List<SiteUser> searchQsl(String kw);

    Page<SiteUser> searchQsl(String kw, Pageable pageable);

    List<SiteUser> getQslUsersByInterestKeyword(String keywordContent);

    List<InterestKeyword> getQslInterestKeywordByQslUser(SiteUser user);
    List<String> getKeywordContentsByFollowingsOf(SiteUser user);
    List<String> getQuerydslInterestKeywordsByFollowings(SiteUser user);
}
