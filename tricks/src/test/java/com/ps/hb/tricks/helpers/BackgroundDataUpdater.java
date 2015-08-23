package com.ps.hb.tricks.helpers;

import com.ps.hb.tricks.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BackgroundDataUpdater {

    @Autowired
    SessionFactory factory;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeProductPrice(int id, double price) {
        Session session = factory.getCurrentSession();
        Product product = (Product)session.load(Product.class, id);
        product.setPrice(price);
        session.update(product);
    }

}
