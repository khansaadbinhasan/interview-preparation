package designPattern;

public class AdapterPattern {

    public interface CoffeeMachineInterface {
        public void chooseFirstSelection();
        public void chooseSecondSelection();
    }


    public class OldCoffeeMachine {

        public void selectA(){
            System.out.println("A Selected");
        }

        public void selectB(){
            System.out.println("B Selected");
        }
    }

    public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {
        private OldCoffeeMachine oldVendingMachine = new OldCoffeeMachine();

        public void chooseFirstSelection(){
            this.oldVendingMachine.selectA();
        }

        public void chooseSecondSelection(){
            this.oldVendingMachine.selectB();
        }
    }


}
