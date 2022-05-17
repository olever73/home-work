package de.telran.shapes;

import de.telran.shapes.entity.Line;
import de.telran.shapes.entity.Picture;
import de.telran.shapes.entity.Shape;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShapeWorkflow implements CommandLineRunner {
    private final List<Line> lines;
    private final Picture picture;
    private final Picture picture2;

    public ShapeWorkflow(List<Line> lines, Picture picture, Picture picture2) {
        this.lines = lines;
        this.picture = picture;
        this.picture2 = picture2;
    }


    @Override
    public void run(String... args) throws Exception {
        picture.draw();

        picture2.draw();

        lines.forEach(Shape::draw);
    }
}
