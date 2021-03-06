package QLS.parsing.visitors;

import QLS.classes.properties.ColorProperty;
import QLS.classes.properties.FontProperty;
import QLS.classes.properties.FontSizeProperty;
import QLS.classes.properties.WidthProperty;
import QLS.parsing.gen.QLSBaseVisitor;
import QLS.parsing.gen.QLSParser;

import java.awt.*;

public class PropertyVisitor extends QLSBaseVisitor {

    @Override
    public WidthProperty visitWidthproperty(QLSParser.WidthpropertyContext ctx) {
        return new WidthProperty(Integer.parseInt(ctx.INT().getText()));

    }

    @Override
    public FontProperty visitFontproperty(QLSParser.FontpropertyContext ctx) {
        return new FontProperty(ctx.STR().toString());
    }

    @Override
    public FontSizeProperty visitFontsizeproperty(QLSParser.FontsizepropertyContext ctx) {
        return new FontSizeProperty(Integer.parseInt(ctx.INT().getText()));
    }

    @Override
    public ColorProperty visitColorproperty(QLSParser.ColorpropertyContext ctx) {
        return new ColorProperty(Color.decode(ctx.CLR().getText()));
    }
}
