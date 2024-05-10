package task1;

import java.io.File;
import java.io.IOException;

public abstract class Converter {

    protected File input;

    public Converter(File input, File output) {
        this.input = input;
        this.output = output;
    }

    protected File output;
    public abstract void convert() throws IOException;

}
