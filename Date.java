//Jami Biddle: jkb115
//Homework 1

//Starts this class
public class Date {
  //initializes the two most important fields, one for day and one for month.
  int day;
  int month;
  
  
  //the constructor for this class, with input of day and month. no output
  public Date(int inday, int inmonth) {
    //makes sure the date is valid, only changes it if it is
    if (inday >= 1 && inday <= 31)
      this.day = inday;
     //makes sure the date is valid, only changes it if it is
    if (inmonth >= 1 && inmonth <= 12)
      this.month = inmonth;
  }
  
  //gets the day
  public int getDay() {
    return this.day;
  }
  
  //gets the month
  public int getMonth() {
    return this.month;
  }
  
  //Adds the day, looping around  if it's past 31 days, and looping the month if it's past 12 months
  public void incrementDay(){
    this.day += 1;
    if (this.day > 31) {
      this.day = 1;
      this.month += 1;
      if (this.month > 12)
        this.month = 1;
    }
  }
 
  //overrides the bool method equals. returns true only when the two dates are the same.
  public boolean equals(Date a, Date b) {
    if (a.getDay() == b.getDay() && a.getMonth() == b.getMonth()) {
      return true;
    }
    else
      return false;
  }
  
  //prints a pretty version of the date (one with text, in english format, as a string)
  public String toString() {
    String dateString = "Today is the " + this.day + "th, in the " + this.month + "th month.";
    return dateString;
  }
  
}