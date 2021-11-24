package Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Scope(value = "prototype")
public class Robot implements Gamer{
    private final int number;
    private int max = 100;
    private int min = 1;

    public Robot(int number) {
        this.number = number;
    }

    public boolean startRobot() {
        return checkNum();
    }

    private int robotNum(int numMin, int numMax) {
        return (int) (Math.random() * (numMax + 1 - numMin) + numMin);
    }


    private boolean checkNum() {
        int robores;
        robores = robotNum(min, max);
        if (robores < number) {
            min = robores;
        } else if (robores > number) {
            max = robores;
        } else if (robores == number) return true;
        System.out.println("Робот не угадал!");
        return false;
    }

    @Override
    public boolean play() {
        return startRobot();
    }
}
