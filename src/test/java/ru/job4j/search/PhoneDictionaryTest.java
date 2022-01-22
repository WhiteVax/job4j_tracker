package ru.job4j.search;

import java.util.ArrayList;
import org.junit.Test;
import org.hamcrest.collection.IsEmptyCollection;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenNotFound() {
        PhoneDictionary phone = new PhoneDictionary();
        phone.add(
                new Person("Vlad", "Sergo", "439582", "Minsk")
        );
        ArrayList<Person> list = phone.find("Petr");
        assertThat(list, is(IsEmptyCollection.empty()));
    }
}
