/*********************************************************************************************************************
 *********************************************************************************************************************
 *****  Class: CSC-360-001-2019-040    Semester: Summer 2019    Professor: Richard Fox    Student: Ryan Huffman  *****
 *****-----------------------------------------------------------------------------------------------------------*****
 *****                                       Programming Assignment #5                                           *****
 *****                                               Program #3                                                  *****
 *****___________________________________________________________________________________________________________*****
 *****                 3. Implement a program to recursively draw what looks to be a snowflake.                  *****
 *****               Draw six Lines, then draw six Lines at the endpoints of those lines and so on.              *****
 *********************************************************************************************************************
 *********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage){
        // Create and Initialize the Pane and Set the Pane's background Color
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #EEEEEE");

        // Call the recursive method to draw the snowflake
        drawSimpleSnowflake(pane, 300, 300, 100, 4);

        // Create the Scene, Set the Title of the Scene, Set the Scene to the Stage, Show the Stage
        Scene scene = new Scene(pane, 600, 600);
        primaryStage.setTitle("Snowflake: Programming Assignment #5, Problem #3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    // Recursive method to draw what looks to be a snowflake
    public void drawSimpleSnowflake(Pane p, double x1, double y1, double length, int n){

        // Base case to test that "n" is greater than 0
        if(n > 0){
            // Use the properties of a 30-60-90 triangle to draw six Lines and Set the Color of the Lines
            Line line1 = new Line(x1, y1, (x1 + length), y1);
            line1.setStroke(Color.rgb(92, 92, 248, 1.0));
            Line line2 = new Line(x1, y1, (x1 + (length / 2)), (y1 + ((length / 2) * Math.sqrt(3))));
            line2.setStroke(Color.rgb(92, 92, 248, 1.0));
            Line line3 = new Line(x1, y1, (x1 - (length / 2)), (y1 + ((length / 2) * Math.sqrt(3))));
            line3.setStroke(Color.rgb(92, 92, 248, 1.0));
            Line line4 = new Line(x1, y1, (x1 - length), y1);
            line4.setStroke(Color.rgb(92, 92, 248, 1.0));
            Line line5 = new Line(x1, y1, (x1 - (length / 2)), (y1 - ((length / 2) * Math.sqrt(3))));
            line5.setStroke(Color.rgb(92, 92, 248, 1.0));
            Line line6 = new Line(x1, y1, (x1 + (length / 2)), (y1 - ((length / 2) * Math.sqrt(3))));
            line6.setStroke(Color.rgb(92, 92, 248, 1.0));

            // Add the six Lines to the Pane
            p.getChildren().addAll(line1, line2, line3, line4, line5, line6);

            // Recursively call this same method with the endpoint of each of the above six lines,
                // dividing the length by 4 and subtracting 1 from n, so that when n reaches 0,
                // the recursion stops and the method ends
            drawSimpleSnowflake(p, (x1 + length), y1, (length / 3), (n - 1));
            drawSimpleSnowflake(p, (x1 + (length / 2)), (y1 + ((length / 2) * Math.sqrt(3))), (length / 3), (n - 1));
            drawSimpleSnowflake(p, (x1 - (length / 2)), (y1 + ((length / 2) * Math.sqrt(3))), (length / 3), (n - 1));
            drawSimpleSnowflake(p, (x1 - length), y1, (length / 3), (n - 1));
            drawSimpleSnowflake(p, (x1 - (length / 2)), (y1 - ((length / 2) * Math.sqrt(3))), (length / 3), (n - 1));
            drawSimpleSnowflake(p, (x1 + (length / 2)), (y1 - ((length / 2) * Math.sqrt(3))), (length / 3), (n - 1));
        }
    }
}
