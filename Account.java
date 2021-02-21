//Jami Biddle: jkb115
//Homework 1

//Announces the Class Account
public class Account {
  
  //Field to store the first name
  public String firstName;
  
  //Field to store last name
  public String lastName;
  
  //Field to store address
  public String address;
  
  //Field to store zip code
  public String zipCode;
  
  //Field to store the current date
  public Date currentDate;
  
  //Field to store the address of the savign account
  public BankAccount savings;
  
  //Field to store the address of the checking account
  public BankAccount checkingAccount;
  
  //Initializes the money market account, but doesn't actually create it fully
  public BankAccount moneyMarket;
  
  //Initializes the credit card account
  public CreditCardAccount creditCardAccount;
  
  //Account contructor, with 5 inputs for: 4 strings: first name, last name, address, zip code. Input for a date.
  public Account(String firstName, String lastName, String address, String zipCode, Date currentDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.zipCode = zipCode;
    this.currentDate = currentDate;
  }
    
    //Method to get the first name on an account
  public String getFirstName() {
    return firstName;
  }
  
  //Method to change the first name
  public void setFirstName(String newFirstName) {
    this.firstName = newFirstName;
  }
  
  //Method to reteive the last name
  public String getLastName() {
    return lastName;
  }
  
  //Method to change the last name
  public void setLastName(String newLastName) {
    this.lastName = newLastName;
  }
  
  //method to retrieve the street address
  public String getStreetAddress() {
    return address;
  }
  
  //Method to change the address
  public void setStreetAddress(String newStreetAddress) {
    this.address = newStreetAddress;
  }
  
  //Method to retreive the zipcode
  public String getZipcode() {
    return zipCode;
  }
  
  //method to retreive the zipcode
  public void setZipcode(String newZip) {
    this.zipCode = newZip;
  }
  
  //returns the balance of the savings bank account
  public BankAccount getSavingsAccount() {
    return this.savings;
  }
  
  //Method to change the balance of the savings account
  public void setSavingsAccount(BankAccount newSavings) {
    this.savings = newSavings;
  }
  
   //returns the balance of the checking bank account
  public BankAccount getCheckingAccount() {
    return checkingAccount;
  }
  
  //Method to change the balance of the checking account
  public void setCheckingAccount(BankAccount newChecking) {
    this.checkingAccount = newChecking;
  }
  
   //returns the balance of the money market bank account
  public BankAccount getMoneyMarketAccount() {
    return this.moneyMarket;
  }
  
  //Method to change the balance of the money market account
  public void setMoneyMarketAccount(BankAccount moneyMarketAcct) {
    this.moneyMarket = moneyMarketAcct;
  }
  
  //returns the balance of the credit card account
  public CreditCardAccount getCreditCardAccount() {
    return this.creditCardAccount;
  }
  
  //Method to change the balance of the credit card account
  public void setCreditCardAccount(CreditCardAccount newCreditCard) {
    this.creditCardAccount = newCreditCard;
  }
  
  //Method to set Date
  public void setDate(Date newDate) {
    this.currentDate = newDate;
  }
  
  //Method to get the Date
  public Date getDate() {
    return this.currentDate;
  }
  
  //Method to increment day for each account, and increment the month when necessary
  public void incrementDay(){
    //Step 1
    this.currentDate.incrementDay();
    //step2
    if (this.getSavingsAccount() != null)
      this.getSavingsAccount().incrementDay();
    if (this.getCheckingAccount() != null)
      this.getCheckingAccount().incrementDay();
    if (this.getMoneyMarketAccount() != null)
      this.getMoneyMarketAccount().incrementDay();
    if (this.getCreditCardAccount() != null)
      this.getCreditCardAccount().incrementDay();
   //step 3
    if (this.getDate().getDay() == 1) {
      
      if (this.getSavingsAccount() != null)
        this.getSavingsAccount().incrementMonth();
      if (this.getCheckingAccount() != null)
        this.getCheckingAccount().incrementMonth();
      if (this.getMoneyMarketAccount() != null)
        this.getMoneyMarketAccount().incrementMonth();
      if (this.getCreditCardAccount() != null)
        this.getCreditCardAccount().incrementMonth();
    }
    
    }
  
  //override of the equals method, compares two accounts.
  public boolean equals(Account a, Account b) {
    if ((a.getFirstName().equals(b.getFirstName())) && (a.getLastName().equals(b.getLastName())) && (a.getStreetAddress().equals(b.getStreetAddress())) && (a.getZipcode().equals(b.getZipcode())))
      return true;
    else
      return false;
  }
  
//Override of the toString method, to print out the account information
  public String toString(Account a) {
    StringBuilder s = new StringBuilder();
    s.append((a.getFirstName()) + " " + (a.getLastName()) + ", " + (a.getStreetAddress()) + ".");
    if (this.getSavingsAccount() != null)
      s.append(" Savings: " + a.getSavingsAccount().getBalance());
    if (this.getCheckingAccount() != null)
      s.append(" Checking: " + a.getCheckingAccount().getBalance());
    if (this.getMoneyMarketAccount() != null)
      s.append(" Money Market Balance: " + a.getMoneyMarketAccount().getBalance());
    if (this.getCreditCardAccount() != null)
      s.append(" Credit Card Account: " + a.getCreditCardAccount().getBalance());
    return s.toString();
  }

    
}