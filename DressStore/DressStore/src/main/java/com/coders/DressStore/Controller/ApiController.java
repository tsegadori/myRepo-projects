package com.coders.DressStore.Controller;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coders.DressStore.Entity.PaymentInfo;
import com.coders.DressStore.Entity.Product;
import com.coders.DressStore.Entity.ProductsImages;
import com.coders.DressStore.Entity.ProductsView;
import com.coders.DressStore.Service.ServiceDao;
import com.coders.DressStore.Service.StripeClient;

@CrossOrigin(origins="*")
//@CrossOrigin(origins= { "*","http://localhost:4200/"})
@RestController
public class ApiController {

	@Autowired
	ServiceDao serviceDao;
	
		@GetMapping("/products")
		List<Product> getProducts(){
			return serviceDao.getProductsList();
		}
		
		@GetMapping("/products/{id}")
		Product getProduct(@PathVariable int id) {
			return serviceDao.getProduct(id);
		}
		
		@GetMapping("/products-image")
		List<ProductsImages> getProductsImageList(){
			return serviceDao.getProductImagesList();
		}
		
		@GetMapping("/products-image/{id}")
		ProductsImages getProductImages(@PathVariable int id){
			return serviceDao.getProductImage(id);
		}
		
		@GetMapping("/products/view")
		List<ProductsView> getAllProductsView(){
			return serviceDao.getAllProductsView();
		}
		
		@Autowired
		private StripeClient stripeClient;

		@PostMapping("/payment/charge")
		public Charge chargeCard(@RequestBody PaymentInfo request) throws Exception {
	        String token = request.getToken();
	      //  Double amount = Double.parseDouble(request.getHeader("amount"));
	        Double amount = request.getAmount();
 	        return this.stripeClient.chargeNewCard(token, amount);
	    }
	}
