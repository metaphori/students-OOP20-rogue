package rogue.view;

import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import rogue.model.Entity;
import rogue.model.creature.Monster;
import rogue.model.creature.Player;
import rogue.model.items.Item;
import rogue.model.world.Tile;

public class WorldBox extends HBox {
    private static final Random RANDOM = new Random();
    private static final int VINE_VARIANT_COUNT = 7;
    private static final int SCALE = 25;
    private final Canvas tileCanvas, entityCanvas;

    public WorldBox(final int width, final int height) {
        super();

        this.tileCanvas = new Canvas(width * SCALE, height * SCALE);
        this.entityCanvas = new Canvas(width * SCALE, height * SCALE);

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

    public final void drawTiles(final Stream<Tile> tiles) {
        final GraphicsContext gc = tileCanvas.getGraphicsContext2D();
        tiles.forEach(tile -> {
            Image img = getImage(tile);

            // darker if floor
            final ColorAdjust ca = new ColorAdjust();
            ca.setBrightness(tile.isWall() ? 0 : -0.5);
            gc.setEffect(ca);

            gc.drawImage(img, tile.getX() * SCALE, tile.getY() * SCALE, SCALE, SCALE);
        });
    }

    public final void drawEntities(final Map<Entity, Tile> entityMap) {
        final GraphicsContext gc = entityCanvas.getGraphicsContext2D();
        gc.clearRect(0, 0, entityCanvas.getWidth(), entityCanvas.getHeight());

        entityMap.forEach((entity, tile) -> {
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
        if (entity instanceof Player) {
            return new Image(ClassLoader.getSystemResource("images/Player.png").toExternalForm());
        } else if (entity instanceof Item) {
            return new ItemImageGeneratorImpl().getImage((Item) entity);
        } else if (entity instanceof Monster) {
            return new MonsterImageGeneratorImpl().getImage((Monster) entity);
        }

        return new Image(ClassLoader.getSystemResource("images/emptyIcon.png").toExternalForm());
    }
}
