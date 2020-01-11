package wang.ismy.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author MY
 * @date 2020/1/11 16:24
 */
@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(String name){
        jdbcTemplate.update("INSERT INTO user VALUES(?)",name);
    }
}
