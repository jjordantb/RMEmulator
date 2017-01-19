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
        int[] ints = new int[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            ints[i - 1] = Integer.valueOf(args[i]);
        }
        final Emulator emulator = new Emulator(ints);
        emulator.load(file);
        emulator.run();
    }

}
