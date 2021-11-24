package Game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {
    public static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    public static void main(String[] args) {
        try {
            Game game = context.getBean("game", Game.class);
            game.gameLines();
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
