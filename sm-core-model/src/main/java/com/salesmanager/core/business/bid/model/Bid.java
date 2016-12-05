package com.salesmanager.core.business.bid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.salesmanager.core.business.generic.model.SalesManagerEntity;
import com.salesmanager.core.constants.SchemaConstant;

@Entity
@Table (name="BIDS", schema = SchemaConstant.SALESMANAGER_SCHEMA)
public class Bid extends SalesManagerEntity<Long, Bid> {
  /**
	 *
	 */
	private static final long serialVersionUID = 1239L;

	@Id
	@Column (name ="ID" , unique=true , nullable=false )
	@TableGenerator(name = "TABLE_GEN", table = "SM_SEQUENCER", pkColumnName = "SEQ_NAME", valueColumnName = "SEQ_COUNT",
		pkColumnValue = "BID_ID_SEQ_NEXT_VAL")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	private Long id;

  @Column (name ="CUSTOMER_ID")
  private Long customerId;
  @Column (name ="PRODUCT_ID")
  private Long productId;


	@Temporal(TemporalType.TIMESTAMP)
	@Column (name ="CREATED_AT")
	private Date createdAt;

  public Long getId() {
    return this.id;
  }

  public Long getCustomerId() {
    return this.customerId;
  }

  public Long getProductId() {
    return this.productId;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
