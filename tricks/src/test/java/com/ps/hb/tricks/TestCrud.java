package com.ps.hb.tricks;

import com.ps.hb.tricks.model.BuyOrder;
import com.ps.hb.tricks.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DataConfig.class})
@TransactionConfiguration(defaultRollback = false)
public class TestCrud {

    @Autowired
    SessionFactory factory;

    @Test @Transactional @Rollback
    public void testCrud() {
        Session session = factory.getCurrentSession();
        // Add product
        Product product = new Product();
        product.setName("Milk");
        product.setPrice(1.25);
        session.persist(product);
        // Create order for the product
        BuyOrder buyOrder = new BuyOrder();
        buyOrder.setProduct(product);
        Integer id = (Integer) session.save(buyOrder);
        // Verify data
        buyOrder = (BuyOrder)session.get(BuyOrder.class, id);
        System.out.println(buyOrder);
        assertEquals(buyOrder.getProduct().getName(), "Milk");
        assertTrue(buyOrder.getProduct().getPrice().floatValue() == 1.25);
    }

}

