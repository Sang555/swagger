package com.sapient.productService.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productService.model.Product;

@Transactional
@Repository("hibernateDAOImp")
public class HibernateDaoImpl  implements ProductDAO{
	
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Product").list();
		
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Product.class, id);
	}

	@Override
	public void register(Product product) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		
	}

	@Override
	public void deleteProd(int id) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        Product product = session.byId(Product.class).load(id);
        session.delete(product);
		
	}

	@Override
	public void update(int id, Product product) {
		// TODO Auto-generated method stub
		
	}

}
