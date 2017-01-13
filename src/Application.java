import emu.Emulator;

import java.io.*;

/**
 * Created by jorda on 1/13/2017.
 */
public class Application {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.exit(1);
        }
        final File file = new File(args[0]);
        final Emulator emulator = new Emulator();
        emulator.load(file);
        emulator.run();
    }

}
