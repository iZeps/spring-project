package com.roadmap.springproject;

public interface LibraryService {

    String convertTextToIdentifier(String text);

    StringBuilder convertIdentifierToText(String number);

    long getIndexFromIdentifier(String number);

    String getIdentifierFromIndex(long index);

    long getShelfNumber(long numberIndex);

    long getBoxNumber(long numberIndex);

    long getCardNumber(long numberIndex);

    String getTextFromLibraryPosition(long shelf, long box, long place);

}
