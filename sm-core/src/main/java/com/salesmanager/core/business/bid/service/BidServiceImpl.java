package com.salesmanager.core.business.bid.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesmanager.core.business.bid.model.Bid;
import com.salesmanager.core.business.bid.dao.BidDao;
import com.salesmanager.core.business.generic.service.SalesManagerEntityServiceImpl;

@Service("bidService")
public class BidServiceImpl extends SalesManagerEntityServiceImpl<Long, Bid> implements BidService {
  @Autowired
  public BidServiceImpl(final BidDao bidDao) {
    super(bidDao);
  }
}
