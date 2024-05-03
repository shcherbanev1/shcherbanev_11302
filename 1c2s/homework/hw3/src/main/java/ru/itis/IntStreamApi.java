package ru.itis;

public class IntStreamApi extends StreamApi<Integer> {

    public IntStreamApi(Integer[] array) {
        super(array);
    }

    public Double sum() {
        double sum = 0.0;
        for (Integer item : data) {
            sum += item.doubleValue();
        }
        return sum;
    }

    public Double avg() {
        if (data.length == 0) {
            return 0.0;
        }
        double sum = 0.0;
        for (Integer item : data) {
            sum += item.doubleValue();
        }
        return sum / data.length;
    }

}
