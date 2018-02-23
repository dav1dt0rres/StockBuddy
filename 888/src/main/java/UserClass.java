import yahoofinance.Stock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserClass {

    ArrayList<Logic> HistoryLookup;
    ArrayList<Logic> PurchaseHistory;
    ArrayList<Logic>openPositions;
    ArrayList<Logic> WatchList;
    String Name;
    Integer ID;

    public UserClass(String name, Integer id){
        this.HistoryLookup = new ArrayList<Logic>();
        this.PurchaseHistory=new ArrayList<Logic>();

        this.Name=name;
        this.ID=id;

    }
    public UserClass(String name,Integer id,ArrayList<Logic> hislook, ArrayList<Logic> purcHist,ArrayList<Logic> openPos){
        this.HistoryLookup = new ArrayList<Logic>();

        this.PurchaseHistory=new ArrayList<Logic>();
        this.HistoryLookup=hislook;
        this.PurchaseHistory=purcHist;
        this.Name=name;
        this.ID=id;


    }



   public void addToPurchaseHistory(Logic tempStock,String quantity ){
        for (Logic element : this.PurchaseHistory){
            if (tempStock.getSymbol().equals(element.getSymbol())){
                element.incrementCount();
                element.purchase_at_Price(quantity);

            }

        }
        tempStock.incrementCount();
        tempStock.purchase_at_Price(quantity);
        this.PurchaseHistory.add(tempStock);

    }
    public int addtoLookupHistory(Logic tempStock,String symbol){
       for (Logic element:this.PurchaseHistory){
           if (element.getSymbol().equals(symbol)){
                element.incrementCount();
                return 1;
           }

       }
       tempStock.incrementCount();
       this.PurchaseHistory.add(tempStock);
        return 0;


    }
    public void addtoOpenPositions(Logic tempStock,String x){//Second argument is the a string detailing the quantity of stock
        tempStock.purchase_at_Price(x);



    }
    //public float take_of_position(Logic tempStock,String x){
        //tempStock.


    //}
    public ArrayList<Logic> getHistoryLookup(){
        System.out.println ("lookup history"+this.HistoryLookup);
        return this.HistoryLookup;
    }
    public ArrayList<Logic> getPurchaseHistory(){
        for(Logic element: this.PurchaseHistory) {
            System.out.println("Symbol of stock" + element.getSymbol());
            System.out.println("Price of Open position" + element.getPrice());
            System.out.println("Quantity of Open position" + element.getQuantity());

        }
        return this.PurchaseHistory;
    }




}
