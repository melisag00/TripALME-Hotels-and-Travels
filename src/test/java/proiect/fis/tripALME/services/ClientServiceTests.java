package proiect.fis.tripALME.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientServiceTests {
    ClientService test;
    @Before
    public void setUp() throws Exception {
        test = new ClientService();
    }

    @After
    public void tearDown() throws Exception {
        test = null;
    }

    @Test
    public void displayHotels1() {

        JSONArray expected = new JSONArray();
        JSONObject a;

        expected.add("Baluba");

        JSONArray result = test.displayHotels("Arad");

        assertEquals(expected, result);
    }

    @Test
    public void writeRequest() {
    }
}