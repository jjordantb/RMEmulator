package emu;

import emu.insns.AbstractInsn;
import emu.insns.DebInsn;
import emu.insns.HaltInsn;
import emu.insns.IncInsn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorda on 1/13/2017.
 */
public class Emulator {

    private final List<Integer> registers; // indexed 1 to size - 1

    private final List<AbstractInsn> insnList; // indexed 1 to size - 1
    private int programCounter = 1;


    public Emulator(final int... ints) {
        this.insnList = new ArrayList<>();
        this.registers = new ArrayList<>();
        for (Integer i : ints) {
            this.registers.add(i);
        }
    }

    public void load(final File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(IncInsn.ID) || line.contains(DebInsn.ID) || line.contains(HaltInsn.ID)) {
                    if (line.contains("//")) {
                        line = line.substring(0, line.indexOf("//") - 1);
                    }
                    final String[] values = line.contains(" ") ? line.split(" ") : new String[]{line};
                    if (values[0].equals(IncInsn.ID)) {
                        insnList.add(new IncInsn(Integer.valueOf(values[1]), Integer.valueOf(values[2])));
                    } else if (values[0].equals(DebInsn.ID)) {
                        insnList.add(new DebInsn(Integer.valueOf(values[1]), Integer.valueOf(values[2]), Integer.valueOf(values[3])));
                    } else if (values[0].equals(HaltInsn.ID)) {
                        insnList.add(new HaltInsn());
                    } else {
                        System.out.println("Invalid instruction: " + values[0]);
                        System.exit(1);
                    }
                } else {
                    this.insnList.add(null);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String regTitle = "";
        for (int i = 1; i <= this.registers.size(); i++) {
            regTitle += ("Register " + i + ", ");
        }
        regTitle = regTitle.substring(0, regTitle.length() - 2);
        System.out.println(regTitle);
        while (!(this.insnList.get(this.programCounter - 1) instanceof HaltInsn)) {
            final AbstractInsn insn;
            if ((insn = this.insnList.get(this.programCounter - 1)) != null) {
                insn.process(this);
            } else {
                this.programCounter++;
                continue;
            }

            System.out.println();
            String regVal = "";
            for (Integer i : this.registers) {
                regVal += (i);
                for (int j = 0; j < (10 - String.valueOf(i).length()); j++) {
                    regVal += " ";
                }
                regVal += ", ";
            }
            regVal = regVal.substring(0, regVal.length() - 2);
            System.out.println(regVal);
        }
        System.out.println("Complete!");
    }

    public int getRegister(final int index) {
        return this.registers.get(index - 1);
    }

    public void setRegister(final int index, final int value) {
        this.registers.set(index - 1, value);
    }

    public void setProgramCounter(int programCounter) {
        this.programCounter = programCounter;
    }

}
