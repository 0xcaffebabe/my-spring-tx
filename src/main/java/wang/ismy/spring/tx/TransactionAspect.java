package wang.ismy.spring.tx;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;

/**
 * @author MY
 * @date 2020/1/11 16:45
 */
@Component
@Aspect
public class TransactionAspect {

    @Autowired
    TransactionUtils transactionUtils;

    @Pointcut("@annotation(javax.transaction.Transactional)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        TransactionStatus transaction = transactionUtils.begin();
        try {
            Object proceed = point.proceed();
            transactionUtils.commit(transaction);
            return proceed;
        } catch (Throwable throwable) {
            System.out.println("发生异常，事务回滚");
            transactionUtils.rollback(transaction);
            throw throwable;
        }
    }


}
