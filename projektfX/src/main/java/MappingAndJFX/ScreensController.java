package MappingAndJFX;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.util.HashMap;

public class ScreensController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController(){
        super();
    }

    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }

    public Node getScreen(String name){
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource){
        try{
            //System.out.println("t0");
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            //System.out.println("t1");
            Parent loadScreen = (Parent) myLoader.load();
            //System.out.println("t2");
            ControlledScreenInterface myScreenController = ((ControlledScreenInterface) myLoader.getController());
            //System.out.println("t3");
            myScreenController.setScreenParent(this);
            //System.out.println("t4");
            addScreen(name, loadScreen);
            System.out.println(name+" - "+resource + " erfolgreich geladen!");
            return true;
        } catch(Exception e){
            System.out.println("yo" + e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name) {
        if(screens.get(name) != null) {
            final DoubleProperty opacity = opacityProperty();

            if (!getChildren().isEmpty()){
                setOpacity(0.0);
                getChildren().remove(0);
                getChildren().add(0, screens.get(name));
                setOpacity(1.0);
                //fade out
                /*Timeline fade = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        //if at 1000, triggers handler method
                        new KeyFrame(new Duration(1), new EventHandler<ActionEvent>() {
                     @Override
                     public void handle(ActionEvent t) {
                         getChildren().remove(0);
                         getChildren().add(0, screens.get(name));
                         //fade in
                         Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(1), new KeyValue(opacity, 1.0)));
                         fadeIn.play();
                     }
                }, new KeyValue(opacity, 0.0)));
                fade.play();*/

            }else {
                setOpacity(0.0);
                getChildren().add(screens.get(name));
                setOpacity(1.0);
                //just how the screen shows, fade here
                /*Timeline fadeIn = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                        new KeyFrame(new Duration(1), new KeyValue(opacity, 1.0)));
                fadeIn.play();*/
            }
            return true;
        } else {
            System.out.println("no screen has been loaded\n");
            return false;
        }
    }

    public boolean unloadScreen(String name) {
        if(screens.remove(name) == null){
            System.out.println("Screen does not exist\n");
            return false;
        } else {
            return true;
        }
    }

}
