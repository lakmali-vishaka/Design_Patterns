interface Text {
    String format();
}

// Concrete Component
class DefaultText implements Text {
    private String content;

    public DefaultText(String content) {
        this.content = content;
    }

    @Override
    public String format() {
        return content;
    }
}

// Abstract Decorator
abstract class TextDecorator implements Text {
    protected Text text;

    public TextDecorator(Text text) {
        this.text = text;
    }

    @Override
    public String format() {
        return text.format();
    }
}

// Concrete Decorator: Bold Text
class BoldText extends TextDecorator {
    public BoldText(Text text) {
        super(text);
    }

    @Override
    public String format() {
        return "<b>" + text.format() + "</b>";
    }
}

// Concrete Decorator: Italic Text
class ItalicText extends TextDecorator {
    public ItalicText(Text text) {
        super(text);
    }

    @Override
    public String format() {
        return "<i>" + text.format() + "</i>";
    }
}

// Client Code
public class TextFormatter {
    public static void main(String[] args) {
        // Create a simple text
        Text simpleText = new DefaultText("Hello, world!");

        // Decorate the text with Bold and Italic decorators
        Text boldText = new BoldText(simpleText);
        Text boldItalicText = new ItalicText(new BoldText(simpleText));

        // Output formatted texts
        System.out.println("Simple Text: " + simpleText.format());
        System.out.println("Bold Text: " + boldText.format());
        System.out.println("Bold Italic Text: " + boldItalicText.format());
    }
}

