package nl.khonraad.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.swing.JFrame;

import org.slf4j.Logger;

import nl.khonraad.gui.interactions.WidgetContainer;

@ApplicationScoped public class MainView {

    @Inject
    Logger          logger;

    @Inject
    WidgetContainer widgetContainer;

    JFrame          canvas;

    public void eventListener( @Observes VisualizeEvent event ) {

        // TODO make this programmable
        widgetContainer.visualize();
        //widgetContainer.applyStyles();

        canvas.validate();
        canvas.repaint();
    }

    public void run() {

        canvas = buildCanvas();
        canvas.setVisible( true );

        eventListener( new VisualizeEvent() );
    }

    private JFrame buildCanvas() {

        JFrame jFrame = new JFrame();

        jFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        jFrame.setTitle( chosenDisplayTitle() );
        jFrame.setSize( chosenDimensions() );

        jFrame.add( widgetContainer, BorderLayout.NORTH );

        return jFrame;
    }

    private String chosenDisplayTitle() {
        return getClass().getSimpleName();
    }

    private Dimension chosenDimensions() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height * 3 / 4;
        final double GOLDEN_RATIO = 1.61803398875;
        Double goldenHeight = height * GOLDEN_RATIO;
        int width = goldenHeight.intValue();
        return new Dimension( width, height );
    }
}