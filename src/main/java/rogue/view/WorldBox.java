package rogue.view;

import java.util.Random;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import rogue.model.Entity;
import rogue.model.World;
import rogue.model.creature.Monster;
import rogue.model.creature.Player;
import rogue.model.items.Item;
import rogue.model.world.Tile;

public class WorldBox extends HBox {
    private static final Random RANDOM = new Random();
    private static final int VINE_VARIANT_COUNT = 7;
    private static final int SCALE = 25;
    private final World game;
    private final Canvas tileCanvas, entityCanvas;

    public WorldBox(final World game) {
        super();

        this.game = game;
        this.tileCanvas = new Canvas(game.getWidth() * SCALE, game.getHeight() * SCALE);
        this.entityCanvas = new Canvas(game.getWidth() * SCALE, game.getHeight() * SCALE);

        drawTiles();
        drawEntities();

        // layer the canvases
        BorderPane bp = new BorderPane();
        Pane p = new Pane();
        p.getChildren().add(tileCanvas);
        p.getChildren().add(entityCanvas);
        bp.setCenter(p);

        this.setStyle("-fx-background-color: #808080;");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(bp);
    }

    public final void drawTiles() {
        final GraphicsContext gc = tileCanvas.getGraphicsContext2D();
        game.getTiles().forEach(tile -> {
            Image img = getImage(tile);

            // darker if floor
            final ColorAdjust ca = new ColorAdjust();
            ca.setBrightness(tile.isWall() ? 0 : -0.5);
            gc.setEffect(ca);

            gc.drawImage(img, tile.getX() * SCALE, tile.getY() * SCALE, SCALE, SCALE);
        });
    }

    public final void drawEntities() {
        final GraphicsContext gc = entityCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, entityCanvas.getWidth(), entityCanvas.getHeight());

        game.getEntityMap().forEach((entity, tile) -> {
            Image img = getImage(entity);
            gc.drawImage(img, tile.getX() * SCALE, tile.getY() * SCALE, SCALE, SCALE);
        });
    }

    public final void drawGameOver() {
        this.getChildren().clear();

        Text text = new Text();
        text.setText("GAME OVER");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 100));
        this.getChildren().add(text);
    }

    private Image getImage(final Tile tile) {
        final String fileName = tile.isDoor() ? "dngn_closed_door" : "wall_vines" + RANDOM.nextInt(VINE_VARIANT_COUNT);
        return new Image(ClassLoader.getSystemResource("images/tiles/" + fileName + ".png").toExternalForm());
    }

    private Image getImage(final Entity entity) {
        String name = "emptyIcon";

        if (entity instanceof Player) {
            name = "Player";
        } else if (entity instanceof Item) {
            return new ItemImageGeneratorImpl().getImage((Item) entity);
        } else if (entity instanceof Monster) {
            return new MonsterImageGeneratorImpl().getImage((Monster) entity);
        }

        return new Image(ClassLoader.getSystemResource("images/" + name + ".png").toExternalForm());
    }
}
