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

import java.util.Comparator;

public class EntryTypeStatisticComparator implements Comparator<EntryTypeStatistic> {

    public enum StatisticsSortOrder {
        TYPE,
        TOTAL,
        COMPLETE,
        CROSSREF
    }


    private final StatisticsSortOrder order;


    public EntryTypeStatisticComparator(StatisticsSortOrder order) {
        this.order = order;
    }

    @Override
    public int compare(EntryTypeStatistic stat0, EntryTypeStatistic stat1) {
        switch (order) {
        case TYPE:
            return stat0.getType().compareTo(stat1.getType());
        case TOTAL:
            return stat0.getTotalCount() - stat1.getTotalCount();
        case COMPLETE:
            return stat0.getCompleteCount() - stat1.getCompleteCount();
        case CROSSREF:
            return stat0.getCrossrefCount() - stat1.getCrossrefCount();
        default:
            break;
        }

        return 0;
    }

}
