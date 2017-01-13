package emu.insns;

import emu.Emulator;

/**
 * Created by jorda on 1/13/2017.
 */
public class IncInsn extends AbstractInsn {

    public static final String ID = "INC";

    private final int register, jumpIndex;

    public IncInsn(final int register, final int jumpIndex) {
        this.register = register;
        this.jumpIndex = jumpIndex;
    }

    @Override
    public void process(Emulator emulator) {
        emulator.setCurrentRegister(emulator.getRegister(this.register - 1) + 1);
        emulator.setProgramCounter(this.jumpIndex);
    }
}