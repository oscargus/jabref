package net.sf.jabref.logic.statistics;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import net.sf.jabref.Globals;
import net.sf.jabref.JabRefPreferences;
import net.sf.jabref.importer.ParserResult;
import net.sf.jabref.importer.fileformat.BibtexParser;
import net.sf.jabref.model.database.BibDatabaseMode;

public class DatabaseStatisticsTest {

    @Before
    public void setUp() {
        Globals.prefs = JabRefPreferences.getInstance();
    }

    @Test
    public void test() throws IOException {
        FileInputStream testBibtexFile = new FileInputStream("src/test/resources/testbib/complex.bib");
        Charset encoding = StandardCharsets.UTF_8;
        ParserResult result = BibtexParser.parse(new InputStreamReader(testBibtexFile, encoding));
        DatabaseStatistics dbStats = new DatabaseStatistics(result.getDatabase(), BibDatabaseMode.BIBLATEX);
        List<EntryTypeStatistic> list = dbStats.getEntryStatsList();
        assertEquals(3, list.size());
        assertEquals(19, dbStats.getTotalEntries());
        assertEquals(18, dbStats.getCompleteEntries());
        assertEquals(0, dbStats.getCrossrefEntries());
        assertEquals(2, dbStats.getStrings());

        // Sort in alphabetical order
        list.sort(new EntryTypeStatisticComparator(EntryTypeStatisticComparator.StatisticsSortOrder.TYPE));
        assertEquals("article", list.get(0).getType());
        assertEquals("book", list.get(1).getType());
        assertEquals("inproceedings", list.get(2).getType());

        // Sort based on total number of entries
        list.sort(new EntryTypeStatisticComparator(EntryTypeStatisticComparator.StatisticsSortOrder.TOTAL));
        assertTrue(list.get(0).getTotalCount() <= list.get(1).getTotalCount());
        assertTrue(list.get(1).getTotalCount() <= list.get(2).getTotalCount());

        // Sort based on total number of complete entries
        list.sort(new EntryTypeStatisticComparator(EntryTypeStatisticComparator.StatisticsSortOrder.COMPLETE));
        assertTrue(list.get(0).getCompleteCount() <= list.get(1).getCompleteCount());
        assertTrue(list.get(1).getCompleteCount() <= list.get(2).getCompleteCount());

        // Sort based on total number of crossref entries
        list.sort(new EntryTypeStatisticComparator(EntryTypeStatisticComparator.StatisticsSortOrder.CROSSREF));
        assertTrue(list.get(0).getCrossrefCount() <= list.get(1).getCrossrefCount());
        assertTrue(list.get(1).getCrossrefCount() <= list.get(2).getCrossrefCount());
    }

}
