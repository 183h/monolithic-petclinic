package org.springframework.samples.petclinic.activemq;

import java.time.LocalDate;

public class TaskCreated {

  private LocalDate paymentDate;
  private int cost;


  public TaskCreated(LocalDate paymentDate, int cost) {
    this.paymentDate = paymentDate;
    this.cost = cost;
  }

  public TaskCreated(){

  }

  public LocalDate getPaymentDate() {
    return paymentDate;
  }

  public int getCost() {
    return cost;
  }

  public void setPaymentDate(LocalDate paymentDate) {
    this.paymentDate = paymentDate;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}
