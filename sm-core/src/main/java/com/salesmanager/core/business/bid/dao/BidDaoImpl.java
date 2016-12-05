package com.salesmanager.core.business.bid.dao;

import org.springframework.stereotype.Repository;

import com.salesmanager.core.business.bid.model.Bid;
import com.salesmanager.core.business.generic.dao.SalesManagerEntityDaoImpl;

@Repository("bidDaoImpl")
public class BidDaoImpl extends SalesManagerEntityDaoImpl<Long, Bid>
    implements BidDao {

  public BidDaoImpl() {
    super();
  }

}
