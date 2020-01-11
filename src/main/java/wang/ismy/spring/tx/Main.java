package wang.ismy.spring.tx;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import wang.ismy.spring.tx.service.UserService;

/**
 * @author MY
 * @date 2020/1/11 16:11
 */
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);
        UserService service = context.getBean(UserService.class);
        service.add();
    }
}
