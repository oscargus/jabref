/*  Copyright (C) 2016 JabRef contributors.
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/

package net.sf.jabref.logic.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import net.sf.jabref.model.database.BibDatabase;
import net.sf.jabref.model.database.BibDatabaseMode;
import net.sf.jabref.model.entry.BibEntry;
import net.sf.jabref.model.entry.TypedBibEntry;

public class DatabaseStatistics {

    private final Map<String, EntryTypeStatistic> statMap = new HashMap<>();

    private BibDatabase db;
    private BibDatabaseMode mode;

    private int completeEntries;
    private int crossrefEntries;


    public DatabaseStatistics(BibDatabase db, BibDatabaseMode mode) {
        this.db = Objects.requireNonNull(db);
        this.mode = mode;
        updateStats();
    }

    private void updateStats() {
        statMap.clear();
        for (BibEntry entry : db.getEntries()) {
            String type = entry.getType();
            EntryTypeStatistic stats = statMap.get(type);
            if (stats == null) {
                stats = new EntryTypeStatistic(type);
            }
            stats.increaseTotalCount();
            TypedBibEntry typedEntry = new TypedBibEntry(entry, mode);
            if (typedEntry.hasAllRequiredFields()) {
                stats.increaseCompleteCount();
                completeEntries++;
            }
            if (entry.hasField("crossref")) {
                stats.increaseCrossrefCount();
                crossrefEntries++;
            }
            statMap.put(type, stats);
        }
    }

    public void setDatabase(BibDatabase db, BibDatabaseMode mode) {
        this.db = Objects.requireNonNull(db);
        this.mode = mode;
    }

    public List<EntryTypeStatistic> getEntryStatsList() {
        return new ArrayList<>(statMap.values());
    }

    public int getTotalEntries() {
        return db.getEntryCount();
    }

    public int getCompleteEntries() {
        return completeEntries;
    }

    public int getCrossrefEntries() {
        return crossrefEntries;
    }

    public int getStrings() {
        return db.getStringCount();
    }
}
