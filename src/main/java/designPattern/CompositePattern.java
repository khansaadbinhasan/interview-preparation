package designPattern;

import java.util.*;

public class CompositePattern {

    public interface IStructure{
        public void enter();
        public void exit();
        public void location();
        public String getName();
    }

    public static class Housing implements IStructure{

        private String address;
        private ArrayList<IStructure> structures;

        public Housing(String address){
            this.address = address;
            this.structures = new ArrayList<>();
        }

        public void enter() {
            System.out.println("You entered the house" + this.getName());
        }

        public void exit() {
            System.out.println("You exited the house" + this.getName());
        }

        public void location() {
            System.out.println("You are currently in: " + this.getName());
            System.out.println("Structures:");
            this.structures.forEach(val -> System.out.println(val.getName()));
        }

        public String getName() {
            return this.address;
        }

        public int addStructure(IStructure structure){
            this.structures.add(structure);
            return this.structures.size()-1;
        }

        public IStructure getStructure(int id){
            return this.structures.get(id);
        }
    }

    public static class Room implements IStructure{
        private String name;

        public Room(String name){
            this.name = name;
        }

        public void enter() {
            System.out.println("You entered the house " + this.getName());
        }

        public void exit() {
            System.out.println("You exited the house " + this.getName());
        }

        public void location() {
            System.out.println("This is the lcoation of the house" + this.getName());
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Housing building = new Housing("411 Baker Street");
        Housing floor1 = new Housing("411 Baker Street - First Floor");
        int firstFloor = building.addStructure(floor1);

        Room washroom1m = new Room("1F Men's washroom");
        Room washroom1w = new Room("2F WoMen;s washroom");
        Room common1 = new Room("Common Area");

        int firstMens = floor1.addStructure(washroom1m);
        int firstWoMens = floor1.addStructure(washroom1w);
        int firstCommon = floor1.addStructure(common1);

        building.enter();
        Housing currentFloor = (Housing) building.getStructure(firstFloor);
        currentFloor.enter();

        Room currentRoom = (Room) currentFloor.getStructure(firstMens);
        currentRoom.enter();

        currentRoom = (Room) currentFloor.getStructure(firstCommon);
        currentRoom.enter();
    }

}
