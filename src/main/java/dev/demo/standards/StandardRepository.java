package dev.demo.standards;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface StandardRepository extends JpaRepository<Standard,Long> {
 Optional<Standard> findByCode(String code);
 @Query("select s from Standard s where lower(s.title) like lower(concat('%',:q,'%')) or lower(s.code) like lower(concat('%',:q,'%')) or lower(s.body) like lower(concat('%',:q,'%'))")
 List<Standard> search(@Param("q") String q);
}
