// Exercise 34

package date_25_3_25;

// public class Exercise34 {
    public class Floor {
        // write code here
        private double width;
        private double length;
        
        public Floor(double width, double length){
            this.width = width < 0 ? 0 : width;
            this.length = length < 0 ? 0 : length;
        }
        
        public double getArea(){
            return width * length;
        }
    
    }
    
    public class Carpet {
        private double cost;
        
        public Carpet(double cost){
            this.cost = cost < 0 ? 0 : cost;
        }
        
        public double getCost(){
            return this.cost;
        }
        
    }

    public class Calculator {
        private Floor floor;
        private Carpet carpet;
        
        public Calculator(Floor floor, Carpet carpet){
            this.floor = floor;
            this.carpet = carpet;
        }
        
        public double getTotalCost(){
            return floor.getArea() * carpet.getCost();
        }
    }
// }
