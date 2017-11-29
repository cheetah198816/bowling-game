package parser;

import pojo.Frame;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by chetan on 25.11.2017.
 */
public class StringFrameParser {

    private static final String DELIMITER_FRAME = "|";

    private static final String DELIMITER_BALLS = ",";

    private StringTokenizer stringTokenizerFrame;

    private StringTokenizer stringTokenizerBalls;

    public List<Frame> parseStringFrames(String frames) {
        final List<Frame> frameList = new ArrayList<>();
        stringTokenizerFrame = new StringTokenizer(frames, DELIMITER_FRAME);
        while (stringTokenizerFrame.hasMoreTokens()) {
            final String balls = stringTokenizerFrame.nextToken();
            final List<Integer> ballsList = new ArrayList<>();
            stringTokenizerBalls = new StringTokenizer(balls, DELIMITER_BALLS);
            while (stringTokenizerBalls.hasMoreTokens()) {
                Integer ball = Integer.parseInt(stringTokenizerBalls.nextToken());
                ballsList.add(ball);
            }
            final Frame frame = new Frame(ballsList);
            frameList.add(frame);
        }
        return frameList;
    }
}
