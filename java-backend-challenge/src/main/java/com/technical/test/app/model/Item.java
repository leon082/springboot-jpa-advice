package com.technical.test.app.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")

  private Long id;
  @Column(name = "title")
  private String title;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "ID")
  private Category category;
  @Column(name = "price")
  private BigDecimal price;
  @ManyToOne
  @JoinColumn(name = "currency_id", referencedColumnName ="ID" )
  private Currency currency;
  @ManyToOne
  @JoinColumn(name = "country_id", referencedColumnName = "ID")
  private Country country;
  @Column(name = "created_at")
  private Date createdAt;
  @Column(name = "modified_at")
  private Date modifiedAt;

}
