package ua.artcode.week2.controller;

import ua.artcode.week2.model.Card;
import ua.artcode.week2.model.CardGroup;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public interface MainController {


    boolean createGroup(CardGroup group);
    boolean addCard(Card card, int groupId);
    Card removeCard(int cardId);
    Card removeCard(int cardId, int groupId);
    CardGroup[] getAllGroups();
    Card[] getCards(int groupId);



}
