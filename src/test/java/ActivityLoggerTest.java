
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ActivityLoggerTest {

    private ActivityLogger logger;

    @BeforeEach
    public void setUp() {
        logger = new ActivityLogger();
    }

    @Test
    public void testLogActivity() {
        Date date = Date.valueOf("2023-10-01");
        logger.logActivity(date, 5);
        assertTrue(logger.logs.containsKey(date));
        assertEquals(Optional.of(5), Optional.of(logger.logs.get(date)));
    }

    @Test
    public void testDisplayLogs() {
        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000);
        logger.logActivity(date1, 5);
        logger.logActivity(date2, 3);
        logger.displayLogs();
        // This test will just ensure no exceptions are thrown during display
    }

    @Test
    public void testCountLast7() {
        Date date1 = new Date(System.currentTimeMillis());
        Date date2 = new Date(System.currentTimeMillis() - 7 * 24 * 60 * 60 * 1000);
        logger.logActivity(date1, 5);
        logger.logActivity(date2, 3);
        logger.countLast7();
        // This test will just ensure no exceptions are thrown during count
    }
}