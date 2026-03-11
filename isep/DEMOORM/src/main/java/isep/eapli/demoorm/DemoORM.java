package isep.eapli.demoorm;

import isep.eapli.demoorm.presentation.MainMenu;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DemoORM {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        MainMenu.mainLoop();
    }
}
