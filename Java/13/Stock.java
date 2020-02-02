/**
 This class represents Stock.
 @author (Michelle Eden)
 @version (2019a)
 */

public class Stock {
public int noOfItem; // SHAY: Private (-2)
final int MAXARR = 100;
public FoodItem[] _stock;

// constructor
public Stock()
{
    _stock = new FoodItem[MAXARR];
}
 //methods
 //this method sorts and cleans the arr. 
 /**
  * maintains arr without "holes" 
  */
 
 private void CleanArr()  // SHAY: Small letters in methids names (-2)
 {
     FoodItem[] cleanarr;
     cleanarr = new FoodItem[MAXARR];
     int cntr=0;
    
     for(int i=0; i<=noOfItem; i++)
     {
         if(_stock[i] != null)
         {
             cleanarr[cntr]=_stock[i];
             cntr++;
             
         }
         
     }
     noOfItem = cntr;
     _stock = cleanarr;
 }
 
 //returns total number for each item
 /**
  * @return total number of each food item 
  */
 public int getNumOfItems() 
 {
     int i=0;
     int numOfItems=0;
     
     for( i=0; i<_stock.length;i++)
     {
         if(_stock[i]!= null)
         {
             numOfItems = numOfItems + _stock[i].getQuantity();
         }
     }
     return numOfItems;
     
 }
 //adding an item, return true for success
 /**
  * @return true on successfull addition of an item
  */
 
 public boolean addItem(FoodItem newItem) 
 {
   for(int i=0;i<_stock.length;i++)
     { 
       if(_stock[i] == null) {
           _stock[i] = newItem;
           noOfItem++;
           return true;
        } 
         if((_stock[i].getName() == newItem.getName()) && ( _stock[i].getCatalogueNumber() == newItem.getCatalogueNumber()))// maybe different validation method
         {
             if(_stock[i].getExpiryDate() == newItem.getExpiryDate() && _stock[i].getProductionDate() == newItem.getProductionDate()) 
             {
                 _stock[i].setQuantity(_stock[i].getQuantity()+1);
                 noOfItem++;
                 return true;
             } 
                
         }
         
         
     }
     
     return false;
 }
 //string of items to order
 /**
  * @param amount
  * @return orderList - list of items to order
  */
 public String order(int amount) {
     String orderList = "";
     for(int i=0;i<noOfItem;i++)
     {
         if(_stock[i].getQuantity() < amount){
             for(int j = i+1; j<noOfItem; j++)
             {
                 if(_stock[j].getName() == _stock[i].getName() && _stock[j].getCatalogueNumber() == _stock[i].getCatalogueNumber())
                 {
                    if((_stock[i].getQuantity() + _stock[j].getQuantity()) < amount)
                    {
                        orderList = orderList + ", " + _stock[i].getName();
                    }
             }
             
         }
     }
    }
    return orderList;
}
//temprature for each fridge, by the items minimum and maximum temperature
/**
 * @param temp
 * @return goToFridge - items to fridge by their temperature
 */
 public int howMany(int temp){
     int goToFridge = 0;
     for(int i=0;i<noOfItem;i++) {
        if(temp >= _stock[i].getMinTemperature() && temp <= _stock[i].getMaxTemperature()) {
               goToFridge = goToFridge + _stock[i].getQuantity() ;
               
        }   
    }
    return goToFridge;
    }
//removes expired products
/**
 * @param d
 * removes expired products
 */    
  public void removeAfterDate(Date d) {
    for(int i=0;i<noOfItem;i++) {
        if(d.after(_stock[i].getExpiryDate())) { 
             _stock[i] = null;
    }
    }
    CleanArr();
}
//return the most expensive product, or null if there is no
/**
 * 
 * @return maxPrice -  the most expensive product name, or null when there are no items
 */
 public String mostExpensive() {
     if(noOfItem == 0) {
            return "null";
       }
     long maxPrice = _stock[0].getPrice();
     String productName = _stock[0].getName();
    for(int i=1;i<noOfItem;i++) {
        if(_stock[i].getPrice() > maxPrice) {
            maxPrice = _stock[i].getPrice();
            productName = _stock[i].getName();
        }
       
    } 
    return productName;
    }
//total quantity for each product    
 /**
  * @return totalPieces - total quantity for each product
  */   
public int howManyPieces() {
    
         if(noOfItem == 0) {
            return 0;
       }    
       int totalpieces = 0;
    for(int i=0;i<noOfItem;i++) {
        totalpieces = totalpieces + _stock[i].getQuantity();
    }
    return totalpieces;
}

//string of products
/**
 * @return outPut - a printable table of available inventory
 */
public String toString() {
    
    String outPut=""; 
    for(int i=0;i<noOfItem;i++) { 
        // SHAY :Use Item's toString (-3)
        outPut = outPut + "FoodItem: " + _stock[i].getName() + "\t" 
        + "CatalogueNumber:" + _stock[i].getCatalogueNumber() + "\t"
        + "ProductionDate :" + _stock[i].getProductionDate() + "\t"
        + "ExpiryDate :" + _stock[i].getExpiryDate() + "\t"
        + "Quantity:" + _stock[i].getQuantity() + "\n";
    }
    return outPut;
}

//update the item list and arr
/**
 * @param itemList
 */
public void updateStock(String[] itemList) {
      for(int i=0;i<itemList.length;i++) {
          for(int j=0;j<noOfItem;j++)
          {
              if(itemList[i] == _stock[j].getName())
              {
                _stock[j].setQuantity(_stock[j].getQuantity()-1);
                if(_stock[j].getQuantity()==0)
                {
                    _stock[j] = null;
                }
                }
          }
        }
     CleanArr();
}

//the minimum temperature for each fridge, by al lthe products in the fridge
  /**
   * @return minTemp - the min temperature that suits all the products on the fridge, 
   * or max integer in case there is none 
   */  
  public int getTempOfStock() {
      int minTemp=0;
      int maxTemp=0;
   if(noOfItem == 0) {
            return Integer.MAX_VALUE;
       }
     maxTemp = _stock[0].getMaxTemperature();
     minTemp = _stock[0].getMinTemperature();
    for(int i=1;i<noOfItem;i++) {
        if(_stock[i].getMinTemperature() >
        minTemp && _stock[i].getMaxTemperature() > maxTemp) {
            minTemp = _stock[i].getMinTemperature();
            maxTemp = _stock[i].getMaxTemperature();
            return minTemp;
            
        }
       
    } 
        return minTemp;
        
    } 
}
       // SHAY: Correct
      
   
   
    
    

    
 
    
    
