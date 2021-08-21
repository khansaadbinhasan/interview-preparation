package designPattern;

public class StatePattern {

    public class VendingMachine{
        private State idleState;
        private State hasOneDollarState;
        private State outOfStockState;

        private State state;
        private int count;

        public VendingMachine(int count){
            idleState = new IdleState();

            if( count > 0 ){
                state = idleState;
                this.count = count;
            }

            else {
                state = outOfStockState;
                this.count = 0;
            }
        }

        public State getIdleState() {
            return idleState;
        }

        public void setIdleState(State idleState) {
            this.idleState = idleState;
        }

        public State getHasOneDollarState() {
            return hasOneDollarState;
        }

        public void setHasOneDollarState(State hasOneDollarState) {
            this.hasOneDollarState = hasOneDollarState;
        }

        public State getOutOfStockState() {
            return outOfStockState;
        }

        public void setOutOfStockState(State outOfStockState) {
            this.outOfStockState = outOfStockState;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void insertDollar(){
            state.insertDollar(this);
        }

        public void ejectMoney(){
            state.ejectMoney(this);
        }

        public void dispense(){
            state.dispense(this);
        }

        public void doReturnMoney() {
            System.out.println("Return money");
        }

        public void doReleaseProduct() {
            System.out.println("Releasing Product");
        }
    }

    public interface State{
        public void insertDollar(VendingMachine vendingMachine);
        public void ejectMoney(VendingMachine vendingMachine);
        public void dispense(VendingMachine vendingMachine);
    }

    public class IdleState implements State {
        public void insertDollar(VendingMachine vendingMachine) {
            System.out.println("Dollar inserted");

            vendingMachine.setState(vendingMachine.getHasOneDollarState());
        }

        public void ejectMoney(VendingMachine vendingMachine) {
            System.out.println("No Money to return");
        }

        public void dispense(VendingMachine vendingMachine) {
            System.out.println("Payment required");
        }
    }

    public class HasOneDollar implements State{
        public void insertDollar(VendingMachine vendingMachine) {
            System.out.println("Already have one dollar");

            vendingMachine.doReturnMoney();
            vendingMachine.setState(vendingMachine.getIdleState());
        }

        public void ejectMoney(VendingMachine vendingMachine) {
            System.out.println("returning money");

            vendingMachine.doReturnMoney();
            vendingMachine.setState(vendingMachine.getIdleState());
        }

        public void dispense(VendingMachine vendingMachine) {
            System.out.println("Releasing product");

            if( vendingMachine.getCount() > 1 ){
                vendingMachine.doReleaseProduct();

                vendingMachine.setState(vendingMachine.getIdleState());
            }

            else {
                vendingMachine.doReleaseProduct();
                vendingMachine.setState(vendingMachine.getOutOfStockState());
            }
        }
    }
}
