package com.lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void find() {
        String s = "Decisively advantages nor expression unpleasing she led met";
        String[] splited = s.split("\\s+");

        List<String> testArr = Main.find(splited);

        List<String> resultArr = new ArrayList<>(Arrays.asList("nor"));

        assertEquals(testArr, resultArr);
    }
}