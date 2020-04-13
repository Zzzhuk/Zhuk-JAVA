package com.lab.tests;

import com.lab.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class PersonTest {

    @Test
    void testEquals_NotEqualObjects_ReturnsFalse() {
        Person p1 = new Person("Alex", "Zhuk", 18, "male");
        Person p2 = new Person("Diana", "Lalaal", 100, "female");
        Assert.assertNotEquals(p2, p1);
    }

    @Test
    void testEquals_EqualObjects_ReturnsTrue() {
        Person p1 = new Person("Diana", "Lalaal", 100, "female");
        Person p2 = new Person("Diana", "Lalaal", 100, "female");
        Assert.assertEquals(p2, p1);
    }

    @Test
    void testFromToJSON_ValidJSON_ReturnsPerson() {
        Person p = new Person("Diana", "Lalaal", 100, "female");
        String json = p.toJSON();
        Person personFromJSON = Person.fromJSON(json);
        Assert.assertEquals(p, personFromJSON);
    }


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).verify();
    }
}