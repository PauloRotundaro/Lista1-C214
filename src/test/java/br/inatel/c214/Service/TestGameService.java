package br.inatel.c214.Service;

import br.inatel.c214.Csv.CsvRead;
import br.inatel.c214.Models.Game;
import br.inatel.c214.Models.Platform;
import br.inatel.c214.Models.Publisher;
import br.inatel.c214.Services.GameService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestGameService {

    private static List<Game> gameList;

    @BeforeClass
    public static void initClass() throws URISyntaxException {
        Path caminho = Paths.get(ClassLoader.getSystemResource("vendas-games.csv").toURI());
        gameList = CsvRead.readCsv(caminho);
    }

    @Test
    public void testAtariGames(){
        List<Game> atariGames = GameService.getByPlatform(gameList, Platform.A2600);

        Assert.assertEquals(1,atariGames.size());
    }

    @Test
    public void testPS4Games(){
        List<Game> ps4Games = GameService.getByPlatform(gameList, Platform.PS4);

        Assert.assertEquals(5,ps4Games.size());
    }

    @Test
    public void testPS2Games(){
        List<Game> ps2Games = GameService.getByPlatform(gameList, Platform.PS2);

        Assert.assertEquals(6,ps2Games.size());
    }

    @Test
    public void testWiiGames(){
        List<Game> wiiGames = GameService.getByPlatform(gameList, Platform.Wii);

        Assert.assertEquals(15,wiiGames.size());
    }

    @Test
    public void testPSPGames(){
        List<Game> pspGames = GameService.getByPlatform(gameList, Platform.PSP);

        Assert.assertEquals(1,pspGames.size());
    }

    @Test
    public void testActivisionGames(){
        List<Game> activisionGames = GameService.getByPublisher(gameList, Publisher.Activision);

        Assert.assertEquals(14,activisionGames.size());
    }

    @Test
    public void testMicrosoftGames(){
        List<Game> microsoftGames = GameService.getByPublisher(gameList, Publisher.MicrosoftGameStudios);

        Assert.assertEquals(6,microsoftGames.size());
    }

    @Test
    public void testNintendoGames(){
        List<Game> nintendoGames = GameService.getByPublisher(gameList, Publisher.Nintendo);

        Assert.assertEquals(52,nintendoGames.size());
    }

    @Test
    public void testUbisoftGames(){
        List<Game> ubisoftGames = GameService.getByPublisher(gameList, Publisher.Ubisoft);

        Assert.assertEquals(2,ubisoftGames.size());
    }

    @Test
    public void testEAGames(){
        List<Game> eaGames = GameService.getByPublisher(gameList, Publisher.ElectronicArts);

        Assert.assertEquals(5,eaGames.size());
    }
}
