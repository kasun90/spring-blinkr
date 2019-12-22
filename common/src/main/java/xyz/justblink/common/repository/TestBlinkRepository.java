package xyz.justblink.common.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xyz.justblink.common.entity.Test;
import xyz.justblink.core.database.BlinkRepository;

import java.util.List;

@Repository
public interface TestBlinkRepository extends BlinkRepository<Test, Long> {
    public List<Test> findByEmail(String email);
    public List<Test> findByEmailLike(String phrase);
    @Query("select t from Test t where t.email like ?1")
    public List<Test> findByEmailLikeMine(String phrase);
}
