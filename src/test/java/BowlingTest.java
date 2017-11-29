import org.junit.Test;
import parser.StringFrameParser;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by chetan on 25.11.2017.
 */
public class BowlingTest {

    private BowlingGame bowlingGame = new BowlingGame(new StringFrameParser());

    @Test
    public void test_all_strikes() {
        Integer previousScore = bowlingGame.startGame("10|10|10|10|10|10|10|10|10|10,10,10");
        assertThat(previousScore).isEqualTo(300);
    }

    @Test
    public void test_all_spares() {
        Integer previousScore = bowlingGame.startGame("5,5|5,5|5,5|5,5|5,5|5,5|5,5|5,5|5,5|5,5,5");
        assertThat(previousScore).isEqualTo(150);
    }

    @Test
    public void test_mix_of_normal_spare_and_strike_frame() {
        Integer previousScore = bowlingGame.startGame("1,4|4,5|6,4|5,5|10|0,1|7,3|6,4|10|2,8,6");
        assertThat(previousScore).isEqualTo(133);
    }

    @Test
    public void test_all_zeros() {
        Integer previousScore = bowlingGame.startGame("0,0|0,0|0,0|0,0|0,0|0,0|0,0|0,0|0,0|0,0");
        assertThat(previousScore).isEqualTo(0);
    }

    @Test
    public void test_all_ones() {
        Integer previousScore = bowlingGame.startGame("1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1|1,1");
        assertThat(previousScore).isEqualTo(20);
    }

    @Test
    public void test_one_spare() {
        Integer previousScore = bowlingGame.startGame("5,5|3,0|0,0|0,0|0,0|0,0|0,0|0,0|0,0|0,0");
        assertThat(previousScore).isEqualTo(16);
    }

    @Test
    public void test_one_strike() {
        Integer previousScore = bowlingGame.startGame("10|3,4|0,0|0,0|0,0|0,0|0,0|0,0|0,0|0,0");
        assertThat(previousScore).isEqualTo(24);
    }


}
