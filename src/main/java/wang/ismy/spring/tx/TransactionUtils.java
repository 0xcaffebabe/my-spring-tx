package wang.ismy.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author MY
 * @date 2020/1/11 16:17
 */
@Component
public class TransactionUtils {

    @Autowired
    private DataSourceTransactionManager transactionManager;

    public TransactionStatus begin(){
        return transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    public void commit(TransactionStatus transaction){
        transactionManager.commit(transaction);
    }

    public void rollback(TransactionStatus transaction){
        transactionManager.rollback(transaction);
    }
}
