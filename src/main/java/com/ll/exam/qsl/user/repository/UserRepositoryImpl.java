package com.ll.exam.qsl.user.repository;

import com.ll.exam.qsl.user.entity.QSiteUser;
import com.ll.exam.qsl.user.entity.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ll.exam.qsl.user.entity.QSiteUser.siteUser;


@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public SiteUser getQslUser(Long id){
         /*
        SELECT *
        FROM site_user
        WHERE id = 1
        */


        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .where(siteUser.id.eq(id))
                .fetchOne();


    }

    @Override
    public int getQslCount() {
//        long count = jpaQueryFactory
//                .selectFrom(siteUser)
//                .fetchCount();
//        int result = (int)count;
//        return result;

        long count = jpaQueryFactory
                .select(siteUser.count())
                .from(siteUser)
                .fetchOne();

        return (int)count;

    }

    @Override
    public SiteUser getQslOrderByIdAscOne() {
        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .orderBy(siteUser.id.asc())
                .limit(1)
                .fetchOne();
        // .fetchfirst() 를 하는것도 좋다. fetchOne 은 진짜 하나가 아닐 경우 에러가 남
    }

    @Override
    public List<SiteUser> getQslUsersOrderByIdAsc() {
        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .orderBy(siteUser.id.asc())
                .fetch();
    }

    @Override
    public List<SiteUser> searchQsl(String user1) {
        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .where(
                        siteUser.username.contains(user1)
                                .or(siteUser.email.contains(user1))
                )
                .orderBy(siteUser.id.asc())
                .fetch();
    }
}
