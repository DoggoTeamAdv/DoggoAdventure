package Game.Scene_Stuff;

import Game.Item.*;
import Game.Item.Food.Fish;


import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Scene> scenes = new ArrayList<Scene>();


    public Map() {
        Scene scene;

        scene = new Scene("Start", "It's a beautiful day to be the most famous crypto!");
        scene.addItem(new Key("Rusty Key", "A key that opens a chest"));
        addScene(scene);

        scene = new Scene("West Side", "Welcome to the West Side,wait..is that Will Smith?");
        scene.addItem(new Crypto("Bitcoin", "West sides crypto"));
        addScene(scene);


        scene = new Scene("China Town", "Ching Chang Chong,shame the door of the diner is locked");
        scene.addItem(new Key("Ching Chong Key", "A key that opens the door"));
        scene.addItem(new Crypto("Etherium", "China towns crypto"));
        scene.addItem(new Fish("Fish", "A drowning fish"));
        addScene(scene);

        scene = new Scene("Old House", "A rusty old house, my dog sense smells something in there");
        //scene.addItem(new Item("Chest", "A chest with a key and a crypto inside"));
        scene.addItem(new Weapon("Axe", "An axe that breaks doors"));
        scene.addItem(new Crypto("Luna", "Old houses crypto"));
        addScene(scene);

        scene = new Scene("Pigeons", "Cooo cooooo,those pigeons seem very anxious");
        scene.addItem(new Crypto("Solana", "Pigeons crypto"));
        addScene(scene);

        scene = new Scene("Castle", "That's a big castle,with a big lock on its entrance");
        addScene(scene);

        //Pigeons
        linkHorizontally(getScene("Pigeons"),getScene("Old House"));
        linkHorizontally(getScene("West Side"),getScene("Pigeons"));

        //Start
        linkHorizontally(getScene("West Side"), getScene("Start"));
        linkHorizontally(getScene("Start"),getScene("Old House"));
        linkVertically(getScene("Castle"),getScene("Start"));
        linkVertically(getScene("Start"),getScene("Pigeons"));

        //West Side
        linkVertically(getScene("West Side"),getScene("China Town"));





    }

    public Scene getScene(String sceneStr) {
        if (sceneStr.isEmpty()) {
            return null;
        }
        for (Scene scene : scenes) {
            if (scene.getName().equals(sceneStr)) {
                return scene;
            }
        }
        return null;
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
    }

    public void linkHorizontally(Scene westScene, Scene eastScene) {
        westScene.setEast(eastScene);
        eastScene.setWest(westScene);
    }

    public void linkVertically(Scene northScene, Scene southScene) {
        northScene.setSouth(southScene);
        southScene.setNorth(northScene);
    }
}
