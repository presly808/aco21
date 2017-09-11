package ua.artcode.week2.db;

import ua.artcode.week2.model.CardGroup;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
// CRUD - Create, Read, Update, Delete
public interface GroupDao {


    CardGroup create(CardGroup cardGroup);
    CardGroup findOne(int id);
    CardGroup update(CardGroup newCardGroup, int id);
    CardGroup delete(int id);


}
