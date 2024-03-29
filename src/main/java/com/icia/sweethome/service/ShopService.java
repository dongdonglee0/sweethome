package com.icia.sweethome.service;


import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.icia.sweethome.dao.ShopDao;
import com.icia.sweethome.model.Cart;
import com.icia.sweethome.model.Review;
import com.icia.sweethome.model.Shop;

@Service ("shopService")
public class ShopService 
{
	private static Logger logger = LoggerFactory.getLogger(ShopService.class);
	
	@Autowired
	private ShopDao shopDao;

	//---------------------------------------------------------------------------
	//shop - shop, product 
	public List<Shop> shopList(Shop shop) {
	    List<Shop> list = null;
	    
	    try {
	        list = shopDao.shopList(shop);
	        
	    }
	    catch (Exception e) {
	        logger.error("[ShopService] shopList Exception", e);
	    }
	    
	    return list;
	}
			

	//shop - product 카테고리
	public List<Shop> productDetailselct(String code) {
		List<Shop> detialCodeList= null;
		
		try
		{
			detialCodeList = shopDao.productDetailselct(code);
		}
		catch(Exception e)
		{
			logger.error("[shopService] productDetailselct Exception", e);
		}
			
		return detialCodeList;
	}
	
	
	public List<String> productBrandselct(Shop code){
		return shopDao.productBrandSelct(code);
	}	
	
	
	//shop - bestItem
	public List<Shop> shopListView(Shop shop)
	{
		List<Shop> listView = null;
			
		try
		{
			listView = shopDao.shopListView(shop);
		}
		catch(Exception  e)
		{
			logger.error("[ShopService] shopListView Exception" , e);
		}
		return listView;
	}
	
	
	//shop - productDetail
	public Shop productSelect(int productIdk)
	{
		Shop shop = null;
		int productCnt = 0;
		
		try
		{
			shop = shopDao.productSelect(productIdk);
			productCnt=shopDao.shopListViewCntPlus(productIdk);
		}
		catch(Exception  e)
		{
			logger.error("[ShopService] productSelect Exception" , e);
		}
		return shop;
	}
	
	
	
	
	public int shopListCount(Shop shop)
	{
		int count = 0;
			
		try
		{
			count = shopDao.shopListCount(shop);
		}
		catch(Exception  e)
		{
			logger.error("[ShopService] shopListCount Exception" , e);
		}
		return count;
	}
	
	public int shopListViewCount(Shop shop)
	{
		int count = 0;
		
		try
		{
			count = shopDao.shopListViewCount(shop);
		}
		catch(Exception  e)
		{
			logger.error("[ShopService] shopListViewCount Exception" , e);
		}
		return count;
	}
	
	 
	 //shop - cart
	public List<Cart> cartSelect(Cart cart)
	   {
		List<Cart>  cartSelect = null;
		try
		{
			cartSelect = shopDao.cartSelect(cart);
		}
		catch(Exception e)
		{
			logger.error("[shopService] cartSelect Exception", e);
		}
		   
		return cartSelect;
	}

	 
	 public int cartInsert(Cart cart)
	   {
	      int count = 0;
	      
	      try
	      {
	         count =  shopDao.cartInsert(cart);
	      }
	      catch(Exception e)
	      {
	         logger.error("[ShopService]cartInsert Exception", e);
	      }
	      
	      return count;
	      
	   }
	
	 public int cartUpdate(Cart cart)
	   {
	      int count = 0;
	      
	      try
	      {
	         count =  shopDao.cartUpdate(cart);
	      }
	      catch(Exception e)
	      {
	         logger.error("[ShopService]cartUpdate Exception", e);
	      }
	      
	      return count;
	      
	   }
	
	 
	 public List<Cart> cartList(Cart cart)
		{
		 	List<Cart>  cartList = null;
			  	   
			try
			{
				cartList = shopDao.cartList(cart);
			}
			catch(Exception e)
			{
				logger.error("[shopService] cartList Exception", e);
			}
			   
			return cartList;
		}
	 
	 
	 public int cartListCount(Cart cart)
		{
			 int count = 0;
				
				try
				{
					count = shopDao.cartListCount(cart);
				}
				catch(Exception e)
				{
					logger.error("[shopService] boardMyReviewCount Exception", e);
				}
				
				return count;
			}
	 
	 
	 public int cartDelete(Cart cart)
		{  
			int count = 0;
	      
	      try
	      {
	         count =  shopDao.cartDelete(cart);
	      }
	      catch(Exception e)
	      {
	         logger.error("[ShopService]cartDelete Exception", e);
	      }
	      
	      return count;
	      
	   }
	 
	 
	 
	 
	 
	 
	 
	 //user - review
		public List<Review> boardMyReview(Review review)
		{
			List<Review> list = null;
			   	   
			try
			{
				list = shopDao.boardMyReview(review);
			}
			catch(Exception e)
			{
				logger.error("[shopService] boardMyReview Exception", e);
			}
			   
			return list;
		}
				
		//리뷰 건수
		public int boardMyReviewCount(Review review)
		{
			int count = 0;
			
			try
			{
				count = shopDao.boardMyReviewCount(review);
			}
			catch(Exception e)
			{
				logger.error("[shopService] boardMyReviewCount Exception", e);
			}
			
			return count;
		}
		
		// 리뷰 존재여부
		public int boardMyReviewSearch(int productIdk)
		{
			int count = 0;
				
			try
			{
				count = shopDao.boardMyReviewSearch(productIdk);
			}
			catch(Exception e)
			{
				logger.error("[shopService] boardMyReviewSearch Exception", e);
			}
				
			return count;
		}
		
		// 리뷰 삭제
		public int boardMyReviewDelete(int productIdk)
		{
			int count = 0;
					
			try
			{
				count = shopDao.boardMyReviewDelete(productIdk);
			}
			catch(Exception e)
			{
				logger.error("[shopService] boardMyReviewDelete Exception", e);
			}
				
			return count;
		} 
		
		
		//민기 -리뷰
		@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
		 public int reviewInsert(Review review){
		      int count = 0;
		      
		      count =  shopDao.reviewInsert(review);
		      
		      if(count > 0) {
		    	  shopDao.reviewUpdate(review.getOrderDetailIdk());
		      }
		         
		      return count;
		 }
		
		public List<Review> reviewList(int productIdk){
			List<Review> list = null;
			
			try
			{
				list = shopDao.reviewList(productIdk);
			}
			catch(Exception e)
			{
				logger.error("[shopService] reviewList Exception", e);
			}
						
			return list;
			
		}
		
		public int recommend(){
			List<Integer> list = null;
			int recom = 0;
			try
			{
				list = shopDao.recommend();			
		        Random random = new Random();
		        int randomIndex = random.nextInt(list.size()); 
		        // 추천된 값을 가져오기
		        recom = list.get(randomIndex);			
			}
			catch(Exception e)
			{
				logger.error("[shopService] recommend Exception", e);
			}		
			return recom;
		}
		
}



