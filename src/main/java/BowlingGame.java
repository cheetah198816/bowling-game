import parser.StringFrameParser;
import pojo.Frame;

import java.util.List;

/**
 * Created by chetan on 25.11.2017.
 */
public class BowlingGame {

    private StringFrameParser stringFrameParser;

    private List<Frame> framesPlayedList;

    private Integer previousScore = 0;

    public BowlingGame(final StringFrameParser stringFrameParser) {
        this.stringFrameParser = stringFrameParser;
    }

    public Integer startGame(String framesPlayed) {
        framesPlayedList = stringFrameParser.parseStringFrames(framesPlayed);
        framesPlayedList.stream().forEach(frame -> calculateScore(frame));
        return previousScore;
    }

    private void calculateScore(Frame frame) {
        final Integer sumOfPinsInFrame = getSumOfPinsInFrame(frame, 3);
        final Integer currentFrameIndex = framesPlayedList.indexOf(frame);
        if (checkNormalFrameOrLastFrame(sumOfPinsInFrame, currentFrameIndex)) {
            previousScore += sumOfPinsInFrame;
            System.out.println("Frame Number " + (currentFrameIndex + 1) + " Score : " + previousScore);
        } else if (checkStrikeFrame(frame, sumOfPinsInFrame)) {
            previousScore += 10 + getSumOfPinsInFrame(framesPlayedList.get(currentFrameIndex + 1), 2);
            if (checkNextFrameIsStrike(currentFrameIndex + 1)) {
                previousScore += getBonusOfOneExtraBall(currentFrameIndex + 2);
            }
            System.out.println("Frame Number " + (currentFrameIndex + 1) + " Score : " + previousScore);
        } else if (checkSpareFrame(sumOfPinsInFrame)) {
            previousScore += 10 + getBonusOfOneExtraBall(currentFrameIndex + 1);
            System.out.println("Frame Number " + (currentFrameIndex + 1) + " Score : " + previousScore);
        }
    }

    private boolean checkNextFrameIsStrike(Integer frameIndex) {
        return framesPlayedList.get(frameIndex).getNoOfPinsPerBall().size() == 1;
    }

    private Integer getBonusOfOneExtraBall(Integer frameIndex) {
        return framesPlayedList.get(frameIndex).getNoOfPinsPerBall()
                .stream().limit(1)
                .findAny().get();
    }

    private boolean checkSpareFrame(Integer sumOfPinsInFrame) {
        return sumOfPinsInFrame == 10;
    }

    private boolean checkStrikeFrame(Frame frame, Integer sumOfPinsInFrame) {
        return sumOfPinsInFrame == 10 && frame.getNoOfPinsPerBall().size() == 1;
    }

    private boolean checkNormalFrameOrLastFrame(Integer sumOfPinsInFrame, Integer currentFrameIndex) {
        return sumOfPinsInFrame < 10 || (currentFrameIndex == 9);
    }

    private Integer getSumOfPinsInFrame(Frame frame, int limit) {
        return frame.getNoOfPinsPerBall().stream().mapToInt(i -> i).limit(limit).sum();
    }
}
