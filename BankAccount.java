//Jami Biddle: jkb115
//Homework 1


//Bank Account class declaration
public class BankAccount {
  
  //Instance field to track current balance
  public double balance = 0.0;
  
  //Instance field to track minimum balance in account
  public int minBalance = 0;
  
  //Instance field to track interest rate
  public double interestRate = 0.0;
  
  //Instance field to track atm fees
  public double atmFee = 0.0;
  
  //Instance field to track overdraft fee
  public double overdraftFee = 0.0;
  
  //Instance field to track bouncedCheck fee
  public double bouncedCheckFee = 0.0;
  
  //Instance field to track withdraw fee
  public double withdrawFee = 0.0;
  
  //Instance field to track withdraw limit
  public int withdrawLimit = 0;
  
  //Instance field to track withdraws
  public int withdraws = 0;
  
  //Tracks interest so far this month
  public Double interestSoFar = 0.0;
  
  //Tracks whether overdraft fee has been applied
  public boolean overdraftFlag;
  
  //Contructor 1: use the account w/ all default values
  public BankAccount() {
  }
  
  
  
  //Contructor 2: Allows 5 intputs so set up an account w/ several inputs
  public BankAccount(Double intRate, int minBalance, Double overdraftFee, Double atmFee, Double bouncedCheckFee) {
    this.interestRate = intRate;
    this.minBalance = minBalance;
    this.overdraftFee = overdraftFee;
    this.atmFee = atmFee;
    this.bouncedCheckFee = bouncedCheckFee;
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
  
  //Method to get the current minimum balance
  public int getMinimumBalance() {
    return minBalance;
  }
  
  //Method to change the Minimum balance
  public void setMinimumBalance(int newMinimumBalance) {
    this.minBalance = newMinimumBalance;
  }
  
  //Method to get the current ATM fee
  public double getATMFee() {
    return atmFee;
  }
  
  //Method to change the atm fee
  public void setATMFee(Double newATMFee) {
    this.atmFee = newATMFee;
  }
  
  //Method to get the current overdraft fee
  public double getOverDraftFee() {
    return overdraftFee;
  }
  
  //Method to change the current overdraft fee
  public void setOverDraftFee(double newOverdraftFee) {
    this.overdraftFee = newOverdraftFee;
  }
  
  //Method to get the current bounced check fee
  public double getBouncedCheckFee() {
    return bouncedCheckFee;
  }
  
  //Method to change the bounced check fee 
  public void setBouncedCheckFee(Double newBouncedCheckFee) {
    this.bouncedCheckFee = newBouncedCheckFee;
  }
  
  //Method to get the current withdraw fee
  public Double getWithdrawFee() {
    return withdrawFee;
  }
  
  //Method to change the current withdraw fee
  public void setWithdrawFee(Double newWithdrawFee) {
    this.withdrawFee = newWithdrawFee;
  }
  
  //Method to get the current withdraw limit
  public int getWithdrawLimit() {
    return withdrawLimit;
  }
  
  //Method to change the withdraw limit
  public void setWithdrawLimit(int newWithdrawLimit) {
    this.withdrawLimit = newWithdrawLimit;
  }
  
  //Method to get the current withdraw amount
  public int getWithdraws() {
    return withdraws;
  }
  
  //Method to add a withdraw
  public void addWithdraw() {
    this.withdraws += 1;
  }
  
  //Method to get the current interest so far
  public Double getInterestAccrued() {
    return interestSoFar;
  }
  
  //Method to deposit money in the account
  public void deposit(Double depositAmount) {
    this.balance = (this.getBalance() + depositAmount);
  }
  
  
  //Method to withdraw, if able
  public boolean withdraw(Double withdrawAmount){
    if (this.getBalance() >= withdrawAmount){
      this.balance = (this.getBalance() - withdrawAmount);
      this.addWithdraw();
      if (this.getWithdraws() > this.getWithdrawLimit()) {
        this.balance = (this.getBalance() - this.getWithdrawFee());
      }
      return true;
    }
    else {
      return false; 
    }
  }
  
  //Method withdraws if able, if not applies the bounced check fee.
  public boolean withdrawDraft (Double withdrawAmount) {
    if (this.getBalance() >= withdrawAmount){
      this.balance = (this.getBalance() - withdrawAmount);
      this.addWithdraw();
      if (this.getWithdraws() > this.getWithdrawLimit()) {
        this.balance = (this.getBalance() - this.getWithdrawFee());
      }
      return true;
    }
    else
      this.balance = (this.getBalance()-this.bouncedCheckFee);
      return false;   
  }
  
  //Method withdraws if there is enough for the withdrawal and an atm fee. Else does nothing.
  public boolean withdrawATM(Double withdrawAmount){
    if (this.getBalance() >= (withdrawAmount + this.atmFee)){
      this.balance = (this.getBalance() - withdrawAmount);
      this.addWithdraw();
      if (this.getWithdraws() > this.getWithdrawLimit()) {
        this.balance = (this.getBalance() - this.getWithdrawFee());
      }
      this.balance = (getBalance() - this.atmFee);
      return true;
    }
    else {
      return false; 
    }
  }
  //The increment day method. FLags overdraft fee when account gets too low, else computes interest by day.
  public void incrementDay() {
    double sum = 0;
    if (this.getBalance() < this.getMinimumBalance() && this.overdraftFlag == false){
      this.balance = this.getBalance() - this.getOverDraftFee();
      this.overdraftFlag = true;
    }
    else if (this.getBalance() > getMinimumBalance() && this.overdraftFlag == false)
      sum = this.getBalance() + this.getInterestAccrued();
      this.interestSoFar = sum * (this.getInterestRate() / 365.0);
  }
  
  //Increments the month, applies the interest, then resets the account to be ready for the next month
  public void incrementMonth() {
    this.balance = getBalance() + this.interestSoFar;
    this.interestSoFar = 0.0;
    this.overdraftFlag = false;
  }
}