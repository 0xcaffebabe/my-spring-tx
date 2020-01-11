package wang.ismy.spring.tx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import wang.ismy.spring.tx.TransactionUtils;
import wang.ismy.spring.tx.UserDao;

import javax.transaction.Transactional;

/**
 * @author MY
 * @date 2020/1/11 16:24
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    TransactionUtils transactionUtils;

    @Transactional
    public void add() {
        userDao.add("cxk");
//        int i = 1 / 0;
        userDao.add("jntm");
    }
}
