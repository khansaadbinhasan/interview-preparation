package designPattern;

public class DecoratorPattern {

    public interface WebPage{
        public void display();
    }

    public static class BasicWebPage implements WebPage{

        private String html = "html";
        private String stylesheet = "stylesheet";
        private String script = "script";

        public void display(){
            System.out.println("Basic WebPage");
        }
    }

    public static abstract class WebPageDecorator implements WebPage{
        protected WebPage page;

        public WebPageDecorator(WebPage page){
            this.page = page;
        }

        public void display(){
            this.page.display();
        }
    }

    public static class AuthorizedWebPage extends WebPageDecorator{
        public AuthorizedWebPage(WebPage decoratedPage){
            super(decoratedPage);
        }

        public void authorizedUser(){
            System.out.println("Authorizing User");
        }

        public void display() {
            super.display();
            this.authorizedUser();
        }
    }

    public static class AuthenticatedWebPage extends WebPageDecorator{
        public AuthenticatedWebPage(WebPage page) {
            super(page);
        }

        public void authenticateUser(){
            System.out.println("Authenticating User");
        }

        public void display() {
            super.display();
            this.authenticateUser();
        }
    }

    public static void main(String[] args) {
        WebPage myPage = new BasicWebPage();

        myPage = new AuthorizedWebPage(myPage);
        myPage = new AuthenticatedWebPage(myPage);

        myPage.display();
    }



}
