package Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class Game {
    private List<Gamer> list = new ArrayList<>();
    private Man man;
    private Robot robot;
    private int randomNun;
    private String path = "C:\\Users\\Rodya\\Desktop\\MyGame\\src\\Game\\logplayers.txt";
    private BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));

    public Game() throws IOException {
    }


    public void gameLines() throws InterruptedException, IOException {
        Thread.sleep(500);
        System.out.println("Добрый день!");
        Thread.sleep(1000);
        System.out.println("Давай сыграем в игру!");
        Thread.sleep(1000);
        System.out.print("Введи свое имя: ");
        randomNun = (int) (Math.random() * 100);
        list.add((Man) Main.context.getBean("man", setName(), randomNun));
        list.add((Robot) Main.context.getBean("robot", randomNun));
        boolean f = true;
        while (f) {
            for (Gamer g : list) {
                if (g instanceof Man && g.play()) {
                    System.out.println("Вы победили! Мои поздравления!");
                    f=false;
                    break;
                } else if (g instanceof Robot && g.play()) {
                    System.out.println("Робот победил! Очень жаль!");
                    f=false;
                    break;
                }
            }
        }
    }


    private String setName() throws IOException {
        String name;
        while (true) {
            name = new Scanner(System.in).nextLine();
            if (!name.equalsIgnoreCase("")) {
                writer.write("\n" + name);
                writer.close();
                break;
            } else System.out.print("Введи свое имя: ");
        }
        return name;
    }
}
