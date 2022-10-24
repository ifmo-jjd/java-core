package ru.itmo.lessons.lesson14;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

class TitleComparator implements Comparator<Magazine> {

    @Override
    public int compare(Magazine o1, Magazine o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

class PicturesCountComparator implements Comparator<Magazine> {
    @Override
    public int compare(Magazine o1, Magazine o2) {
        return o1.getPictures().size() - o2.getPictures().size();
    }
}

public class Magazine implements Comparable<Magazine>{

    @Override
    public int compareTo(Magazine o) {
        return Integer.compare(this.pageCount, o.pageCount);
    }

    private String title;
    private int pageCount;
    private HashSet<String> pictures;

    public Magazine(String title, int pageCount, HashSet<String> pictures) {
        this.title = title;
        this.pageCount = pageCount;
        this.pictures = pictures;
    }

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public HashSet<String> getPictures() {
        return pictures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Magazine magazine = (Magazine) o;

        if (pageCount != magazine.pageCount) return false;
        return Objects.equals(title, magazine.title);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + pageCount;
        return result;
    }


}
