package edu.cibertec.persistence.service;

import java.util.List;

import edu.cibertec.entity.Review;

public interface IReviewService {
	public Review getReview(Integer id) throws Exception;
	public List<Review> getReviews()	throws Exception;
	public List<Review> getReviewsXLocal(int id)	throws Exception;
	public Review registrar(Review Review) throws Exception;
	public Review	actualizar(Review Review) throws Exception;

	public void eliminar(Integer id) throws Exception;
}
