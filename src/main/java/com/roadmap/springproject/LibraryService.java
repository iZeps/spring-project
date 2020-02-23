package com.roadmap.springproject;

import com.roadmap.springproject.pojo.Box;
import com.roadmap.springproject.pojo.Card;
import com.roadmap.springproject.pojo.Shelf;

public interface LibraryService {

    Shelf getShelf(long id);

    Box getBox(long id);

    Card getCard(long id);

    String convertTextToIdentifier(String text);

    StringBuilder convertIdentifierToText(String number);

    long getIndexFromIdentifier(String number);

    String getIdentifierFromIndex(long index);

    long getShelfNumber(long numberIndex);

    long getBoxNumber(long numberIndex);

    long getCardNumber(long numberIndex);

    String getTextFromLibraryPosition(long shelf, long box, long place);

}
