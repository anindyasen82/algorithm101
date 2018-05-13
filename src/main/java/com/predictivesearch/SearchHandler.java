package com.predictivesearch;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

public class SearchHandler {

    public List<String> search(List<String> sortedItems, String searchString) {
        List<String> searchResult = new LinkedList();

        if(sortedItems == null || sortedItems.size() == 0 ||
                searchString == null || searchString.isEmpty()) { // Nothing to search for
            return searchResult;
        }

        SearchResult firstMatchUsingBinarySearch = getFirstMatchUsingBinarySearch(sortedItems, searchString,
                0, sortedItems.size() - 1);

        if(firstMatchUsingBinarySearch == null) { // No match found
            return searchResult;
        }

        searchResult.add(firstMatchUsingBinarySearch.getResult());
        searchResult.addAll(getAllMatchFromLeft(sortedItems, searchString, firstMatchUsingBinarySearch.getIndex()));
        searchResult.addAll(getAllMatchFromRight(sortedItems, searchString, firstMatchUsingBinarySearch.getIndex()));
        return searchResult;
    }

    private SearchResult getFirstMatchUsingBinarySearch(List<String> sortedItems, String searchString, int startIndex, int endIndex) {
        if(startIndex < 0 ||
                endIndex < 0 ||
                startIndex >= sortedItems.size() ||
                endIndex >= sortedItems.size()) { // Out of bound
            return null;
        }

        int midIndex = (startIndex + endIndex) / 2;
        String currentItem = sortedItems.get(midIndex);
        if(currentItem.startsWith(searchString)) {
            return new SearchResult(currentItem, midIndex);
        }

        if(searchString.compareTo(currentItem) > 0) { // Search Right
            return getFirstMatchUsingBinarySearch(sortedItems, searchString, midIndex + 1, endIndex);
        } else { // Search Left
            return getFirstMatchUsingBinarySearch(sortedItems, searchString, startIndex, midIndex - 1);
        }
    }

    private List<String> getAllMatchFromLeft(List<String> sortedItems, String searchString, int index) {
        List<String> searchResult = new LinkedList();
        index--;
        while (index >= 0) {
            String currentItem = sortedItems.get(index);
            if(currentItem.startsWith(searchString)) {
                searchResult.add(currentItem);
                index--;
            } else {
                break;
            }
        }

        return searchResult;
    }

    private List<String> getAllMatchFromRight(List<String> sortedItems, String searchString, int index) {
        List<String> searchResult = new LinkedList();
        index++;
        while (index < sortedItems.size()) {
            String currentItem = sortedItems.get(index);
            if(currentItem.startsWith(searchString)) {
                searchResult.add(currentItem);
                index++;
            } else {
                break;
            }
        }

        return searchResult;
    }

    @AllArgsConstructor
    @Getter
    public static class SearchResult {
        private String result;
        private int index;
    }
}