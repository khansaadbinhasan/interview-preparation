package designPattern;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.*;

public class MVCPattern {

    public class StoreOrder extends Observable{

        private ArrayList<String> itemList;
        private ArrayList<BigDecimal> priceList;

        public StoreOrder(){
            itemList = new ArrayList<>();
            priceList = new ArrayList<>();
        }

        public String getItem( int itemNum ){
            return itemList.get(itemNum);
        }

        public BigDecimal getPrice( int itemNum ){
            return priceList.get(itemNum);
        }

//        public ListIterator<String> getItemList(){
//            return itemList.listIterator();
//        }
//
//        public ListIterator<BigDecimal> getPriceList(){
//            return priceList.listIterator();
//        }

        public ArrayList getItemList(){
            return itemList;
        }

        public ArrayList getPriceList(){
            return priceList;
        }

        public void deleteItem(int itemNum){
            itemList.remove(itemNum);
            priceList.remove(itemNum);
            setChanged();
            notifyObservers();
        }

        public void addItem( int barcode ){
            //code to add item
            //prices looked up from db

            setChanged();
            notifyObservers();
        }

        public void changePrice( int itemNum, BigDecimal newPrice ){
            priceList.set(itemNum, newPrice);
            setChanged();
            notifyObservers();
        }
    }


    public class OrderView extends JPanel implements Observer, ActionListener{

        private OrderController controller;

        private JFrame frame;
        private JButton changedPriceButton;
        private JButton deleteItemButton;
        private JTextField newPriceField;
        private JLabel totalLabel;
        private JTable groceryList;

        private void createUI(){
            deleteItemButton = new JButton("Delete Item");
            add(deleteItemButton);

            deleteItemButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if( actionEvent.getSource() == deleteItemButton ){
                controller.deleteItem(groceryList.getSelectedRow());
            }

            else if(actionEvent.getSource() == changedPriceButton){
                BigDecimal newPrice = new BigDecimal(newPriceField.getText());
                controller.changePrice(groceryList.getSelectedRow(), newPrice);
            }
        }

        @Override
        public void update(Observable observable, Object o) {
            display(    ((StoreOrder) observable).getItemList(),
                        ((StoreOrder) observable).getPriceList() );
        }

        public OrderView(OrderController controller){
            this.controller = controller;
            createUI();
        }

        public void display( ArrayList itemList, ArrayList priceList ){

        }

    }


    public class OrderController{
        private StoreOrder storeOrder;
        private OrderView orderView;

        public OrderController(StoreOrder storeOrder, OrderView orderView){
            this.storeOrder = storeOrder;
            this.orderView = orderView;
        }

        public void deleteItem( int itemNum ){
            storeOrder.deleteItem(itemNum);
        }

        public void changePrice( int itemNum, BigDecimal newPrice ){
            storeOrder.changePrice(itemNum, newPrice);
        }
    }

}
