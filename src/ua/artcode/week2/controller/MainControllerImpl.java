package ua.artcode.week2.controller;

import ua.artcode.week2.db.AppDB;
import ua.artcode.week2.model.Card;
import ua.artcode.week2.model.CardGroup;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class MainControllerImpl implements MainController {

    private AppDB appDB;

    public MainControllerImpl(AppDB appDB) {
        this.appDB = appDB;
    }

    @Override
    public boolean createGroup(CardGroup group) {
        return appDB.create(group) != null;
    }

    @Override
    public boolean addCard(Card card, int groupId) {
        CardGroup one = appDB.findOne(groupId);

        if(one == null){
            System.out.println("Group was not found");
            return false;
        }

        return one.getCards().add(card);
    }

    @Override
    public Card removeCard(int cardId) {

        //
        appDB.getCardGroups();

        return null;
    }

    @Override
    public Card removeCard(int cardId, int groupId) {
        return null;
    }

    @Override
    public CardGroup[] getAllGroups() {
        return new CardGroup[0];
    }

    @Override
    public Card[] getCards(int groupId) {
        return new Card[0];
    }
}
