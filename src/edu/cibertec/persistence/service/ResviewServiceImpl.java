package edu.cibertec.persistence.service;

import java.util.List;

import org.apache.log4j.Logger;

import edu.cibertec.entity.Local;
import edu.cibertec.entity.Review;
import edu.cibertec.persistence.jpa.dao.ReviewJPA;

public class ResviewServiceImpl implements IReviewService{
	static final Logger log = Logger.getLogger(ResviewServiceImpl.class);
	ReviewJPA reviewJPA = new ReviewJPA();
	@Override
	public Review getReview(Integer id) throws Exception {
		log.info("Se ingreso a getReview()");
		Review rev= null;

		reviewJPA.createEM();
		rev= reviewJPA.get(id);
		reviewJPA.releaseEM();
		
		log.info("Saliendo de getReview()");
		
		return rev;
	}

	@Override
	public List<Review> getReviews() throws Exception {
		log.info("Se ingreso a getReviews()");
		List<Review>revs= null;

		reviewJPA.createEM();
		revs= reviewJPA.getAll();
		reviewJPA.releaseEM();
		
		log.info("Saliendo de getReviews()");
		
		return revs;
	}

	@Override
	public List<Review> getReviewsXLocal(int id) throws Exception {
		log.info("Se ingreso a getReviewsXLocal()");
		List<Review>revs= null;

		reviewJPA.createEM();
		revs= reviewJPA.getAllxField(id);
		reviewJPA.releaseEM();
		
		log.info("Saliendo de getReviewsXLocal()");
		
		return revs;
	}

	@Override
	public Review registrar(Review Review) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review actualizar(Review Review) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
