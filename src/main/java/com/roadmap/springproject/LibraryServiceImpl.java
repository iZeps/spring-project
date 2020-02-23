package com.roadmap.springproject;

import com.roadmap.springproject.pojo.Box;
import com.roadmap.springproject.pojo.Card;
import com.roadmap.springproject.pojo.Shelf;
import com.roadmap.springproject.util.StorageDimensions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

//    private final Shelf shelf = new Shelf();
//    private final Box box = new Box();
//    private final Card card = new Card();

    @Override
    public Shelf getShelf(long id) {
        return new Shelf(id);
    }

    @Override
    public Box getBox(long id) {
        return new Box(id);
    }

    @Override
    public Card getCard(long id) {
        return new Card(id);
    }

    public String convertTextToIdentifier(String text) {
        long result = 0;
        int textLength = text.length();

        for (int i = textLength - 1; i >= 0; i--) {
            result += (text.charAt(i) - 'a' + 1) * (long) Math.pow(100, textLength - i - 1);
        }
        return Long.toString(result);
    }

    public StringBuilder convertIdentifierToText(String number) {
        char[] charSet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int numberLength = number.length();
        if (numberLength % 2 != 0)
            number = "0" + number;

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < number.length() / 2; i++) {
            result.append(charSet[Integer.parseInt(number.substring(i * 2, i * 2 + 2)) - 1]);
        }
        return result;
    }

    public long getIndexFromIdentifier(String number) {
        if (number.length() % 2 != 0)
            number = "0" + number;

        long[] temp = new long[number.length() / 2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(number.substring(i * 2, i * 2 + 2));
        }

        long result = 0;
        for (int i = 0; i + 1 < temp.length; i++) {
            temp[i + 1] += temp[i] * 26;
        }
        result += temp[temp.length - 1];

        return result;
    }

    public String getIdentifierFromIndex(long index) {
        List<Long> temp = new ArrayList<>();
        temp.add(index);
        for (int i = 0; temp.get(i) / 26 >= 1; i++) {
            temp.add((temp.get(i) % 26 == 0) ? temp.get(i) / 26 - 1 : temp.get(i) / 26);
            temp.set(i, (temp.get(i) % 26 == 0) ? 26 : temp.get(i) % 26 );
        }
        Collections.reverse(temp);
        StringBuilder result = new StringBuilder();
        for (Long single : temp) {
            String tmp = single.toString();
            if (tmp.length() < 2)
                tmp = "0" + tmp;
            result.append(tmp);
        }
        return Long.toString(Long.parseLong(result.toString()));
    }

    public long getShelfNumber(long numberIndex) {
        if (numberIndex % StorageDimensions.CARDS_PER_SHELF == 0)
            return numberIndex / StorageDimensions.CARDS_PER_SHELF;

        return numberIndex / StorageDimensions.CARDS_PER_SHELF + 1;
    }

    public long getBoxNumber(long numberIndex) {
        if (numberIndex > StorageDimensions.CARDS_PER_SHELF)
            numberIndex = numberIndex - (getShelfNumber(numberIndex) - 1) * StorageDimensions.CARDS_PER_SHELF;

        if (numberIndex % StorageDimensions.CARDS_PER_BOX == 0)
            return numberIndex / StorageDimensions.CARDS_PER_BOX;

        return numberIndex / StorageDimensions.CARDS_PER_BOX + 1;
    }

    public long getCardNumber(long numberIndex) {
        if (numberIndex > StorageDimensions.CARDS_PER_SHELF)
            numberIndex = numberIndex - (getShelfNumber(numberIndex) - 1) * StorageDimensions.CARDS_PER_SHELF;

        if (numberIndex > StorageDimensions.CARDS_PER_BOX)
            numberIndex = numberIndex - (getBoxNumber(numberIndex) - 1) * StorageDimensions.CARDS_PER_BOX;

        return numberIndex;
    }

    public String getTextFromLibraryPosition(long shelf, long box, long place) {
        long result = (shelf - 1) * StorageDimensions.CARDS_PER_SHELF + (box - 1) * StorageDimensions.CARDS_PER_BOX + place;
        return convertIdentifierToText(getIdentifierFromIndex(result)).toString();
    }

}
