import org.junit.Test;
import parser.StringFrameParser;
import pojo.Frame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by chetan on 25.11.2017.
 */
public class StringFrameParserTest {

    @Test
    public void test_parsing_frames_without_delimiter_for_balls() {
        StringFrameParser stringFrameParser = new StringFrameParser();
        List<Frame> frameList = stringFrameParser.parseStringFrames("10|10|10|10|10|10|10|10|10|10,10,10");
        assertThat(frameList.size()).isEqualTo(10);
        assertThat(frameList.get(0).getNoOfPinsPerBall().size()).isEqualTo(1);
    }
}
