package net.sf.jabref.logic.statistics;

import static org.junit.Assert.*;

import org.junit.Test;


public class EntryTypeStatisticTest {


    @Test
    public void testConstructor() {
        EntryTypeStatistic stats = new EntryTypeStatistic("article");
        assertEquals("article", stats.getType());
        assertEquals(0, stats.getTotalCount());
        assertEquals(0, stats.getCompleteCount());
    }

    @Test
    public void testIncrement() {
        EntryTypeStatistic stats = new EntryTypeStatistic("article");
        stats.increaseTotalCount();
        assertEquals("article", stats.getType());
        assertEquals(1, stats.getTotalCount());
        assertEquals(0, stats.getCompleteCount());
        stats.increaseCompleteCount();
        assertEquals("article", stats.getType());
        assertEquals(1, stats.getTotalCount());
        assertEquals(1, stats.getCompleteCount());
    }

}
