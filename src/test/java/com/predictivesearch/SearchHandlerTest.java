package com.predictivesearch;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SearchHandlerTest {

    private SearchHandler handler;

    @Before
    public void init() {
        handler = new SearchHandler();
        assertNotNull(handler);
    }

    @Test
    public void testSearchForOneMatch() throws Exception {
        List<String> sortedItems = new LinkedList();
        sortedItems.add("abc");
        sortedItems.add("bcd");
        sortedItems.add("cde");
        sortedItems.add("def");
        sortedItems.add("efg");
        sortedItems.add("fgh");
        sortedItems.add("ghij");
        sortedItems.add("hijklm");

        List<String> searchResult = handler.search(sortedItems, "ef");

        assertEquals(1, searchResult.size());
        assertEquals("efg", searchResult.get(0));
    }

    @Test
    public void testSearchForMoreThanOneMatch() throws Exception {
        List<String> sortedItems = new LinkedList();
        sortedItems.add("abc");
        sortedItems.add("abcd");
        sortedItems.add("abdef");
        sortedItems.add("def");
        sortedItems.add("efg");
        sortedItems.add("fgh");
        sortedItems.add("ghij");
        sortedItems.add("hijklm");

        List<String> searchResult = handler.search(sortedItems, "ab");

        assertEquals(3, searchResult.size());
        assertEquals("abcd", searchResult.get(0));
        assertEquals("abc", searchResult.get(1));
        assertEquals("abdef", searchResult.get(2));
    }

    @Test
    public void testSearchForNotFound() throws Exception {
        List<String> sortedItems = new LinkedList();
        sortedItems.add("abc");
        sortedItems.add("bcd");
        sortedItems.add("cde");
        sortedItems.add("def");
        sortedItems.add("efg");
        sortedItems.add("fgh");
        sortedItems.add("ghij");
        sortedItems.add("hijklm");

        List<String> searchResult = handler.search(sortedItems, "Z");

        assertEquals(0, searchResult.size());
    }

    @Test
    public void testSearchForEmptyList() throws Exception {
        List<String> sortedItems = new LinkedList();

        List<String> searchResult = handler.search(sortedItems, "Z");

        assertEquals(0, searchResult.size());
    }

    @Test
    public void testSearchForEmptyListAndEmptySearchString() throws Exception {
        List<String> sortedItems = new LinkedList();

        List<String> searchResult = handler.search(sortedItems, "");

        assertEquals(0, searchResult.size());
    }

    @Test
    public void testSearchForNonEmptyListAndEmptySearchString() throws Exception {
        List<String> sortedItems = new LinkedList();
        sortedItems.add("abc");
        sortedItems.add("bcd");
        sortedItems.add("cde");
        sortedItems.add("def");
        sortedItems.add("efg");
        sortedItems.add("fgh");
        sortedItems.add("ghij");
        sortedItems.add("hijklm");

        List<String> searchResult = handler.search(sortedItems, "");

        assertEquals(0, searchResult.size());
    }

    @Test
    public void testSearchForNonEmptyListAndNullSearchString() throws Exception {
        List<String> sortedItems = new LinkedList();
        sortedItems.add("abc");
        sortedItems.add("bcd");
        sortedItems.add("cde");
        sortedItems.add("def");
        sortedItems.add("efg");
        sortedItems.add("fgh");
        sortedItems.add("ghij");
        sortedItems.add("hijklm");

        List<String> searchResult = handler.search(sortedItems, null);

        assertEquals(0, searchResult.size());
    }

    @Test
    public void testSearchForNullListAndNullSearchString() throws Exception {
        List<String> searchResult = handler.search(null, null);

        assertEquals(0, searchResult.size());
    }

    @Test
    public void testSearchForNonEmptyListAndSpaceSearchString() throws Exception {
        List<String> sortedItems = new LinkedList();
        sortedItems.add("abc");
        sortedItems.add(" bc");
        sortedItems.add("bcd");
        sortedItems.add("cde");
        sortedItems.add("def");
        sortedItems.add("efg");
        sortedItems.add("fgh");
        sortedItems.add("ghij");
        sortedItems.add("hijklm");

        List<String> searchResult = handler.search(sortedItems, " ");

        assertEquals(1, searchResult.size());
        assertEquals(" bc", searchResult.get(0));
    }

}
