package services;

import entities.Artist;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class EntityManTest {

    EntityMan entityMan = new EntityMan();
    Artist jacob = new Artist();



    @Test
    public void artistCreate_Jacob(){
        jacob.setFirst_name("Jacob");
        jacob.setInstrument("Flute");
        jacob.setLast_name("Boom");

        entityMan.create(jacob);

        Assert.assertEquals(entityMan.findById(1).getFirst_name(), jacob.getFirst_name());
    }





    @Test
    public void artistFindById_WithName(){
        Artist artist = entityMan.findById(1);
        Integer asserted = 1;

        Assert.assertEquals(artist.getIdArtist(), asserted);
    }


    @Test
    public void artistUpdate(){
        Artist artist = entityMan.findById(1);
        String expectedName = "Bill";
        artist.setFirst_name("Bill");
        entityMan.update(artist);

        Assert.assertEquals(artist.getFirst_name(), expectedName);
    }

    @AfterTest
    public void artistDelete(){
        Artist artist = entityMan.findById(1);
        entityMan.delete(artist);

        Assert.assertNull(entityMan.findById(1));
    }





}
