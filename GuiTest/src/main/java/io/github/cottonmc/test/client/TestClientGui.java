package io.github.cottonmc.test.client;

import java.util.ArrayList;
import java.util.function.BiConsumer;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WListPanel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import net.minecraft.text.LiteralText;

public class TestClientGui extends LightweightGuiDescription {

	public TestClientGui() {
		WGridPanel root = new WGridPanel();
		this.setRootPanel(root);
		
		WTextField text = new WTextField();
		text.setSuggestion("Test Suggestion");
		root.add(text, 0, 1, 8, 1);
		
		ArrayList<String> data = new ArrayList<>();
		data.add("This");
		data.add("is");
		data.add("a");
		data.add("test");
		data.add("of the");
		data.add("new");
		data.add("recycler-style");
		data.add("list");
		data.add("widget");
		BiConsumer<String, WLabel> configurator = (String s, WLabel label) -> {
			label.setText(new LiteralText(s));
		};
		WListPanel<String, WLabel> list = new WListPanel<String, WLabel>(data, WLabel.class, ()->new WLabel(""), configurator);
		root.add(list, 0, 2, 8, 8);
		
		root.validate(this);
	}

}
