/**
 * Copyright (C) 2015 JabRef contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package net.sf.jabref.logic.logging;

import static org.junit.Assert.*;
import org.junit.Test;

public class CacheTest {

    @Test
    public void testCaching() {
        Cache cache = new Cache(2);
        assertEquals("", cache.get());

        cache.add("1");
        assertEquals("1", cache.get());

        cache.add("2");
        assertEquals("12", cache.get());

        cache.add("3");
        assertEquals("23", cache.get());
    }

}