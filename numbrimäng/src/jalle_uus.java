import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;


/**
 *
 * @author alessandrovivas
 */
public class jalle_uus extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Numbrimang");

        GridPane gridPane = new GridPane();
        ToggleButton[][] btn = new ToggleButton[40][40];
        int ridahelper = 1;
        int lammas = 0;
        int kass = 0;
        ArrayList<ToggleButton> list = new ArrayList<ToggleButton>();

        for (int j = 0; j < 3; j++) {//read
            for (int i = 1; i < 10; i++) {// tulbad
                btn[i][j] = new ToggleButton();
                if (j == 0) {
                    btn[i][j].setText("" + i);
                } else {
                    if (lammas % 2 == 0) {
                        btn[i][j].setText("" + 1);
                        lammas += 1;
                    } else {
                        btn[i][j].setText("" + ridahelper);
                        ridahelper += 1;
                        lammas += 1;
                        if (ridahelper > 9) {
                            ridahelper = 1;
                        }
                    }
                }
                btn[i][j].setPrefSize(50, 50);
                gridPane.add(btn[i][j], i, j);
                list.add(btn[i][j]);
                final ToggleButton test = btn[i][j];
                btn[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        test.setStyle("-fx-background-color: #000000; ");
                        list.remove(test);
                    }
                });
            }

        }
        ToggleButton nupp = new ToggleButton();
        gridPane.add(nupp, 11, 0);
        nupp.setPrefSize(150, 50);
        nupp.setText("Kliki siia");
        nupp.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                System.out.println(list);
                int i = 1;
                int j = 3;
                for (int a = 0; a < list.size(); a++) {//loon nii palju nupper juurde kui vaja
                    ToggleButton lisatav = new ToggleButton();//loon nupu koopia
                    lisatav.setText(list.get(a).getText());
                    lisatav.setPrefSize(50, 50);
                    gridPane.add(lisatav, i, j);
                    i += 1;
                    if (i > 9) {
                        j += 1;
                        i = 1;
                    }
                }
            }
        });
        Scene scene = new Scene(gridPane, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

