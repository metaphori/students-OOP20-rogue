package rogue.view;

import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import rogue.model.Entity;
import rogue.model.World;
import rogue.model.creature.Monster;
import rogue.model.creature.Player;
import rogue.model.items.Item;
import rogue.model.world.Tile;

public class WorldBox extends HBox {
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

    private Image getImage(final Tile tile) {
        final String variant = tile.isWall() ? "WALL" : "FLOOR";
        final String material = tile.getMaterial().toString();

        return new Image(ClassLoader.getSystemResource("images/" + variant + "-" + material + ".png").toExternalForm());
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
