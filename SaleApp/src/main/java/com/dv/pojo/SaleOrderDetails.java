package com.dv.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author diosvo
 */
@Entity
@Table(name = "order_detail")
public class SaleOrderDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private SaleOrder saleOrder;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "num")
    private int quantiy;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the saleOrder
     */
    public SaleOrder getSaleOrder() {
        return saleOrder;
    }

    /**
     * @param saleOrder the saleOrder to set
     */
    public void setSaleOrder(SaleOrder saleOrder) {
        this.saleOrder = saleOrder;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the quantiy
     */
    public int getQuantiy() {
        return quantiy;
    }

    /**
     * @param quantiy the quantiy to set
     */
    public void setQuantiy(int quantiy) {
        this.quantiy = quantiy;
    }
}
