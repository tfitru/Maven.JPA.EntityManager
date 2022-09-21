package services;

import entities.Artist;
import entities.Cd;
import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CdServiceTest {
    EntityMan entityMan = new EntityMan();
    Artist jacob = new Artist();
    Cd flutePlayer = new Cd();


    @Test
    public void CdCreate_Artist_Jacob(){
        jacob.setFirst_name("Jacob");
        jacob.setInstrument("Flute");
        jacob.setLast_name("Boom");
        entityMan.create(jacob);
        flutePlayer.setTitle("FluteSong");
        flutePlayer.setPrice("$50");
        flutePlayer.setYear("1995");
        flutePlayer.getArtistList().add(jacob);

        entityMan.create(flutePlayer);
        jacob.setCd(flutePlayer);
        entityMan.update(jacob);

        Assert.assertEquals(entityMan.findByIdCd(flutePlayer.getId()).getTitle(), "FluteSong");
    }

    @Test
    public void findCdById(){

        Cd cd = entityMan.findByIdCd(flutePlayer.getId());

        Assert.assertEquals(cd.getTitle(), flutePlayer.getTitle());
    }

    @Test
    public void updateCd() {

        Cd cd = entityMan.findByIdCd(flutePlayer.getId());
        cd.setTitle("FlutePlayer2");
        entityMan.update(cd);

        Assert.assertEquals(cd.getTitle(), entityMan.findByIdCd(flutePlayer.getId()).getTitle());

    }

    @AfterTest
    public void deleteCd(){

        entityMan.delete(flutePlayer);
        Assert.assertNull(entityMan.findById(flutePlayer.getId()));
    }


}
