package pojo;

import java.util.List;

/**
 * Created by chetan on 24.11.2017.
 */
public class Frame {

    private final List<Integer> noOfPinsPerBall;

    public Frame(final List<Integer> noOfPinsPerBall) {
        this.noOfPinsPerBall = noOfPinsPerBall;
    }

    public List<Integer> getNoOfPinsPerBall() {
        return noOfPinsPerBall;
    }
}
