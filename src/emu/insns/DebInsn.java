package emu.insns;

import emu.Emulator;

/**
 * Created by jorda on 1/13/2017.
 */
public class DebInsn extends AbstractInsn {

    public static final String ID = "DEB";

    private final int register, jumpIndex1, jumpIndex2;

    public DebInsn(final int register, final int jumpIndex1, final int jumpIndex2) {
        this.register = register;
        this.jumpIndex1 = jumpIndex1;
        this.jumpIndex2 = jumpIndex2;
    }

    @Override
    public void process(Emulator emulator) {
        final int curVal;
        if ((curVal = emulator.getRegister(this.register)) > 0) {
            emulator.setRegister(this.register, curVal - 1);
            emulator.setProgramCounter(this.jumpIndex1);
        } else {
            emulator.setProgramCounter(this.jumpIndex2);
        }
    }
}
