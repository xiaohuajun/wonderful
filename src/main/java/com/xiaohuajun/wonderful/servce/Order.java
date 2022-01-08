package com.xiaohuajun.wonderful.servce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * @author xiaohuajun
 * @version 1.0
 * @date 2022/1/4 下午4:06
 * @description Order
 */
@Data
public class Order {

  private BigDecimal surplusAmountInit;


  public static void main(String[] args) {

    List<Order> orders = new ArrayList<>();
    Order order = new Order();
    BigDecimal bigDecimal1 = new BigDecimal("10.50");
    order.setSurplusAmountInit(bigDecimal1);
    orders.add(order);

    Order order1 = new Order();
    BigDecimal bigDecimal2 = new BigDecimal("5.50");
    order.setSurplusAmountInit(bigDecimal2);
    orders.add(order1);

  }

}
