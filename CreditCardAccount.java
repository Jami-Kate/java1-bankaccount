//Jami Biddle: jkb115
//Homework 1

public class CreditCardAccount {
    //Instance field to track current balance
  public double balance = 0.0;
  
    //Instance field to track interest rate
  public double interestRate;
  
  //Instance field to track the credit limit
  public int creditLimit;
  
  //Instance field to track the minimum payment
  public int minPayment;
  
  //Instance field to track the late payment penalty
  public int latePaymentPenalty;
  
  //Field to track the needed paymont for the month; linked to getMonthlyPayment (this is how I named the monthlyPayment variable)
  public double neededPayment;
  
  //Field to track money paid so far this month
  public double amountPaid;
  
  //Field to track interest paid so far
  public double interestSoFar;
  
  //field to track if money was paid in full. It starts as true, so that the first month wouldn't charge interest.
  public boolean paidInFull = true;
  
  //Contructor 1: use the account w/ all default values
  public CreditCardAccount() {
  }
  
  //Contructor 2: Allows 4 intputs so set up an account w/ several inputs
  public CreditCardAccount(int creditLimit, Double interestRate, int minPayment, int latePaymentPenalty) {
    this.creditLimit = creditLimit;
    this.interestRate = interestRate;
    this.minPayment = minPayment;
    this.latePaymentPenalty = latePaymentPenalty;
  }
  
  //Method to get the current balance: no input, outputs double
  public double getBalance() {
    return balance;
  }
  
    //Method to get the current interest rate
  public Double getInterestRate() {
    return interestRate;
  }
  
  //Method to change the Interest Rate
  public void setInterestRate(Double newInterestRate) {
    this.interestRate = newInterestRate;
  }
  
  //Method to get the late Payment Penalty
  public int getLatePayPenalty() {
    return latePaymentPenalty;
  }
  
  //Method to change the Late Penalty
  public void setLatePayPenalty(int newPenalty) {
    this.latePaymentPenalty = newPenalty;
  }
  
   //Method to get the credit limit
  public int getCreditLimit() {
    return this.creditLimit;
  }
  
  //Method to change the credit limit 
  public void setCreditLimit(int newCreditLimit) {
    this.creditLimit = newCreditLimit;
  }
  
  //Method to get the min monthly payment
  public int getMinPayment() {
    return this.minPayment;
  }
  
  //Method to change the min monthly payment
  public void setMinPayment(int newMinPayment) {
    this.minPayment = newMinPayment;
  }
  
  //Returns the needed Payment for the month
  public Double getMonthlyPayment() {
    return this.neededPayment;
  }
  
  //Method to charge money to the credit card account (i.e. when someone uses the credit card)
  public boolean charge(Double charge) {
    if (this.getCreditLimit() >= (this.getBalance() + charge)){
      this.balance = this.getBalance() + charge;
      return true;
    }
    else{
      return false;
    }
  }
  
  //method to add a payment, i.e. when someone pays back credit card debt
  public void payment(Double payment) {
    this.balance = this.getBalance() - payment;
    this.amountPaid += payment;
  }
  
    //The increment day method. FLags overdraft fee when account gets too low, else computes interest by day.
  public void incrementDay() {
    double sum = 0;
    if (this.paidInFull == false)
      sum = (this.getBalance() + this.interestSoFar);
      this.interestSoFar = sum * (this.getInterestRate() / 365);
  }
  
  //Increment month: adds interest acrued to the balance, accounts of the paid in full flag. adds the late payment penalty if required.
  public void incrementMonth() {
    this.balance = this.getBalance() + this.interestSoFar;
    this.interestSoFar = 0;
    if (this.amountPaid >= this.getMinPayment())
      this.paidInFull = true;
    else
      this.paidInFull = false;
    if (this.amountPaid < this.getMinPayment() && this.getMinPayment() < this.getMonthlyPayment())
      this.balance = this.getBalance() + this.latePaymentPenalty;
    this.amountPaid = 0;
    this.neededPayment = this.getBalance();
      
  }
  
}