package com.ps.hb.tricks;

import com.ps.hb.tricks.helpers.BackgroundDataUpdater;
import com.ps.hb.tricks.model.BuyOrder;
import com.ps.hb.tricks.model.Product;
import org.hibernate.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.orm.hibernate4.HibernateOptimisticLockingFailureException;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
@ComponentScan(basePackages = {"com.ps.hb.tricks.helpers"})
@TransactionConfiguration(defaultRollback = false)
public class TestLocking {

    @Autowired SessionFactory factory;
    @Autowired BackgroundDataUpdater updater;
    @Autowired
    ConcurrentTaskExecutor executor;

//    @SqlGroup({
//        @Sql(scripts = "prepare-locking-test.sql"),
//        @Sql(scripts = "clear-all-data.sql")
//    })
    @Test(expected = HibernateOptimisticLockingFailureException.class)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void optimisticLock() throws ExecutionException, InterruptedException {
        Session session = factory.getCurrentSession();
        // Get product LockMode.PESSIMISTIC is applied by default since we have @Version
        Product product = (Product) session.get(Product.class, 1);
        final int productId = product.getId();
        // Try to change product price in another transaction
        executor.submit((new Runnable() {
            @Override
            public void run() {
                updater.changeProductPrice(productId, Math.random() * 10);
            }
        })).get();
        // Try to create new buy order for locked product
        product.setPrice(3.0);
        session.persist(product);
    }

}

