package com.salesmanager.web.shop.controller.bid;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.salesmanager.core.business.bid.model.Bid;
import com.salesmanager.core.business.bid.service.BidService;
import com.salesmanager.core.business.customer.model.Customer;
import com.salesmanager.core.business.generic.exception.ServiceException;
import com.salesmanager.web.constants.Constants;
import com.salesmanager.web.shop.controller.AbstractController;

@Controller
@RequestMapping("/shop/bid/")
public class BidController extends AbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(BidController.class);
	
	@Autowired
	BidService bidService;
	
	@RequestMapping(value = "", method=RequestMethod.POST, consumes="application/json")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void bid(@RequestBody final Long productId,
			final HttpServletRequest request) throws ServiceException {
	    Customer customer = getSessionAttribute(  Constants.CUSTOMER, request );
	    
	    LOG.info("Bid request for {} from {}.", customer.getId(), productId);
	    Bid bid = new Bid();
	    bid.setCreatedAt(new Date());
	    bid.setCustomerId(customer.getId());
	    bid.setProductId(productId);
	    bidService.save(bid);
	}
}
