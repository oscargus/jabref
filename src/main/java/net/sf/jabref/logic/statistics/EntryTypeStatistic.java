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


public class EntryTypeStatistic {

    private final String type;
    private int totalCount;
    private int completeCount;
    private int crossrefCount;

    public EntryTypeStatistic(String type) {
        this.type = type;
    }

    public void increaseTotalCount() {
        totalCount++;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void increaseCompleteCount() {
        completeCount++;
    }

    public int getCompleteCount() {
        return completeCount;
    }

    public int getCrossrefCount() {
        return crossrefCount;
    }

    public String getType() {
        return type;
    }

    public void increaseCrossrefCount() {
        crossrefCount++;
    }

    @Override
    public String toString() {
        return type + ": " + completeCount + "total (" + completeCount + " complete, " + crossrefCount
                + " with crossref)";
    }
}
