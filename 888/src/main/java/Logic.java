import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Logic {

        String symbol;
        BigDecimal  buyprice;
        BigInteger Quantity;
        String Name;
        Stock stock;
        Integer Count;

        //File
        public Logic(String Tempname) {
           this.Name=Tempname; ///For now has to be tickers and not full names.
            this.buyprice= new BigDecimal(0);
           this.Quantity= new BigInteger("0");
            Count=0;
            try{
              //stock = new Stock(Name);
                stock=YahooFinance.get(Name);


            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }

        }

        public String getName(){
            return Name;
        }
        public void purchase_at_Price(String x){

            this.buyprice=stock.getQuote().getPrice();
            BigDecimal average=this.buyprice.add(stock.getQuote().getPrice());
            average.divide(new BigDecimal("2"));
            this.buyprice=average;

            this.Quantity=this.Quantity.add(new BigInteger(x));



        }
        public void sell_at_Price(String x){
          BigInteger Temp =new BigInteger(x);
          BigDecimal difference=this.buyprice.subtract(this.stock.getQuote().getPrice());
          BigInteger quantDifference=this.Quantity.subtract(Temp);
         // if (quantDifference.compareTo(new BigInteger("0"))>0)//If you sold more than you had, you have entered a short position





        }
        //public BigDecial Profit(){



        //}
        public String getSymbol(){

          return stock.getSymbol();

        }
        public BigDecimal getPrice(){
            BigDecimal price = stock.getQuote().getPrice();

            return price;
        }
        public BigInteger getQuantity(){
            return this.Quantity;

        }
        public void getinformation(){
            stock.print();
            BigDecimal change = stock.getQuote().getChangeInPercent();
            System.out.println ("change in percent"+change);
            BigDecimal peg = stock.getStats().getPeg();
            System.out.println ("Peg"+peg);
            BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
            System.out.println ("Dividend annlu yield percent"+dividend);

        }
        public void getHistory(){

            try {
                System.out.println(stock.getHistory());
            }
            catch(Exception e) {
                throw new RuntimeException(e);
            }
            }
        public void incrementCount() {
            ++Count;
        }





        }




