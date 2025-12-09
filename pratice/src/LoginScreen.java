package icp2;

public class LoginScreen implements TextScreen, InteractiveScreen{
    @Override
    public void showText(String text) {
        System.out.println("LOGIN: " + text);
    }
    @Override
    public void handleUserInput(String input) {
        System.out.println("Handling login input: " + input);
    }

}

class  TutorialScreen implements TextScreen, MediaScreen{
    @Override
    public void showText(String text) {
        System.out.println("Tutorial: " + text);
    }
    @Override
    public void showImage(String path) {
        System.out.println("loading video... " + path);
    }
    @Override
    public void playVideo(String path) {
        System.out.println("playing video... " + path);
    }
}


interface TextScreen {
    void showText(String text);
}
interface InteractiveScreen {
    void handleUserInput(String input);
}
interface MediaScreen {
    void showImage(String path);
    void playVideo(String path);
}

class TestScreen {
    public static void main(String[] args) {
        LoginScreen login = new LoginScreen();
        login.showText("Please enter your username");
        login.handleUserInput("user123");


        TutorialScreen tutorial = new TutorialScreen();
        tutorial.showText("Welcome to the tutorial!");
        tutorial.showImage("intro.png");
        tutorial.playVideo("lesson1.mp4");
    }
}

