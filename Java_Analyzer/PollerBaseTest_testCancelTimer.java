package zmq.poll;
// original test path: zeromq_jeromq###zeromq_jeromq/src/test/java/zmq/poll/PollerBaseTest###testCancelTimer
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PollerBaseTest_testCancelTimer {
    private PollerBase poller;

    @Before
    public void setUp() {
        poller = new PollerBase("testPoller");
    }

    @Test
    public void testCancelTimer() {
        // Add a timer to cancel
        IPollEvents sink = new IPollEvents() {
            @Override
            public void onTimeout(int id) {
                // Do nothing
            }
        };
        int id = 1;
        poller.addTimer(1000, sink, id);

        // Cancel the timer
        poller.cancelTimer(sink, id);

        // Verify that the timer was cancelled
        PollerBase.TimerInfo timerInfo = poller.timers.find(new PollerBase.TimerInfo(sink, id));
        assertNotNull(timerInfo);
        assertTrue(timerInfo.cancelled);
    }
}