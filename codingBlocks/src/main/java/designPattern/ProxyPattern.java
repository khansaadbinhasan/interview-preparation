package designPattern;

import java.util.*;

public class ProxyPattern {
//
//    public interface IOrder{
//        public void fulfillOrder(IOrder order);
//    }
//
//    public class Warehouse implements IOrder{
//        private Hashtable<String, Integer> stock;
//        private String address;
//
//        public Warehouse(String address){
//            this.address = address;
//            this.stock = new Hashtable<>();
//        }
//
//        public void fulfillOrder(IOrder order) {
//            for(Item item: order.itemList){
//                this.stock.replace(item.sku, stock.get(item)-1);
//            }
//        }
//
//        public int currentInventory(Item item){
//            if( stock.containsKey(item.sku) )
//                return stock.get(item.sku).intValue();
//            return 0;
//        }
//    }
//
//    public class OrderFulfillment implements IOrder{
//        private List<Warehouse> warehouses;
//
//        public OrderFulfillment(){
//            warehouses = new ArrayList<>();
//        }
//
//        public void fulfillOrder(IOrder order) {
//
//            for(Item item: order.itemList){
//                for(Warehouse warehouse: warehouses){
//
//                }
//            }
//        }
//    }
//
}
