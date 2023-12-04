package designPattern;

public class TemplateMethodPattern {

    public static abstract class PastaDish{
        public final void makeRecipe(){
            boilWater();
            addPasta();
            cookPasta();
            drainAndPlate();
            addSauce();
            addProtein();
            addGarnish();
        }

        private void boilWater(){
            System.out.println("Boiling water");
        }

        private void cookPasta(){
            System.out.println("Cooking pasta");
        }

        private void drainAndPlate(){
            System.out.println("Draining and plating");
        }

        protected abstract void addPasta();
        protected abstract void addSauce();
        protected abstract void addProtein();
        protected abstract void addGarnish();
    }

    public static class SpaghettiMeatballs extends PastaDish{
        protected void addPasta(){
            System.out.println("Add Spaghetti");
        }

        protected void addProtein(){
            System.out.println("Add Meatballs");
        }

        protected void addSauce(){
            System.out.println("Add tomato sauce");
        }

        protected void addGarnish(){
            System.out.println("Add pamesan cheese");
        }
    }

    public static class PenneAlfredo extends PastaDish{
        protected void addPasta() {
            System.out.println("Add Penne");
        }

        protected void addSauce() {
            System.out.println("Add Alfredo sauce");
        }

        protected void addProtein() {
            System.out.println("Add Chicken");
        }

        protected void addGarnish() {
            System.out.println("Add Parsley");
        }
    }

    public static void main(String[] args) {

    }

}
