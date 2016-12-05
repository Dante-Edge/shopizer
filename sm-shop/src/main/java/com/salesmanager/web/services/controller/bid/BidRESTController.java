package com.salesmanager.web.services.controller.bid;

import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.salesmanager.core.business.bid.model.Bid;
import com.salesmanager.core.business.bid.service.BidService;
import com.salesmanager.core.business.customer.model.Customer;
import com.salesmanager.core.business.customer.service.CustomerService;
import com.salesmanager.core.business.merchant.model.MerchantStore;
import com.salesmanager.core.business.merchant.service.MerchantStoreService;
import com.salesmanager.web.constants.Constants;
import com.salesmanager.web.entity.customer.PersistableCustomer;
import com.salesmanager.web.populator.customer.CustomerPopulator;


@Controller
@RequestMapping("/services／private")
public class BidRESTController {
  private static final Logger LOGGER = LoggerFactory.getLogger(BidRESTController.class);

  @Autowired
  BidService bidService;
  @Autowired
  MerchantStoreService merchantStoreService;


  @RequestMapping( value="/{store}/bid", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public Bid bid(@PathVariable final String store,
      @RequestBody Long productId,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {

        MerchantStore merchantStore = (MerchantStore)request.getAttribute(Constants.MERCHANT_STORE);

        if(merchantStore!=null) {
    			if(!merchantStore.getCode().equals(store)) {
    				merchantStore = null;
    			}
    		}
    		if(merchantStore== null) {
    			merchantStore = merchantStoreService.getByCode(store);
    		}

    		if(merchantStore==null) {
    			LOGGER.error("Merchant store is null for code " + store);
    			response.sendError(503, "Merchant store is null for code " + store);
    			return null;
    		}

        Customer customer = (Customer)request.getAttribute(Constants.CUSTOMER);

        Bid bid = new Bid();
        bid.setCustomerId(customer.getId());
        bid.setProductId(productId);
        bid.setCreatedAt(new Date());

        bidService.create(bid);

        return bid;
  }
}
